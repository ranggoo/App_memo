package com.john.episode.presentation.main
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.john.episode.databinding.ItemRecyclerEpisodeContentBinding
import com.john.episode.domain.feed.entity.EpisodeFeedContentEntity

private var itemDiffCallback = object : DiffUtil.ItemCallback<EpisodeFeedContentEntity>() {
    override fun areItemsTheSame(oldItem: EpisodeFeedContentEntity, newItem: EpisodeFeedContentEntity): Boolean = oldItem.id == newItem.id
    override fun areContentsTheSame(oldItem: EpisodeFeedContentEntity, newItem: EpisodeFeedContentEntity): Boolean = oldItem == newItem
}

class HomeAdapter(
    private val onClickEpisode: (EpisodeFeedContentEntity) -> Unit
) : ListAdapter<EpisodeFeedContentEntity, HomeAdapter.ContentViewHolder>(itemDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContentViewHolder {
        return ContentViewHolder(
            ItemRecyclerEpisodeContentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ContentViewHolder, position: Int) = holder.bind(getItem(position))

    inner class ContentViewHolder(
        private val binding: ItemRecyclerEpisodeContentBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: EpisodeFeedContentEntity) = with(binding) {
            //게시물 내용
            tvContent.text=item.content
            //작성자 닉네임
            tvNickname.text = item.nick_name

            //컨텐츠 이미지
            Glide.with(itemView)
                .load(item.content_image?.url)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(ivContent)

            itemView.setOnClickListener {
                //viewholder = binding.root와 동일 전체 영역을 잡음
                onClickEpisode(item)

            }

        }
    }
}



