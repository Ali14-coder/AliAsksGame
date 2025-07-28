package vcmsa.projects.icetask1

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
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
    }
    val btnRed = findViewById<Button>(R.id.btnRed)
    val btnYellow = findViewById<Button>(R.id.btnYellow)
    val btnBlue = findViewById<Button>(R.id.btnBlue)
    val btnGreen = findViewById<Button>(R.id.btnGreen)

    val txtCommand = findViewById<TextView>(R.id.txtCommand)

//    val RedColour = "Red"
//    val YellowColour = "Yellow"
//    val BlueColour = "Blue"
//    val GreenColour = "Green"

    btnRed.setOnClickListener{
        view -> handleButtonClick(view)
        Toast.makeText(this, "Red button was clicked", Toast.LENGTH_SHORT).show()
    }

    fun handleButtonClick(view: View){
        when (view.id) {
            R.id.btnRed -> {
                if (txtCommand = RedCommand || txtCommand = RedCommand2 || txtCommand = RedCommand3 || txtCommand = RedCommand4){

                }
            }
            R.id.btnYellow -> {
                if (txtCommand = YellowCommand || txtCommand = YellowCommand2 || txtCommand = YellowCommand3 || txtCommand = YellowCommand4){

                }
            }
            R.id.btnGreen -> {
                if (txtCommand = GreenCommand || txtCommand = GreenCommand2 || txtCommand = GreenCommand3 || txtCommand = GreenCommand4){

                }
            }
            R.id.btnBlue -> {
                if (txtCommand = BlueCommand || txtCommand = BlueCommand2 || txtCommand = BlueCommand3 || txtCommand = BlueCommand4){

                }
            }

        }
    }


}