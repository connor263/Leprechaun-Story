package com.miniclip.car.utils

import com.miniclip.car.R
import com.miniclip.car.data.model.TicTaeCell
import com.miniclip.car.utils.enums.CellPosition

val listOfDecals = listOf(
    R.drawable.decal_1,
    R.drawable.decal_2,
    R.drawable.decal_3,
    R.drawable.decal_4,
    R.drawable.decal_5,
    R.drawable.decal_6,
    R.drawable.decal_7,
    R.drawable.decal_8,
    R.drawable.decal_9
)


val listOfPossibleMatches = arrayListOf(
    // Horizontal
    listOf(
        TicTaeCell(position = CellPosition.TOP_START),
        TicTaeCell(position = CellPosition.TOP),
        TicTaeCell(position = CellPosition.TOP_END),
    ),
    listOf(
        TicTaeCell(position = CellPosition.CENTER_START),
        TicTaeCell(position = CellPosition.CENTER),
        TicTaeCell(position = CellPosition.CENTER_END),
    ),
    listOf(
        TicTaeCell(position = CellPosition.BOTTOM_START),
        TicTaeCell(position = CellPosition.BOTTOM),
        TicTaeCell(position = CellPosition.BOTTOM_END),
    ),

    // Vertical
    listOf(
        TicTaeCell(position = CellPosition.TOP_START),
        TicTaeCell(position = CellPosition.CENTER_START),
        TicTaeCell(position = CellPosition.BOTTOM_START),
    ),
    listOf(
        TicTaeCell(position = CellPosition.TOP),
        TicTaeCell(position = CellPosition.CENTER),
        TicTaeCell(position = CellPosition.BOTTOM),
    ),
    listOf(
        TicTaeCell(position = CellPosition.TOP_END),
        TicTaeCell(position = CellPosition.CENTER_END),
        TicTaeCell(position = CellPosition.BOTTOM_END),
    ),

    // Diagonal
    listOf(
        TicTaeCell(position = CellPosition.TOP_START),
        TicTaeCell(position = CellPosition.CENTER),
        TicTaeCell(position = CellPosition.BOTTOM_END),
    ),
    listOf(
        TicTaeCell(position = CellPosition.TOP_END),
        TicTaeCell(position = CellPosition.CENTER),
        TicTaeCell(position = CellPosition.BOTTOM_START),
    ),
)