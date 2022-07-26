package kr.co.softcampus.cpapp1

import android.content.ContentProvider
import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.net.Uri

class TestProvider : ContentProvider() {

    var db:SQLiteDatabase? = null

    // 몇 개의 raw가 삭제 되었는지 반환한다.
    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<String>?): Int {
        val cnt = db?.delete("TestTable", selection, selectionArgs)
        return cnt!!
    }

    // 열의 데이터 타입을 MIME 타입 형태로 반환하는 메서드
    // 알려줄 필요가 없다면 null 을 반환한다.
    override fun getType(uri: Uri): String? {
        return null
    }

    override fun insert(uri: Uri, values: ContentValues?): Uri? {
        db?.insert("TestTable", null, values)

        return uri
    }

    // Cotent Provider 객체가 생성되면 자동으로 호출되는 메서드
    // 데이터베이스에 접근할 수 있는 객체를 생성하고
    // 접근에 성공하면 true, 실패하면 false를 반환한다.
    override fun onCreate(): Boolean {
        db = DBHelper(context!!).writableDatabase

        if(db == null) return false
        return true
    }

    // select 용
    // uri : Provider 요청시 사용한 uri 값
    // projection : 가져올 컬럼 이름 목록, null 이면 모든 컬럼을 가져온다.
    // selection : 조건절, 조건이 없으면 null
    // selectionArgs : 조건절의 ? 에 바인딩될 값 배열
    // sortOrder : 정렬 기준이 되는 컬럼
    override fun query(
        uri: Uri, projection: Array<String>?, selection: String?,
        selectionArgs: Array<String>?, sortOrder: String?
    ): Cursor? {
        val c1 = db?.query("TestTable", projection, selection, selectionArgs, null, null, sortOrder)
        return c1
    }

    // 몇 개의 raw가 업데이트 되었는지 반환한다.
    override fun update(
        uri: Uri, values: ContentValues?, selection: String?,
        selectionArgs: Array<String>?
    ): Int {
        val cnt = db?.update("TestTable", values, selection, selectionArgs)
        return cnt!!
    }
}