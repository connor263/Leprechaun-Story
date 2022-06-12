package com.miniclip.car.data.model.game

import androidx.annotation.DrawableRes
import com.miniclip.car.utils.game.enums.CellPosition
import com.miniclip.car.utils.game.enums.CrossedBy

data class TicTaeCell(
    var column: Int = 0,
    var row: Int = 0,
    var position: CellPosition = CellPosition.TOP_START,
    @DrawableRes var drawableRes: Int = -1,
    var crossedBy: CrossedBy = CrossedBy.BLANK,
    var isWin:Boolean = false
)