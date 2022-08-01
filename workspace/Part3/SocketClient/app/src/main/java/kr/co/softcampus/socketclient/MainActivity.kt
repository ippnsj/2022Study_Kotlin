package kr.co.softcampus.socketclient

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kr.co.softcampus.socketclient.databinding.ActivityMainBinding
import java.io.DataInputStream
import java.io.DataOutputStream
import java.io.OutputStream
import java.net.Socket
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            button.setOnClickListener {
                thread {
                    // 서버에 접속한다.
                    val socket = Socket("121.162.58.177", 55555)

                    Log.d("test", "$socket")

                    // 서버로부터 데이터를 수신한다.
                    val inputStream = socket.getInputStream()
                    val dis = DataInputStream(inputStream)

                    val data1 = dis.readInt()
                    val data2 = dis.readDouble()
                    val data3 = dis.readBoolean()
                    val data4 = dis.readUTF()

                    runOnUiThread() {
                        textView.text = "data1 : $data1\n"
                        textView.append("data2 : $data2\n")
                        textView.append("data3 : $data3\n")
                        textView.append("data4 : $data4\n")
                    }

                    // 서버로 데이터를 보낸다.
                    val outputStream = socket.getOutputStream()
                    val dos = DataOutputStream(outputStream)

                    dos.writeInt(200)
                    dos.writeDouble(22.22)
                    dos.writeBoolean(false)
                    dos.writeUTF("클라이언트가 보낸 문자열")

                    socket.close()
                }
            }
        }
    }
}