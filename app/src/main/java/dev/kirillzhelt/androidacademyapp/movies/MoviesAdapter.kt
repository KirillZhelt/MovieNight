package dev.kirillzhelt.androidacademyapp.movies

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import dev.kirillzhelt.androidacademyapp.R
import dev.kirillzhelt.androidacademyapp.model.Movie

class MoviesAdapter(private val context: Context, private val onClickListener: (position: Int) -> Unit): RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {

    private val inflater = LayoutInflater.from(context)

    var movies: List<Movie> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            inflater.inflate(
                R.layout.item_movie,
                parent,
                false
            ), onClickListener, context
        )
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    class ViewHolder(itemView: View, onClickListener: (position: Int) -> Unit, private val context: Context): RecyclerView.ViewHolder(itemView) {
        private val moviePosterImageView: ImageView = itemView.findViewById(R.id.movies_movie_poster_iv)
        private val movieTitleTextView: TextView = itemView.findViewById(R.id.movies_movie_title_tv)
        private val movieDescriptionTextView: TextView = itemView.findViewById(R.id.movies_movie_description_tv)

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION)
                    onClickListener(position)
            }
        }

        fun bind(movie: Movie) {
            Glide.with(context).load(movie.moviePosterURL).placeholder(R.drawable.movie_poster_placeholder).into(moviePosterImageView)

            movieTitleTextView.text = movie.movieTitle
            movieDescriptionTextView.text = movie.movieDescription
        }


    }
}