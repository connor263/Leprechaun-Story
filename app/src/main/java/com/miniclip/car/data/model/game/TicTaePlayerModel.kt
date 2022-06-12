package com.miniclip.car.data.model.game

import androidx.annotation.DrawableRes
import com.miniclip.car.R
import com.miniclip.car.utils.game.enums.CrossedBy
import com.miniclip.car.utils.game.enums.PlayerTurn

data class TicTaePlayerModel(

    val turn: PlayerTurn = PlayerTurn.FIRST_PLAYER,
    val markType: CrossedBy = CrossedBy.FIRST_PLAYER_MARK,
    var isAi:Boolean = false,
    var hasTurn:Boolean = false,
    @DrawableRes var chosenDrawable: Int = R.drawable.decal_1,
)