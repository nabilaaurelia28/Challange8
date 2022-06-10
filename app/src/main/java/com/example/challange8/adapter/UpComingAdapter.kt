package com.example.challange8.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class UpComingAdapter (private val onClick : (ResultUpComing) -> Unit) : ListAdapter<ResultUpComing, UpComingAdapter.MoviesHolder>(
    Differ()
) {
    class MoviesHolder (private val binding: ItemCardMovieBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(currentMovies : ResultUpComing, onClick: (ResultUpComing) -> Unit){
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

    class Differ : DiffUtil.ItemCallback<ResultUpComing>(){
        override fun areItemsTheSame(oldItem: ResultUpComing, newItem: ResultUpComing): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: ResultUpComing, newItem: ResultUpComing): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesHolder {
        val binding = ItemCardMovieBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MoviesHolder(binding)
    }

    override fun onBindViewHolder(holder: MoviesHolder, position: Int) {
        holder.bind(getItem(position),onClick)
    }
}
