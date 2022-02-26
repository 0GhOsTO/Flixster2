package com.example.testing_1

import org.json.JSONArray

data class Movie (
    val movieId: Int,
    val title: String,
    val posterPath: String,
    val overview: String,
) {
    val posterImageUrl = "https://image.tmdb.org/t/p/w342/$posterPath"
    companion object {
        fun fromJasonArray(movieJsonArray: JSONArray): List<Movie> {
            val movies = mutableListOf<Movie>()
            for (i in 0 until movieJsonArray.length()){
                val movieJson = movieJsonArray.getJSONObject(i)
                movies.add(
                    Movie(
                        movieJson.getInt("id"),
                        movieJson.getString("title"),
                        movieJson.getString("poster_path"),
                        movieJson.getString("overview")
                    )
                )
            }
            return movies
        }
    }
}
