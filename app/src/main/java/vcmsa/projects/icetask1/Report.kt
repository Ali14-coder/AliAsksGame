package vcmsa.projects.icetask1

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Report : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_report)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val btnReturn = findViewById<ImageView>(R.id.btnReportBack)

        btnReturn.setOnClickListener{
            val intent = Intent(this,Welcome::class.java) //opens the playing screen with the intent of the class. The old window is still present. It is NOT CLOSED
            startActivity(intent)
        }
        val txtReportView = findViewById<TextView>(R.id.reportView)
        //Calling and integrating the analysis API


    }

}