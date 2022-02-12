package com.john.episode.presentation.main
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.john.episode.databinding.MainRecyclerPostBinding
import com.john.episode.domain.feed.entity.EpisodeFeedContentEntity
import com.john.episode.domain.feed.entity.EpisodeFeedContentListEntity

private var itemDiffCallback = object : DiffUtil.ItemCallback<EpisodeFeedContentEntity>() {
    override fun areItemsTheSame(oldItem: EpisodeFeedContentEntity, newItem: EpisodeFeedContentEntity): Boolean = oldItem.id == newItem.id
    override fun areContentsTheSame(oldItem: EpisodeFeedContentEntity, newItem: EpisodeFeedContentEntity): Boolean = oldItem == newItem
}

class HomeAdapter(
    private val onClickEpisode: (EpisodeFeedContentEntity) -> Unit
) : ListAdapter<EpisodeFeedContentEntity, HomeAdapter.MemoViewHolder>(itemDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemoViewHolder {
        return MemoViewHolder(
            MainRecyclerPostBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: MemoViewHolder, position: Int) = holder.bind(getItem(position))

    inner class MemoViewHolder(
        private val binding: MainRecyclerPostBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: EpisodeFeedContentEntity) = with(binding) {
            itemView.setOnClickListener {
                //viewholder = binding.root와 동일 전체 영역을 잡음
                onClickEpisode(item)

            }

        }
    }
}



