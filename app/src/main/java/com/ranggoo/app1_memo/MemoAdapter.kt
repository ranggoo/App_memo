package com.ranggoo.app1_memo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ranggoo.app1_memo.databinding.MainRecyclerRowBinding

data class MemoData(

    val subject: String,
    val date: String,
)

private var itemDiffCallback = object : DiffUtil.ItemCallback<MemoData>() {
    override fun areItemsTheSame(oldItem: MemoData, newItem: MemoData): Boolean = oldItem.subject == newItem.subject

    override fun areContentsTheSame(oldItem: MemoData, newItem: MemoData): Boolean = oldItem == newItem
}

class MemoAdapter : ListAdapter<MemoData, MemoAdapter.MemoViewHolder>(itemDiffCallback) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemoViewHolder {
        return MemoViewHolder(
            MainRecyclerRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: MemoViewHolder, position: Int) = holder.bind(getItem(position))
    class MemoViewHolder(
        val binding: MainRecyclerRowBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: MemoData) {
            with(binding) {
                memoDate.text = item.date
                memoSubject.text = item.subject


            }
        }
    }


}