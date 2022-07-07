package kr.co.softcampus.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kr.co.softcampus.recyclerview.databinding.RowBinding

// RecyclerView의 Adapter 클래스
class RecyclerAdapter(private val dataSet:List<Country>, private val listener:OnItemClickListener) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    public interface OnItemClickListener {
        fun onItemClick(v:View, pos:Int)
    }

    // 항목 구성을 위해 사용할 ViewHolder 객체가 필요할 때 호출되는 메서드
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // 항목으로 사용할 View 객체를 생성한다.
        val binding = RowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    // RecyclerView의 항목 개수를 반환한다.
    override fun getItemCount(): Int {
        return dataSet.size
    }

    // ViewHolder를 통해 항목을 구성할 때 항목 내의 View 객체에 데이터를 셋팅한다.
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }

    // ViewHolder 클래스는 항목 하나를 구성하는 View 들의 주소 값을 가지고 있는 클래스이다.
    // 이 클래스는 RecyclerView의 Adapter 클래스 내부에 구현하여 준다.
    inner class ViewHolder(val binding: RowBinding) : RecyclerView.ViewHolder(binding.root) {
        // 항목 View 내부의 View 객체의 주소값을 담는다.
        val rowImageView = binding.rowImageView
        val rowTextView = binding.rowTextView

        init {
            binding.root.setOnClickListener {
                listener.onItemClick(rowTextView, adapterPosition)
            }
        }

        fun bind(pos: Int) {
            with(binding) {
                rowImageView.setImageResource(dataSet[pos].imgRes)
                rowTextView.text = dataSet[pos].name
            }
        }
    }
}