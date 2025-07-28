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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }
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
        val btnRed = findViewById<Button>(R.id.btnRed)
        val btnYellow = findViewById<Button>(R.id.btnYellow)
        val btnBlue = findViewById<Button>(R.id.btnBlue)
        val btnGreen = findViewById<Button>(R.id.btnGreen)

        val txtCommand = findViewById<TextView>(R.id.txtCommand)

        val btnReturn = findViewById<ImageView>(R.id.btnMainBack)

        btnReturn.setOnClickListener{
            val intent = Intent(this,Welcome::class.java) //opens the playing screen with the intent of the class. The old window is still present. It is NOT CLOSED
                startActivity(intent)
            }
        }


    private fun Timer(){
        //Timer countdown. Starts from 10s. Will go down by 1 second after 5 consec correct guess.
        //Will remain current second for 3 rounds
        //Will stop decreasing once reaches 3 secs
        //When timer runs out, pop up of current score and high score will show.
        //Once pop up is dismissed, gameover screen will appear
    }

//    val RedColour = "Red"
//    val YellowColour = "Yellow"
//    val BlueColour = "Blue"
//    val GreenColour = "Green"

//        btnRed.setOnClickListener{
//                view -> handleButtonClick(view)
//            Toast.makeText(this, "Red button was clicked", Toast.LENGTH_SHORT).show()
//        }
//
//        fun handleButtonClick(view: View){
//            when (view.id) {
//                R.id.btnRed -> {
//                    if (txtCommand = RedCommand || txtCommand = RedCommand2 || txtCommand = RedCommand3 || txtCommand = RedCommand4){
//
//                    }
//                }
//                R.id.btnYellow -> {
//                    if (txtCommand = YellowCommand || txtCommand = YellowCommand2 || txtCommand = YellowCommand3 || txtCommand = YellowCommand4){
//
//                    }
//                }
//                R.id.btnGreen -> {
//                    if (txtCommand = GreenCommand || txtCommand = GreenCommand2 || txtCommand = GreenCommand3 || txtCommand = GreenCommand4){
//
//                    }
//                }
//                R.id.btnBlue -> {
//                    if (txtCommand = BlueCommand || txtCommand = BlueCommand2 || txtCommand = BlueCommand3 || txtCommand = BlueCommand4){
//
//                    }
//                }
//
//            }
//        }
    }



