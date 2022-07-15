package kr.co.softcampus.fragmentlifecycle

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class SubFragment : Fragment() {
    // Fragment가 Activity와 연결될 때 호출된다.
    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("test", "onAttach")
    }

    // Fragment가 생성될 때 호출된다.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("test", "onCreate")
    }

    // ★
    // Fragment를 통해 보여줄 View를 생성하기 위해 호출된다.
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_sub, null)
        Log.d("test", "onCreateView")

        return view
    }

    // ★
    // Fragment를 통해 보여줄 View가 생성되면 호출된다.
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("test", "onViewCreated")
    }

    // Activiy에서 보여줄 Fragment가 완전히 생성되면 호출된다.(통제하기 위한 다양한 기능들까지 모두 생성되면)
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d("test", "onActivityCreated")
    }

    // Fragment가 가동될 때 호출된다.(Fragment가 화면에 표시될 때)
    override fun onStart() {
        super.onStart()
        Log.d("test", "onStart")
    }

    // Fragment가 보여지고 나서 호출된다.
    override fun onResume() {
        super.onResume()
        Log.d("test", "onResume")
    }

    // Fragment가 일시 정지될 때 호출된다.(Fragment가 화면에서 사라질 때)
    override fun onPause() {
        super.onPause()
        Log.d("test", "onPause")
    }

    // ★
    // Fragment가 화면에서 완전히 사라져서 더 이상 보여지지 않을 때 호출된다.
    // Fragment 정지
    override fun onStop() {
        super.onStop()
        Log.d("test", "onStop")
    }

    // ★
    // Fragment가 (메모리에서) 제거될 때 호출된다.
    // 해당 Fragment를 관리하는 Activity가 종료될 때 호출된다.
    override fun onDestroy() {
        super.onDestroy()
        Log.d("test", "onDestroy")
    }

    // Fragment가 Activity와 연결이 완전히 끊기기 전에 호출된다.
    override fun onDetach() {
        super.onDetach()
        Log.d("test", "onDetach")
    }
}