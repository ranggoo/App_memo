package com.john.episode.presentation.main
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.john.episode.databinding.MainRecyclerPostBinding
import com.john.episode.domain.feed.entity.EpisodeFeedContentListEntity

//
//import android.view.LayoutInflater
//import android.view.ViewGroup
//import android.widget.Adapter
//import androidx.recyclerview.widget.DiffUtil
//import androidx.recyclerview.widget.ListAdapter
//import androidx.recyclerview.widget.RecyclerView
//import com.john.episode.databinding.MainRecyclerRowBinding
//import com.john.episode.domain.MemoEntity
//
//// 프래그먼트에서 프래그먼트로 데이터 넘겨줄려면 @Parcelize를 해야됨.!
//
//
private var itemDiffCallback = object : DiffUtil.ItemCallback<EpisodeFeedContentListEntity>() {
    override fun areItemsTheSame(oldItem: EpisodeFeedContentListEntity, newItem: EpisodeFeedContentListEntity): Boolean = oldItem.is_empty == newItem.is_empty

    override fun areContentsTheSame(oldItem: EpisodeFeedContentListEntity, newItem: EpisodeFeedContentListEntity): Boolean = oldItem == newItem
}

class HomeAdapter(
    private val onHomeClick: (EpisodeFeedContentListEntity) -> Unit
) : ListAdapter<EpisodeFeedContentListEntity, HomeAdapter.MemoViewHolder>(itemDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemoViewHolder {
        return MemoViewHolder(
            MainRecyclerPostBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: MemoViewHolder, position: Int) = holder.bind(getItem(position))

    inner class MemoViewHolder(
        val binding: MainRecyclerPostBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: EpisodeFeedContentListEntity) {
            with(binding) {
                tvContent.text = item.feed_list.toString()
                tvId.text=item.feed_list.toString()
            }
            binding.root.setOnClickListener {
                onHomeClick(item)

            }

        }
    }
}



