package com.miniclip.car.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.miniclip.car.Maicomminiclipcarodel

@Composable
fun Inicomminiclipcareen() {
    val viewcomminiclipcarl: Maicomminiclipcarodel = hiltViewModel()
    var iscomminiclipcaring by remember { mutableStateOf(true) }

    Surface(Modifier.fillMaxSize(), color = Color.Black) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            if (iscomminiclipcaring) {
                CircularProgressIndicator(Modifier.size(120.dp), color = Color.White)
            } else {
                AlertDialog(
                    modifier = Modifier.padding(4.dp),
                    shape = RoundedCornerShape(16.dp),
                    title = {
                        Text(
                            "No internet connection",
                            style = MaterialTheme.typography.h4
                        )
                    },
                    text = {
                        Text(
                            "Check your internet connection and try again later",
                            style = MaterialTheme.typography.body2
                        )
                    },
                    onDismissRequest = { viewcomminiclipcarl.onEcomminiclipcar(Maicomminiclipcarodel.MaincomminiclipcarEvent.IncomminiclipcarEvent) },
                    confirmButton = {
                        TextButton(onClick = { viewcomminiclipcarl.onEcomminiclipcar(Maicomminiclipcarodel.MaincomminiclipcarEvent.IncomminiclipcarEvent) }) {
                            Text("Try again", style = MaterialTheme.typography.button)
                        }
                    })
            }
        }
    }

    LaunchedEffect(viewcomminiclipcarl.isLcomminiclipcaring) {
        iscomminiclipcaring = viewcomminiclipcarl.isLcomminiclipcaring
    }
}