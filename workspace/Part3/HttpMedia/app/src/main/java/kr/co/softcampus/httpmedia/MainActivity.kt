package kr.co.softcampus.httpmedia

import android.graphics.BitmapFactory
import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.co.softcampus.httpmedia.databinding.ActivityMainBinding
import java.net.HttpURLConnection
import java.net.URL
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    var mp : MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            button.setOnClickListener {
                thread {
                    val url = URL("http://121.162.58.177:8080/img_android.jpg")
                    val conn = url.openConnection() as HttpURLConnection

                    val bitmap = BitmapFactory.decodeStream(conn.inputStream)

                    runOnUiThread {
                        imageView.setImageBitmap(bitmap)
                    }
                }
            }

            button2.setOnClickListener {
                if(mp == null) {
                    val uri = Uri.parse("http://121.162.58.177:8080/gaho_start_mp3.mp3")
                    mp = MediaPlayer.create(this@MainActivity, uri)
                    mp?.start()
                }
            }

            button3.setOnClickListener {
                if(mp != null) {
                    mp?.stop()
                    mp = null
                }
            }

            button4.setOnClickListener {
                if(!videoView.isPlaying) {
                    val uri = Uri.parse("http://121.162.58.177:8080/gaho_start_mp4.mp4")
                    videoView.setVideoURI(uri)
                    videoView.start()
                }
            }

            button5.setOnClickListener {
                if(videoView.isPlaying) {
                    videoView.stopPlayback()
                }
            }
        }
    }
}