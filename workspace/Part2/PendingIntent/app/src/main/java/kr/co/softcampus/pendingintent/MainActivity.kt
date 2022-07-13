package kr.co.softcampus.pendingintent

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import kr.co.softcampus.pendingintent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val builder = getNotificationBuilder("pending", "pending intent")
            builder.setContentTitle("notification 1")
            builder.setContentText("알림 메시지 1입니다")
            builder.setSmallIcon(android.R.drawable.ic_menu_search)
            val bitmap = BitmapFactory.decodeResource(resources, R.mipmap.ic_launcher)
            builder.setLargeIcon(bitmap)
            // 메시지를 터치하면 자동으로 메시지를 제거한다.
            builder.setAutoCancel(true)

            // 메시지를 터치하면 실행할 Activity를 관리할 Intent 생성
            val intent1 = Intent(this, NotificationActivity1::class.java)
            intent1.putExtra("data1", 100)
            intent1.putExtra("data2", 200)

            val pending = PendingIntent.getActivity(this, 10, intent1, PendingIntent.FLAG_UPDATE_CURRENT)
            builder.setContentIntent(pending)

            // Action 설정
            val intent2 = Intent(this, NotificationActivity3::class.java)
            val pending2 = PendingIntent.getActivity(this, 100, intent2, PendingIntent.FLAG_UPDATE_CURRENT)
            val builder2 = NotificationCompat.Action.Builder(android.R.drawable.ic_menu_compass, "Action 1", pending2)
            val action1 = builder2.build()
            builder.addAction(action1)

            val intent3 = Intent(this, NotificationActivity4::class.java)
            val pending3 = PendingIntent.getActivity(this, 100, intent3, PendingIntent.FLAG_UPDATE_CURRENT)
            val builder3 = NotificationCompat.Action.Builder(android.R.drawable.ic_menu_agenda, "Action 2", pending3)
            val action2 = builder3.build()
            builder.addAction(action2)

            val notification = builder.build()
            val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            manager.notify(10, notification)
        }

        binding.button2.setOnClickListener {
            val builder = getNotificationBuilder("pending", "pending intent")
            builder.setContentTitle("notification 2")
            builder.setContentText("알림 메시지 2입니다")
            builder.setSmallIcon(android.R.drawable.ic_menu_search)
            val bitmap = BitmapFactory.decodeResource(resources, R.mipmap.ic_launcher)
            builder.setLargeIcon(bitmap)

            // 메시지를 터치하면 실행할 Activity를 관리할 Intent 생성
            val intent = Intent(this, NotificationActivity2::class.java)

            val pending = PendingIntent.getActivity(this, 10, intent, PendingIntent.FLAG_UPDATE_CURRENT)
            builder.setContentIntent(pending)

            val notification = builder.build()
            val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            manager.notify(20, notification)
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