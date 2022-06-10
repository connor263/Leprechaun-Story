package com.miniclip.car.ui.game.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.miniclip.car.data.model.TicTaePlayerModel
import com.miniclip.car.utils.listOfDecals

@Composable
fun PlayerChoosingDrawable(
    modifier: Modifier = Modifier,
    xStep: Int,
    yStep: Int,
    player: TicTaePlayerModel
) {
    var expanded by remember { mutableStateOf(false) }
    Card(modifier = modifier, shape = RoundedCornerShape(16.dp)) {
        Column(modifier = Modifier.clickable { expanded = true },
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "Player ${player.turn.ordinal + 1}",
                style = MaterialTheme.typography.h6
            )
            Spacer(Modifier.height(8.dp))
            Image(
                modifier = Modifier
                    .size(xStep.dp * 2, yStep.dp * 2),
                painter = painterResource(id = player.chosenDrawable),
                contentDescription = null,
                contentScale = ContentScale.Fit
            )

            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }) {
                listOfDecals.forEach {
                    DropdownMenuItem(
                        onClick = {
                            player.chosenDrawable = it
                            expanded = false
                        }) {
                        Image(
                            modifier = Modifier.size(xStep.dp, yStep.dp),
                            painter = painterResource(it),
                            contentDescription = null,
                            contentScale = ContentScale.Fit
                        )
                    }
                }
            }
        }
    }
}