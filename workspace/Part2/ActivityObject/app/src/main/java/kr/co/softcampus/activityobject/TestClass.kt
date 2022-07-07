package kr.co.softcampus.activityobject

import android.os.Parcel
import android.os.Parcelable

class TestClass() : Parcelable{
    var data1 : Int = 0
    var data2 : String? = ""

    constructor(parcel: Parcel) : this() {
        data1 = parcel.readInt()
        data2 = parcel.readString()
    }

    // putExtra를 이용해 객체를 Intent에 담는 작업을 할 경우 호출되는 메서드
    // 객체가 Intent에 저장되는 것이 아닌 객체를 구성하는 변수의 값이 저장된다.
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(data1)
        parcel.writeString(data2)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<TestClass> {
        // getParcelableExtra를 호출해서 객체를 추출하려고 하면 자동으로 호출되는 메서드
        // 새로운 객체를 생성하고 parcel에 저장되어 있는 데이터를 추출해 객체의 변수에 담아준다.
        // 그 후 생성된 객체를 반환한다.
        override fun createFromParcel(parcel: Parcel): TestClass {
            return TestClass(parcel)
        }

        override fun newArray(size: Int): Array<TestClass?> {
            return arrayOfNulls(size)
        }
    }
}