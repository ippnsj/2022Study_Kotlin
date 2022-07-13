package kr.co.softcampus.stylenotification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import kr.co.softcampus.stylenotification.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val builder1 = getNotificationBuilder("style", "style Notification")
            builder1.setContentTitle("Big Picture")
            builder1.setContentText("Big Picture Notification")
            builder1.setSmallIcon(android.R.drawable.ic_menu_camera)

            // BigPicture Notification 객체를 생성한다.
            val big = NotificationCompat.BigPictureStyle(builder1)
            val bitmap = BitmapFactory.decodeResource(resources, R.drawable.img_android)
            big.bigPicture(bitmap)
            big.setBigContentTitle("Big Content Title")
            big.setSummaryText("Summary Text")

            val notification = builder1.build()
            val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            manager.notify(10, notification)
        }

        binding.button2.setOnClickListener {
            val builder1 = getNotificationBuilder("style", "style Notification")
            builder1.setContentTitle("Big Text")
            builder1.setContentText("Big Text Notification")
            builder1.setSmallIcon(android.R.drawable.ic_menu_info_details)

            // BigText Notification 객체를 생성한다.
            val big = NotificationCompat.BigTextStyle(builder1)
            big.setBigContentTitle("Big Content Title")
            big.setSummaryText("Summary Text")
            big.bigText("동해물과 백두산이 마르고 닳도록 하느님이 보우하사 우리나라 만세")

            val notification = builder1.build()
            val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            manager.notify(20, notification)
        }

        binding.button3.setOnClickListener {
            val builder1 = getNotificationBuilder("style", "style Notification")
            builder1.setContentTitle("Inbox")
            builder1.setContentText("Inbox Notification")
            builder1.setSmallIcon(android.R.drawable.ic_menu_today)

            // Inbox Style Notification 객체를 생성한다.
            val inbox = NotificationCompat.InboxStyle(builder1)
            inbox.setBigContentTitle("Big Content Title")
            inbox.setSummaryText("Summary Text")

            inbox.addLine("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")
            inbox.addLine("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb")
            inbox.addLine("cccccccccccccccccccccccccccccccccccccc")
            inbox.addLine("dddddddddddddddddddddddddddddddddddddd")
            inbox.addLine("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee")
            inbox.addLine("ffffffffffffffffffffffffffffffffffffff")
            inbox.addLine("gggggggggggggggggggggggggggggggggggggg")

            val notification = builder1.build()
            val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            manager.notify(30, notification)
        }
    }

    fun getNotificationBuilder(id:String, name:String) : NotificationCompat.Builder {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            val channel = NotificationChannel(id, name, NotificationManager.IMPORTANCE_HIGH)
            channel.enableLights(true)
            channel.lightColor = Color.RED
            channel.enableVibration(true)
            manager.createNotificationChannel(channel)
            val builder = NotificationCompat.Builder(this, id)
            return builder
        }
        else {
            val builder = NotificationCompat.Builder(this)
            return builder
        }
    }
}