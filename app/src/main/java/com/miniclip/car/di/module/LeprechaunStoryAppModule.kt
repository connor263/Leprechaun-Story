package com.miniclip.car.di.module

import androidx.lifecycle.MutableLiveData
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LeprechaunStoryAppModule {
    @Provides
    @Singleton
    fun provideAfLiveData() = MutableLiveData<MutableMap<String, Any>>()
}