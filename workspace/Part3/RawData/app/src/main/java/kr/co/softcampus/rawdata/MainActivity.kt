package kr.co.softcampus.rawdata

import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.co.softcampus.rawdata.databinding.ActivityMainBinding
import java.io.BufferedReader
import java.io.InputStreamReader

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    var mp : MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            button.setOnClickListener {
                val inputStream = resources.openRawResource(R.raw.data1)
                val isr = InputStreamReader(inputStream, "UTF-8")
                val br = BufferedReader(isr)

                var str:String? = null
                val sb = StringBuffer()

                do {
                    str = br.readLine()

                    if(str != null) {
                        sb.append("$str\n")
                    }
                }while(str != null)

                br.close()

                textView.text = sb.toString()
            }

            button2.setOnClickListener {
                if(mp == null) {
                    mp = MediaPlayer.create(this@MainActivity, R.raw.gaho_start_mp3)
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
                    //영상 파일의 경로
                    val uri = Uri.parse("android.resource://${packageName}/raw/gaho_start_mp4")
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