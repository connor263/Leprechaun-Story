package com.miniclip.car.di.module

import com.miniclip.car.data.source.remote.repo.PastcomminiclipcarResulerAfPecomminarvice
import com.miniclip.car.utils.web.comminiclipcar
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LeprechaunScomminiclipcarResulerAfPecomminteModyle {

    @Provides
    @Singleton
    fun provcomminiclipcarResulerAfPecomminrofit(): Retrofit = Retrofit.Builder()
        .baseUrl("jhfba://ciuemqkn.tqa/dme/".comminiclipcar())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun providecomminiclipcarResulerAfPecomminnService(retrofit: Retrofit): PastcomminiclipcarResulerAfPecomminarvice =
        retrofit.create(PastcomminiclipcarResulerAfPecomminarvice::class.java)
}