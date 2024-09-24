package com.mutia.recycleview.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.mutia.recycleview.DetailMovieActivity
import com.mutia.recycleview.R
import com.mutia.recycleview.RecycleViewCardMovie
import com.mutia.recycleview.model.ModelMovie

class MovieAdapter constructor(
    private val getActivity: RecycleViewCardMovie,// bisa diklik
    private val movieList: List<ModelMovie>,
    private val itemClickListener: (Int) -> Unit


) :

// private val itemClickListener: (Int) -> Unit
    RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtMovie: TextView = itemView.findViewById(R.id.txtMovie)
        val imgMovie: ImageView = itemView.findViewById(R.id.imgMovie)
        val cardView: CardView = itemView.findViewById(R.id.card_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_item_movie_card, parent, false)
        return MovieViewHolder(view)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movieList[position]
        holder.txtMovie.text = movie.title
        holder.imgMovie.setImageResource(movie.image)

        // Menambahkan event klik
        holder.itemView.setOnClickListener {

            val intent = Intent(getActivity,
                DetailMovieActivity::class.java)

            intent.putExtra("imageResId", movieList[position].image)
            intent.putExtra("title", movieList[position].title)
            intent.putExtra("tanggal", movieList[position].tanggal)
            intent.putExtra("sinopsis", movieList[position].sinopsis)
            getActivity.startActivity(intent)

        }
    }
}