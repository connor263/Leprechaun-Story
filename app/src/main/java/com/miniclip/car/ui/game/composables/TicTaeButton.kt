package com.miniclip.car.ui.game.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TicTaeButton(modifier: Modifier = Modifier, text: String, action: () -> Unit) {
    TextButton(
        modifier = modifier.padding(16.dp),
        border = BorderStroke(2.dp, Color.White),
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Green.copy(
                blue = 0.8F
            )
        ),
        onClick = { action() }
    ) {
        Text(
            modifier = Modifier.padding(horizontal = 32.dp, vertical = 8.dp),
            text = text,
            style = MaterialTheme.typography.button.copy(
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        )
    }
}