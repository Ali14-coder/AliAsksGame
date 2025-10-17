package vcmsa.projects.icetask1

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONObject
import org.w3c.dom.Text
import java.io.File
import java.io.FileOutputStream
import kotlin.concurrent.thread

class GameOver : AppCompatActivity() {
    private val GIPHY_API_KEY = "snh7AAokXvZ95jRNctRG2jtc5aosKxmi"
    private lateinit var imgGameOverGif: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_game_over)

        imgGameOverGif = findViewById(R.id.imgGameOverGif)

        fetchRandomGif()

        // Setup system bars
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Score text
        val txtScore = findViewById<TextView>(R.id.txtScores)
        val currentScore = intent.getIntExtra("currentScore", 0)
        val highScore = intent.getIntExtra("highScore", 0)
        txtScore.text = "SCORES:\n\nCurrent score: $currentScore\nHigh Score: $highScore"

        // Share button
        //val btnShare = findViewById<ImageView>(R.id.btnShare)
        val rootView = findViewById<View>(R.id.main) // the root view to capture

//        btnShare.setOnClickListener {
//            val screenshot = captureScreen(rootView)
//            val imageUri = saveBitmapToCache(this, screenshot)
//            imageUri?.let {
//                shareImageToWhatsApp(this, it)
//            }
//        }

        // Button navigation
        val btnYes = findViewById<Button>(R.id.btnYes)
        val btnNo = findViewById<Button>(R.id.btnNo)

        btnYes.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java) //opens the playing screen with the intent of the class. The old window is still present. It is NOT CLOSED
            startActivity(intent)
        }

        btnNo.setOnClickListener {
            val intent = Intent(this,Welcome::class.java) //opens the playing screen with the intent of the class. The old window is still present. It is NOT CLOSED
            startActivity(intent)
        }

        //val btnReport = findViewById<TextView>(R.id.txtReport)
//        btnReport.setOnClickListener{
//            val intent = Intent(this,Report::class.java) //opens the playing screen with the intent of the class. The old window is still present. It is NOT CLOSED
//            startActivity(intent)
//        }
    }

    private fun captureScreen(view: View): Bitmap {
        val bitmap = Bitmap.createBitmap(view.width, view.height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        view.draw(canvas)
        return bitmap
    }
    private fun fetchRandomGif() {
        val client = OkHttpClient()

        thread {
            try {
                // Fetch a random "sad" or "shocked" GIF
                val url =
                    "https://api.giphy.com/v1/gifs/random?api_key=$GIPHY_API_KEY&tag=sad,shocked&rating=pg"
                val request = Request.Builder().url(url).build()
                val response = client.newCall(request).execute()
                val jsonString = response.body?.string()
                if (!jsonString.isNullOrEmpty()) {
                    val jsonObj = JSONObject(jsonString)
                    val gifUrl = jsonObj.getJSONObject("data")
                        .getJSONObject("images")
                        .getJSONObject("downsized")
                        .getString("url")

                    runOnUiThread {
                        Glide.with(this@GameOver)
                            .asGif() // Important: load as GIF
                            .load(gifUrl)
                            .into(imgGameOverGif)
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
    private fun saveBitmapToCache(context: Context, bitmap: Bitmap): Uri? {
        val cachePath = File(context.cacheDir, "images")
        cachePath.mkdirs()
        val file = File(cachePath, "AliAsksAchievement.png")
        FileOutputStream(file).use { out ->
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, out)
        }
        return FileProvider.getUriForFile(
            context,
            "${context.packageName}.fileprovider",
            file
        )
    }

    private fun shareImageToWhatsApp(context: Context, imageUri: Uri) {
        val shareIntent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_STREAM, imageUri)
            type = "image/png"
            setPackage("com.whatsapp")
            addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        }

        try {
            context.startActivity(shareIntent)
        } catch (e: ActivityNotFoundException) {
            Toast.makeText(context, "WhatsApp not installed.", Toast.LENGTH_SHORT).show()
        }
    }
}
