package com.miniclip.car.ui.game

import android.util.Log
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import com.miniclip.car.data.model.TicTaeCell
import com.miniclip.car.data.model.TicTaePlayerModel
import com.miniclip.car.utils.enums.CellPosition
import com.miniclip.car.utils.enums.CrossedBy
import com.miniclip.car.utils.enums.PlayerTurn
import com.miniclip.car.utils.listOfDecals
import com.miniclip.car.utils.listOfPossibleMatches
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class GameViewModel @Inject constructor() : ViewModel() {
    var uiState = MutableStateFlow<GameEvent?>(null)
        private set

    var cellsList = mutableStateListOf(
        TicTaeCell(
            position = CellPosition.TOP_START,
            row = 1, column = 1,
        ),
        TicTaeCell(
            position = CellPosition.TOP,
            row = 1, column = 2,
        ),
        TicTaeCell(
            position = CellPosition.TOP_END,
            row = 1, column = 3,
        ),

        TicTaeCell(
            position = CellPosition.CENTER_START,
            row = 2, column = 1,
        ),
        TicTaeCell(
            position = CellPosition.CENTER,
            row = 2, column = 2,
        ),
        TicTaeCell(
            position = CellPosition.CENTER_END,
            row = 2, column = 3,
        ),

        TicTaeCell(
            position = CellPosition.BOTTOM_START,
            row = 3, column = 1
        ),
        TicTaeCell(
            position = CellPosition.BOTTOM,
            row = 3, column = 2
        ),
        TicTaeCell(
            position = CellPosition.BOTTOM_END,
            row = 3, column = 3
        ),
    )
        private set

    var player1 by mutableStateOf(TicTaePlayerModel())
    var player2 by mutableStateOf(
        TicTaePlayerModel(
            turn = PlayerTurn.SECOND_PLAYER,
            markType = CrossedBy.SECOND_PLAYER_MARK
        )
    )

    var playerTurn by mutableStateOf(PlayerTurn.FIRST_PLAYER)
        private set

    fun markCell(position: CellPosition) {
        if (cellsList.none { it.crossedBy == CrossedBy.BLANK }) return
        cellsList.find { it.position == position && it.crossedBy == CrossedBy.BLANK }
            ?.let { foundCell ->
                val player = when (playerTurn) {
                    PlayerTurn.FIRST_PLAYER -> player1
                    PlayerTurn.SECOND_PLAYER -> player2
                }
                foundCell.crossedBy = player.markType
                foundCell.drawableRes = player.chosenDrawable


                val dumb = TicTaeCell(row = -1, crossedBy = CrossedBy.FIRST_PLAYER_MARK)
                cellsList.add(dumb)
                cellsList.remove(dumb)

                checkForWin(player)
                playerTurn = when (playerTurn) {
                    PlayerTurn.FIRST_PLAYER -> {
                        player2.turn
                    }
                    PlayerTurn.SECOND_PLAYER -> {
                        player1.turn
                    }
                }

                if (playerTurn == player2.turn && player2.isAi && !player2.hasTurn) {
                    player2.hasTurn = true

                    val randomBlanks =
                        cellsList.filter { it.crossedBy == CrossedBy.BLANK }
                    if (randomBlanks.isNullOrEmpty()) {
                        return
                    }

                    fun getRand(): TicTaeCell {
                        return randomBlanks.random()
                    }

                    var index = 0
                    var rand = getRand()

                    fun mark() {
                        if (checkForWin(player1, checkCanWin = true, rand) ||
                            checkForWin(player2, checkCanWin = true, rand) ||
                            index >= 15
                        ) {
                            markCell(position = rand.position)
                        } else {
                            rand = getRand()
                            index++
                            mark()
                        }
                    }
                    mark()
                } else {
                    player2.hasTurn = false
                }
            }
    }

    private fun checkForWin(
        player: TicTaePlayerModel,
        checkCanWin: Boolean = false,
        checkCell: TicTaeCell? = null
    ): Boolean {
        val winCells = mutableListOf<TicTaeCell>()
        listOfPossibleMatches.forEach { checkList ->
            val list = checkList.toMutableList()
            if (checkCanWin) list.add(checkCell!!)
            list.forEach { checkCell ->
                cellsList.find { it.position == checkCell.position && it.crossedBy == player.markType }
                    ?.run {
                        winCells.add(this)
                    }
            }
            if (winCells.size == 3) {
                return if (checkCanWin) {
                    true
                } else {
                    winCells.forEach { check ->
                        cellsList.find { it.position == check.position && it.crossedBy == player.markType }
                            ?.run {
                                isWin = true
                            }
                    }
                    sendGameEndEvent(winPlayer = player, isAi = player.isAi, draw = false)
                    true
                }

            } else {
                winCells.clear()
            }
        }
        if (cellsList.none { it.crossedBy == CrossedBy.BLANK }) sendGameEndEvent(
            winPlayer = player,
            isAi = player.isAi,
            draw = true
        )
        return false
    }

    fun checkPlayersDrawable(singleplayer: Boolean) {
        if (player1.chosenDrawable == player2.chosenDrawable) {
            if (!singleplayer) {
                player1.chosenDrawable = listOfDecals.random()
            }
            player2.chosenDrawable = listOfDecals.random()
            checkPlayersDrawable(singleplayer)
        }
    }


    fun sendGameEndEvent(
        show: Boolean? = true,
        winPlayer: TicTaePlayerModel? = null,
        isAi: Boolean? = null,
        draw: Boolean? = null
    ) {
        uiState.value = if (show == true) GameEvent.GameOver(winPlayer, isAi, draw) else null
    }


    sealed class GameEvent {
        data class GameOver(
            val winPlayer: TicTaePlayerModel?,
            val isAi: Boolean?,
            val draw: Boolean?
        ) : GameEvent()
    }
}