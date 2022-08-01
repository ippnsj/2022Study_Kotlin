import java.io.DataInputStream
import java.io.DataOutputStream
import java.net.ServerSocket

fun main() {
    // 서버 역할을 하기 위한 객체를 생성한다.
    val server = ServerSocket(55555)
    println("사용자 접속대기")
    val socket = server.accept()
    println(socket)

    // 클라이언트로 데이터를 보낸다.
    val outputStream = socket.getOutputStream()
    val dos = DataOutputStream(outputStream)

    dos.writeInt(100)
    dos.writeDouble(11.11)
    dos.writeBoolean(true)
    dos.writeUTF("서버가 보낸 문자열")

    // 클라이언트가 보낸 데이터를 수신한다.
    val inputStream = socket.getInputStream()
    val dis = DataInputStream(inputStream)

    val data1 = dis.readInt()
    val data2 = dis.readDouble()
    val data3 = dis.readBoolean()
    val data4 = dis.readUTF()

    println("data1 : $data1")
    println("data2 : $data2")
    println("data3 : $data3")
    println("data4 : $data4")

    // 서버를 종료한다.
    socket.close()
}