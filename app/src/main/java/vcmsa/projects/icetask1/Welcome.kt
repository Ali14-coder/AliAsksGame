package vcmsa.projects.icetask1

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageButton
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

private lateinit var welcomeSoundtrack: MediaPlayer
class Welcome : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_welcome)

        //music initialization
        welcomeSoundtrack = MediaPlayer.create(this, R.raw.welcome_soundtrack);
        welcomeSoundtrack.isLooping = true;
        welcomeSoundtrack.start()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnStart = findViewById<ImageView>(R.id.btnStart)

        btnStart.setOnClickListener(){
            Handler(Looper.getMainLooper()).postDelayed({
                stopWelcomeSound()
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            },100) // 1/10 of a second delay
        }
    }
    private fun stopWelcomeSound() {
        if (welcomeSoundtrack.isPlaying) {
            welcomeSoundtrack.stop()
            welcomeSoundtrack.release()
        }
    }

    //this is used to kill the soundtrack to not overburden the memory or cpu
    override fun onDestroy() {
        super.onDestroy()
        if (::welcomeSoundtrack.isInitialized) {
            stopWelcomeSound()
        }
    }
}