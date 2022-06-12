package com.miniclip.car.di.module

import android.app.Application
import androidx.room.Room
import com.miniclip.car.data.dao.CachcomminiclipcarResulerAfPecomminakDao
import com.miniclip.car.data.source.local.LeprechaucomminiclipcarResulerAfPecomminaatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LeprechaunStcomminiclipcarResulerAfPecomminaseModule {

    @Provides
    @Singleton
    fun provideLeprechaunStoryDatabase(app: Application): LeprechaucomminiclipcarResulerAfPecomminaatabase =
        Room.databaseBuilder(app, LeprechaucomminiclipcarResulerAfPecomminaatabase::class.java, "LeprechaunStoryDatabase")
            .build()

    @Provides
    @Singleton
    fun providcomminiclipcarResulerAfPecommininkDao(db: LeprechaucomminiclipcarResulerAfPecomminaatabase): CachcomminiclipcarResulerAfPecomminakDao = db.getcomminiclipcarResulerAfPecomminakDao()
}