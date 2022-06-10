package com.example.challange8.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class NowPlayingMoviesAdapter (private val onClick : (ResultNowPlaying) -> Unit): ListAdapter<ResultNowPlaying, NowPlayingMoviesAdapter.MoviesHolder>(
    Differ()
) {

    class MoviesHolder(private val binding: ItemCardMovieBinding ) : RecyclerView.ViewHolder(binding.root){
        fun bind(currentMovies: ResultNowPlaying, onClick: (ResultNowPlaying)-> Unit){
            binding.apply {
                tvJudul.text = currentMovies.title
                Glide.with(root)
                    .load("${Constant.BASE_IMAGE}${currentMovies.posterPath}")
                    .into(ivPoster)
                root.setOnClickListener{
                    onClick(currentMovies)
                }
            }
        }
    }

    class Differ : DiffUtil.ItemCallback<ResultNowPlaying>() {
        override fun areItemsTheSame(
            oldItem: ResultNowPlaying,
            newItem: ResultNowPlaying
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: ResultNowPlaying,
            newItem: ResultNowPlaying
        ): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesHolder {
        val binding = ItemCardMovieBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MoviesHolder(binding)
    }

    override fun onBindViewHolder(holder: MoviesHolder, position: Int) {
        holder.bind(getItem(position), onClick)

    }

}


