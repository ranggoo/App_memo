package com.john.episode.presentation.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.john.episode.GlideApp
import com.john.episode.databinding.ItemRecyclerEpisodeContentBinding
import com.john.episode.databinding.ItemRecyclerEpisodeDateBinding
import com.john.episode.domain.feed.entity.EpisodeFeedContentEntity
import com.john.episode.util.DateUtil.toEpisodeDateForm

private var itemDiffCallback = object : DiffUtil.ItemCallback<HomeEpisodeViewItem>() {
    override fun areItemsTheSame(oldItem: HomeEpisodeViewItem, newItem: HomeEpisodeViewItem): Boolean = when {
        oldItem is HomeEpisodeViewItem.Content && newItem is HomeEpisodeViewItem.Content -> oldItem.content.id == newItem.content.id
        oldItem is HomeEpisodeViewItem.Date && newItem is HomeEpisodeViewItem.Date -> oldItem.date == newItem.date
        else -> oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: HomeEpisodeViewItem, newItem: HomeEpisodeViewItem): Boolean = oldItem == newItem
}

class HomeAdapter(
    private val onClickEpisode: (EpisodeFeedContentEntity) -> Unit
) : ListAdapter<HomeEpisodeViewItem, HomeAdapter.EpisodeViewHolder>(itemDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodeViewHolder {
        return when (viewType) {
            CONTENT_VIEW_TYPE -> ContentViewHolder(
                ItemRecyclerEpisodeContentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )

            DATE_VIEW_TYPE -> DateViewHolder(
                ItemRecyclerEpisodeDateBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )
            else -> error("Not found viewholder...........")
        }
    }

    override fun onBindViewHolder(holder: EpisodeViewHolder, position: Int) = holder.bind(getItem(position))

    inner class ContentViewHolder(
        private val binding: ItemRecyclerEpisodeContentBinding
    ) : EpisodeViewHolder(binding.root) {

        override fun bind(_item: HomeEpisodeViewItem) {
            val item = (_item as? HomeEpisodeViewItem.Content)?.content
            with(binding) {
                item?.let {
                    //게시물 내용
                    tvContent.text = item.content
                    //작성자 닉네임
                    tvNickname.text = item.nick_name

                    //컨텐츠 이미지
                    GlideApp.with(itemView)
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
    }

    inner class DateViewHolder(
        private val binding: ItemRecyclerEpisodeDateBinding
    ) : EpisodeViewHolder(binding.root) {
        override fun bind(_item: HomeEpisodeViewItem) {
            val item = _item as? HomeEpisodeViewItem.Date
            binding.tvDate.text = item?.date?.toEpisodeDateForm()
        }
    }


    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is HomeEpisodeViewItem.Date -> DATE_VIEW_TYPE
            is HomeEpisodeViewItem.Content -> CONTENT_VIEW_TYPE
        }
    }

    abstract class EpisodeViewHolder(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {
        abstract fun bind(_item: HomeEpisodeViewItem)
    }

    companion object {
        private const val DATE_VIEW_TYPE = 0
        private const val CONTENT_VIEW_TYPE = 1
    }
}



