package com.ranggoo.app1_memo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ranggoo.app1_memo.add.MemoAddFragmentDirections
import com.ranggoo.app1_memo.databinding.MainRecyclerRowBinding
import com.ranggoo.app1_memo.main.MemoEntity

// 프래그먼트에서 프래그먼트로 데이터 넘겨줄려면 @Parcelize를 해야됨.!


private var itemDiffCallback = object : DiffUtil.ItemCallback<MemoEntity>() {
    override fun areItemsTheSame(oldItem: MemoEntity, newItem: MemoEntity): Boolean = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: MemoEntity, newItem: MemoEntity): Boolean = oldItem == newItem
}

class MemoAdapter : ListAdapter<MemoEntity, MemoAdapter.MemoViewHolder>(itemDiffCallback) {

    private lateinit var listener : MemoAdapterListener

    interface MemoAdapterListener {
        fun onClick(memo:MemoEntity)
    }

    fun addMemoClickListener(_listener : MemoAdapterListener){
        listener=_listener
    }




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemoViewHolder {
        return MemoViewHolder(
            MainRecyclerRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: MemoViewHolder, position: Int) = holder.bind(getItem(position))

    inner class MemoViewHolder(
        val binding: MainRecyclerRowBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: MemoEntity) {
            with(binding) {
                memoId.text = item.id.toString()
                memoTitle.text = item.title
                memoContent.text = item.content
            }
            binding.root.setOnClickListener {
                listener.onClick(item)
            }




            }
        }
    }



