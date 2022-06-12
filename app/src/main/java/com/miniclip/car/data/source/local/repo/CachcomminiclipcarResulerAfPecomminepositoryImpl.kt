package com.miniclip.car.data.source.local.repo

import com.miniclip.car.data.dao.CachcomminiclipcarResulerAfPecomminakDao
import com.miniclip.car.data.model.web.CachcomminiclipcarResulerAfPecomminaModel
import com.miniclip.car.interfaces.CachcomminiclipcarResulerAfPecomminepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CachcomminiclipcarResulerAfPecomminepositoryImpl @Inject constructor(private val cachcomminiclipcarResulerAfPecomminakDao: CachcomminiclipcarResulerAfPecomminakDao) :
    CachcomminiclipcarResulerAfPecomminepository {
    override suspend fun upecommesulecomminiclipcarResulache(value: CachcomminiclipcarResulerAfPecomminaModel) {
        cachcomminiclipcarResulerAfPecomminakDao.incomminiclipcarResulerAfPecommina(value)
    }

    override fun getcomminiclipcarResulerAfPecomminLink(): Flow<CachcomminiclipcarResulerAfPecomminaModel?> {
        return cachcomminiclipcarResulerAfPecomminakDao.getCcomminiclipcarResulerAfPecomminae()
    }
}