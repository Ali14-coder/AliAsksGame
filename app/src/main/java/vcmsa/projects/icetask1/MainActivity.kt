package vcmsa.projects.icetask1

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONObject

private var currentScore = 0
private var highScore = 0
private var timePerRound = 11_000L // in milliseconds
private var correctStreak = 0
private var stableRounds = 0
private var currentTimer: CountDownTimer? = null

private const val PEXELS_API_KEY = "lVmRAAUsbE15GP4bvAp1Oqdd5D2toNrRaGl8kTY2pJ8lPVUXRmtpYgRF"

class MainActivity : AppCompatActivity() {
    private lateinit var txtCommand: TextView
    private lateinit var currentCorrectColour: String
    private lateinit var mainSoundtrack: MediaPlayer
    private lateinit var imgColorVisual: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //soundtrack initialization
        mainSoundtrack = MediaPlayer.create(this, R.raw.main_act_soundtrack);
        mainSoundtrack.isLooping = true
        mainSoundtrack.start()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }
        txtCommand = findViewById(R.id.txtCommand)
        //pexels image that will be shown
        imgColorVisual = findViewById(R.id.imgColorVisual)


        resetGame()
        Commands() //this calls the commands class and populates the command list
        getCommand()
        startTimer()
// Associating buttons with column of colour row
        findViewById<Button>(R.id.btnRed).setOnClickListener { handleButtonClick("Red") }
        findViewById<Button>(R.id.btnYellow).setOnClickListener { handleButtonClick("Yellow") }
        findViewById<Button>(R.id.btnGreen).setOnClickListener { handleButtonClick("Green") }
        findViewById<Button>(R.id.btnBlue).setOnClickListener { handleButtonClick("Blue") }

        proceed()

        val btnReturn = findViewById<ImageView>(R.id.btnMainBack)
        btnReturn.setOnClickListener {
            val intent = Intent(
                this,
                Welcome::class.java
            ) //opens the playing screen with the intent of the class. The old window is still present. It is NOT CLOSED
            startActivity(intent)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if (::mainSoundtrack.isInitialized) {
            mainSoundtrack.stop()
            mainSoundtrack.release()
        }
        currentTimer?.cancel()
    }
    private fun getCommand() {
        val randomCommand =
            commmandData.random() //this will return a random command from the commands data list

        val set = listOf(
            randomCommand.Red,
            randomCommand.Yellow,
            randomCommand.Green,
            randomCommand.Blue
        ).random()

        txtCommand.text = set
    }

    private fun proceed() {
        val randomCommand = commmandData.random()

        // Linking the colour to the random command column
        val colourMap = mapOf(
            "Red" to randomCommand.Red,
            "Yellow" to randomCommand.Yellow,
            "Green" to randomCommand.Green,
            "Blue" to randomCommand.Blue
        )

        val (selectedColour, instruction) = colourMap.entries.random()
        currentCorrectColour = selectedColour // Save correct color
        txtCommand.text = instruction

        // 🎨 Fetch a new image related to the current colour
        fetchImage(selectedColour)

        startTimer()
    }


    private fun startTimer() {
        val txtTimer = findViewById<TextView>(R.id.txtTimer)
        currentTimer?.cancel()

        currentTimer = object : CountDownTimer(timePerRound, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                txtTimer.text = "${millisUntilFinished / 1000}"
            }

            override fun onFinish() {
                gameOver()
            }
        }.start()
    }

    override fun onPause() {
        super.onPause()
        currentTimer?.cancel()
    }
    private fun fetchImage(query: String) {
        val client = OkHttpClient()

        Thread {
            try {
                val request = Request.Builder()
                    .url("https://api.pexels.com/v1/search?query=${query}&per_page=5") // fetch 5 images
                    .addHeader("Authorization", PEXELS_API_KEY)
                    .build()

                client.newCall(request).execute().use { response ->
                    val jsonString = response.body?.string()
                    if (!jsonString.isNullOrEmpty()) {
                        val jsonObj = JSONObject(jsonString)
                        val photos = jsonObj.optJSONArray("photos")
                        if (photos != null && photos.length() > 0) {
                            // Pick a random photo from the array
                            val randomIndex = (0 until photos.length()).random()
                            val photo = photos.getJSONObject(randomIndex)
                            val imageUrl = photo.getJSONObject("src").getString("medium")

                            runOnUiThread {
                                Glide.with(this@MainActivity)
                                    .load(imageUrl)
                                    .placeholder(android.R.drawable.ic_menu_gallery)
                                    .into(imgColorVisual)
                            }
                        }

                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }.start()
    }

    private fun handleButtonClick(btnColourSelected: String) {
        if (btnColourSelected == currentCorrectColour) {
            currentScore++
            correctStreak++
            stableRounds++

            updateTimerLogic()
            proceed() //proceeds to next command if the colour guessed was correct
        } else {
            gameOver()
        }
    }

    private fun updateTimerLogic() {
        if (correctStreak >= 5 && timePerRound > 3_000L) {
            if (stableRounds >= 3) {
                timePerRound -= 1_000L // reduce by 1 sec
                stableRounds = 0 // reset 3-round hold
            }
        }
    }

    private fun gameOver() {
        currentTimer?.cancel()

        // Save high score
        if (currentScore > highScore) {
            highScore = currentScore
        }

        val intent = Intent(this, GameOver::class.java).apply {
            putExtra("currentScore", currentScore)
            putExtra("highScore", highScore)
        }
        startActivity(intent)
        finish()
    }

    private fun resetGame() {
        currentScore = 0
        timePerRound = 11_000L
        correctStreak = 0
        stableRounds = 0
    }



}



