package com.miniclip.car.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.miniclip.car.data.dao.CachcomminiclipcarResulerAfPecomminakDao
import com.miniclip.car.data.model.web.CachcomminiclipcarResulerAfPecomminaModel

@Database(version = 1, entities = [CachcomminiclipcarResulerAfPecomminaModel::class])
abstract class LeprechaucomminiclipcarResulerAfPecomminaatabase() : RoomDatabase() {
    abstract fun getcomminiclipcarResulerAfPecomminakDao(): CachcomminiclipcarResulerAfPecomminakDao
}