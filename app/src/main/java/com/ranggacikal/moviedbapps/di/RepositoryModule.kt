package com.ranggacikal.moviedbapps.di

import com.ranggacikal.moviedbapps.core.data.local.datasource.MovieLocalDataSource
import com.ranggacikal.moviedbapps.core.data.local.datasource.MovieLocalDataSourceImpl
import com.ranggacikal.moviedbapps.core.data.remote.datasource.MovieRemoteDataSource
import com.ranggacikal.moviedbapps.core.data.remote.datasource.MovieRemoteDataSourceImpl
import com.ranggacikal.moviedbapps.core.data.remote.datasource.ReviewsRemoteDataSource
import com.ranggacikal.moviedbapps.core.data.remote.datasource.ReviewsRemoteDataSourceImpl
import com.ranggacikal.moviedbapps.core.data.repository.MovieRepositoryImpl
import com.ranggacikal.moviedbapps.core.data.repository.ReviewsRepositoryImpl
import com.ranggacikal.moviedbapps.core.domain.repository.MovieRepository
import com.ranggacikal.moviedbapps.core.domain.repository.ReviewRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindMovieRepository(
        impl: MovieRepositoryImpl
    ): MovieRepository

    @Binds
    abstract fun bindReviewsRepository(
        impl: ReviewsRepositoryImpl
    ): ReviewRepository

    companion object {

        @Provides
        @Singleton
        fun provideRemoteDataSource(
            impl: MovieRemoteDataSourceImpl
        ): MovieRemoteDataSource = impl

        @Provides
        @Singleton
        fun provideReviewsRemoteDataSource(
            impl: ReviewsRemoteDataSourceImpl
        ): ReviewsRemoteDataSource = impl

        @Provides
        @Singleton
        fun provideLocalDataSource(
            impl: MovieLocalDataSourceImpl
        ): MovieLocalDataSource = impl
    }
}