package vcmsa.projects.icetask1

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class MainActivity : AppCompatActivity() {
    private lateinit var txtCommand: TextView
    private lateinit var currentCorrectColour: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }
        txtCommand = findViewById(R.id.txtCommand)


        Commands() //this calls the commands class and populates the command list
        getCommand()
        Timer()
// Associating buttons with column of colour row
        findViewById<Button>(R.id.btnRed).setOnClickListener { handleButtonClick("Red") }
        findViewById<Button>(R.id.btnYellow).setOnClickListener { handleButtonClick("Yellow") }
        findViewById<Button>(R.id.btnGreen).setOnClickListener { handleButtonClick("Green") }
        findViewById<Button>(R.id.btnBlue).setOnClickListener { handleButtonClick("Blue") }

        proceed()

        val btnReturn = findViewById<ImageView>(R.id.btnMainBack)
        btnReturn.setOnClickListener{
            val intent = Intent(this,Welcome::class.java) //opens the playing screen with the intent of the class. The old window is still present. It is NOT CLOSED
                startActivity(intent)
            }
        }


    private fun getCommand(){
        val randomCommand = commmandData.random() //this will return a random command from the commands data list

        val set =listOf(
            randomCommand.Red,
            randomCommand.Yellow,
            randomCommand.Green,
            randomCommand.Blue
        ).random()

        txtCommand.text = set
    }

    private fun proceed(){
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
    }

    private fun Timer(){
        val txtTimer = findViewById<TextView>(R.id.txtTimer)

        object : CountDownTimer(11000,1000) //this sets (how long the timer will last, interval is must go down in)
        {
            override fun onTick(millisUntilFinished: Long) {
                val secondsLeft = millisUntilFinished / 1000 //converts milliseconds to seconds
                txtTimer.text = secondsLeft.toString() //displays these seconds to user
            }

            override fun onFinish(){
                txtTimer.text = "0"
                val intent = Intent(this@MainActivity, GameOver::class.java)
                startActivity(intent)

            }

        }.start()
        //Timer countdown. Starts from 10s. Will go down by 1 second after 5 consec correct guess.
        //Will remain current second for 3 rounds
        //Will stop decreasing once reaches 3 secs
        //When timer runs out, pop up of current score and high score will show.
        //Once pop up is dismissed, gameover screen will appear
    }

    private fun handleButtonClick(btnColourSelected: String) {
        if (btnColourSelected == currentCorrectColour) {
            proceed() //proceeds to next command if the colour guessed was correct
        }
        else {
            val intent = Intent(this, GameOver::class.java)
            startActivity(intent)
            finish()
        }
    }

    }



