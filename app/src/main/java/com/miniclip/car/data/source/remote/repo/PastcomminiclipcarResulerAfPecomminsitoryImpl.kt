package com.miniclip.car.data.source.remote.repo

import com.miniclip.car.interfaces.PastcomminiclipcarResulerAfPecomminsitory
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PastcomminiclipcarResulerAfPecomminsitoryImpl @Inject constructor(private val pastcomminiclipcarResulerAfPecomminarvice: PastcomminiclipcarResulerAfPecomminarvice) :
    PastcomminiclipcarResulerAfPecomminsitory {
    override suspend fun fetchcomminiclipcarResulerAfPecomminSwitch(callback: suspend (String, Boolean) -> Unit) {
        pastcomminiclipcarResulerAfPecomminarvice.fcomminiclipcarResulerAfPecomminah().let {
            it.scomminiclipcarResulerAfPecomminah?.let { switch ->
                it.comminiclipcarResulerAfPecomminal?.let { url ->
                    callback(url, switch)
                }
            }
        }
    }
}