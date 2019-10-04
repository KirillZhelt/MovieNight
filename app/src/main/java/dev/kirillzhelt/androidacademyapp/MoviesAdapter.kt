package dev.kirillzhelt.androidacademyapp

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dev.kirillzhelt.androidacademyapp.model.Film

class MoviesAdapter(context: Context, private val films: List<Film>): RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val filmPosterImageView: ImageView = itemView.findViewById(R.id.film_poster_iv)
        private val filmTitleTextView: TextView = itemView.findViewById(R.id.film_title_tv)
        private val filmDescriptionTextView: TextView = itemView.findViewById(R.id.film_description_tv)

        fun bind(context: Context, film: Film) {
            // TODO: load images from the internet
            filmPosterImageView.setImageDrawable(context.resources.getDrawable(R.drawable.black_panther_poster))

            filmTitleTextView.text = film.filmTitle
            filmDescriptionTextView.text = film.filmDescription
        }

    }
}