package com.miniclip.car.data.model

import androidx.annotation.DrawableRes
import com.miniclip.car.utils.enums.CellPosition
import com.miniclip.car.utils.enums.CrossedBy

data class TicTaeCell(
    var column: Int = 0,
    var row: Int = 0,
    var position: CellPosition = CellPosition.TOP_START,
    @DrawableRes var drawableRes: Int = -1,
    var crossedBy: CrossedBy = CrossedBy.BLANK,
    var isWin:Boolean = false
)