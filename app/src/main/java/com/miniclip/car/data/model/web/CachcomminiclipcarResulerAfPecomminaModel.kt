package com.miniclip.car.data.model.web

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.miniclip.car.data.model.web.CachcomminiclipcarResulerAfPecomminaModel.Companion.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class CachcomminiclipcarResulerAfPecomminaModel(
    @PrimaryKey val id: Int = 0,
    val link: String = ""
) {
    companion object {
        const val TABLE_NAME = "CacheLinkModel"
    }
}