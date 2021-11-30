package com.slabcode.servinformacion.tmdbapp.data.db

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth
import com.slabcode.servinformacion.tmdbapp.data.model.movie.Movie
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MovieDaoTest {

    /**
     * Rule that executes each task synchronously.
     */
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var movieDao: MovieDao
    private lateinit var tmdbDatabase: TMDBDatabase

    @Before
    fun setUp() {
        /**
         * Room allows us to create a db instance that will only live when performing test and does not persist data afterwards
         */
        tmdbDatabase = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            TMDBDatabase::class.java
        ).build()

        movieDao = tmdbDatabase.movieDao()
    }

    @After
    fun tearDown() {
        tmdbDatabase.close()

    }

    @Test
    fun saveMovies_movieListGiven_savedCorrectly() = runBlocking {
        val movies = listOf(
            Movie(1, "overview1", "path1", "releaseDate1", "title1"),
            Movie(2, "overview2", "path2", "releaseDate2", "title2"),
            Movie(3, "overview2", "path2", "releaseDate2", "title2")
        )
        movieDao.saveMovies(movies)
        val response = movieDao.getMovies()
        Truth.assertThat(response).isEqualTo(movies)
    }

    @Test
    fun deleteAllMovies_deletedCorrectly() = runBlocking {

        val movies = listOf(
            Movie(1, "overview1", "path1", "releaseDate1", "title1"),
            Movie(2, "overview2", "path2", "releaseDate2", "title2"),
            Movie(3, "overview2", "path2", "releaseDate2", "title2")
        )
        movieDao.saveMovies(movies)
        movieDao.deleteAllMovies()
        val response = movieDao.getMovies()
        Truth.assertThat(response).isEmpty()

    }
}