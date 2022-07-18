package kr.co.softcampus.dialogfragment

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class SubFragment : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val mainActivity = activity as MainActivity
        val mainBinding = mainActivity.getBinding()

        val builder = AlertDialog.Builder(mainActivity)
        builder.setTitle("타이틀 입니다")
        builder.setMessage("메시지 입니다")

        builder.setPositiveButton("Positive") { dialogInterface: DialogInterface, i: Int ->
            mainBinding.textView.text = "Positive"
        }
        builder.setNeutralButton("Neutral") { dialogInterface: DialogInterface, i: Int ->
            mainBinding.textView.text = "Neutral"
        }
        builder.setNegativeButton("Negative") { dialogInterface: DialogInterface, i: Int ->
            mainBinding.textView.text = "Negative"
        }

        val alert = builder.create()

        return alert
    }
}