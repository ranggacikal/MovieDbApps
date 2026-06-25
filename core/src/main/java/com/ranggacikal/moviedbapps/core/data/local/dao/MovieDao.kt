package com.ranggacikal.moviedbapps.core.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ranggacikal.moviedbapps.core.data.local.entity.MovieEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {
    @Query(
        "SELECT * FROM favorite_movies"
    )
    fun getFavoriteMovies():
            Flow<List<MovieEntity>>

    @Insert(
        onConflict =
            OnConflictStrategy.REPLACE
    )
    suspend fun insertMovie(
        movie: MovieEntity
    )

    @Query(
        "DELETE FROM favorite_movies WHERE id = :movieId"
    )
    suspend fun deleteMovie(
        movieId: Int
    )

    @Query(
        """
    SELECT EXISTS(
        SELECT 1
        FROM favorite_movies
        WHERE id = :movieId
    )
    """
    )
    suspend fun isFavorite(
        movieId: Int
    ): Boolean
}