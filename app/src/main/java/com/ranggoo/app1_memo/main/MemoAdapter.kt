package com.ranggoo.app1_memo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ranggoo.app1_memo.databinding.MainRecyclerRowBinding

data class MemoEntity(
    val id: Long,
    val title: String,
    val content: String
)

private var itemDiffCallback = object : DiffUtil.ItemCallback<MemoEntity>() {
    override fun areItemsTheSame(oldItem: MemoEntity, newItem: MemoEntity): Boolean = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: MemoEntity, newItem: MemoEntity): Boolean = oldItem == newItem
}

class MemoAdapter : ListAdapter<MemoEntity, MemoAdapter.MemoViewHolder>(itemDiffCallback) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemoViewHolder {
        return MemoViewHolder(
            MainRecyclerRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: MemoViewHolder, position: Int) = holder.bind(getItem(position))
    class MemoViewHolder(
        val binding: MainRecyclerRowBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: MemoEntity) {
            with(binding) {
                memoId.text = item.id.toString()
                memoTitle.text = item.title
                memoContent.text = item.content
            }
        }
    }


}