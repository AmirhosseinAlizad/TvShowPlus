package com.example.tvshowplus.ui.adapter

import android.content.DialogInterface
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.tvshowplus.DetailsActivity
import com.example.tvshowplus.R
import com.example.tvshowplus.data.model.TvShowsItem
import com.example.tvshowplus.databinding.MovieItemBinding
import javax.annotation.Nonnull

class TvShowsAdapter : Adapter<TvShowsViewHolder>() {
    private lateinit var binding: MovieItemBinding
    private val diffCallBack = object : DiffUtil.ItemCallback<TvShowsItem>() {
        // private var onClickListener: DialogInterface.OnClickListener? = null
        override fun areItemsTheSame(oldItem: TvShowsItem, newItem: TvShowsItem): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: TvShowsItem, newItem: TvShowsItem): Boolean =
            oldItem == newItem

    }
    private val differ = AsyncListDiffer(this, diffCallBack)
    var tvShowsModel: List<TvShowsItem>
        get() = differ.currentList
        set(value) = differ.submitList(value)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowsViewHolder =
        TvShowsViewHolder(
            MovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun getItemCount(): Int {
        return tvShowsModel.size
    }

    override fun onBindViewHolder(holder: TvShowsViewHolder, position: Int) {
        holder.bindViews(tvShowsModel[position])

    }

}