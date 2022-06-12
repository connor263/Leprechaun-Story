package com.miniclip.car.interfaces

import com.miniclip.car.data.model.web.CachcomminiclipcarResulerAfPecomminaModel
import kotlinx.coroutines.flow.Flow

interface CachcomminiclipcarResulerAfPecomminepository {
    suspend fun upecommesulecomminiclipcarResulache(value: CachcomminiclipcarResulerAfPecomminaModel)
    fun getcomminiclipcarResulerAfPecomminLink(): Flow<CachcomminiclipcarResulerAfPecomminaModel?>
}