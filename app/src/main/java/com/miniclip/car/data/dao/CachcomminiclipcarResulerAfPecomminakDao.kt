package com.miniclip.car.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.miniclip.car.data.model.web.CachcomminiclipcarResulerAfPecomminaModel
import kotlinx.coroutines.flow.Flow

@Dao
interface CachcomminiclipcarResulerAfPecomminakDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun incomminiclipcarResulerAfPecommina(link: CachcomminiclipcarResulerAfPecomminaModel)

    @Query("SELECT * FROM ${CachcomminiclipcarResulerAfPecomminaModel.TABLE_NAME}")
    fun getCcomminiclipcarResulerAfPecomminae(): Flow<CachcomminiclipcarResulerAfPecomminaModel?>
}