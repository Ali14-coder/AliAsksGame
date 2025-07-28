package vcmsa.projects.icetask1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class GameOver : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_game_over)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnYes = findViewById<Button>(R.id.btnYes)
        val btnNo = findViewById<Button>(R.id.btnNo)

        btnYes.setOnClickListener {
            //reset report high score counter
            val intent = Intent(
                this,
                MainActivity::class.java
            ) //opens the main activity screen with the intent of the class. The old window is still present. It is NOT CLOSED
            startActivity(intent)
        }

        btnNo.setOnClickListener {
            //clear report high score counter
            val intent = Intent(this, Welcome::class.java) //opens the Welcome screen with the intent of the class. The old window is still present. It is NOT CLOSED
            startActivity(intent)
        }
    }


}