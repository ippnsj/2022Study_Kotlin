package kr.co.softcampus.messagenotification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.graphics.Color
import android.graphics.drawable.Icon
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import androidx.core.app.Person
import androidx.core.graphics.drawable.IconCompat
import kr.co.softcampus.messagenotification.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {    // 안드로이드 9.0 이상이라면
                val builder1 = getNotificationBuilder("message", "message style")
                builder1.setContentTitle("Message Style")
                builder1.setContentText("Message Style Notification")
                builder1.setSmallIcon(android.R.drawable.ic_input_delete)

                val personBuilder1 = Person.Builder()
                val icon1 = IconCompat.createWithResource(this, android.R.drawable.ic_media_next)
                personBuilder1.setIcon(icon1)
                personBuilder1.setName("홍길동")
                val person1 = personBuilder1.build()

                val personBuilder2 = Person.Builder()
                val icon2 = IconCompat.createWithResource(this, R.mipmap.ic_launcher)
                personBuilder2.setIcon(icon2)
                personBuilder2.setName("최길동")
                val person2 = personBuilder2.build()

                val messageStyle = NotificationCompat.MessagingStyle(person1)

                messageStyle.addMessage("첫 번째 메시지", System.currentTimeMillis(), person1)
                messageStyle.addMessage("두 번째 메시지", System.currentTimeMillis(), person2)
                messageStyle.addMessage("세 번째 메시지", System.currentTimeMillis(), person1)
                messageStyle.addMessage("네 번째 메시지", System.currentTimeMillis(), person2)

                builder1.setStyle(messageStyle)

                val notification = builder1.build()
                val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
                manager.notify(10, notification)
            }
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