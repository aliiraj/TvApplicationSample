package com.example.tvapplicationsample.presentation.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tvapplicationsample.R
import com.example.tvapplicationsample.data.models.Movie

class MovieAdapter(
    private val movies: List<Movie>
) : RecyclerView.Adapter<MovieAdapter.ViewHolderMovies>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolderMovies {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.movie_item, viewGroup, false)
        return ViewHolderMovies(view)
    }

    override fun onBindViewHolder(holder: ViewHolderMovies, position: Int) {
        holder.apply {
            titleMovie.text = movies[position].title
            Glide.with(itemView.context)
                .load(movies[position].cardImageUrl)
                .centerCrop()
                .into(imgMovie)
        }
    }

    override fun getItemCount() = movies.size

    inner class ViewHolderMovies(view: View) : RecyclerView.ViewHolder(view) {
        val titleMovie = view.findViewById<View>(R.id.movie_title) as TextView
        val imgMovie = view.findViewById<View>(R.id.img_movie) as ImageView
    }
}