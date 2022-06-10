package com.miniclip.car.ui.game

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.miniclip.car.MainActivity
import com.miniclip.car.R
import com.miniclip.car.ui.LeprechaunStoryNavKeys
import com.miniclip.car.ui.game.composables.TicTaeButton

@Composable
fun MenuScreen(navController: NavController) {
    val activity = LocalContext.current as MainActivity

    Image(
        modifier = Modifier.fillMaxSize(),
        painter = painterResource(id = R.drawable.game_bg_2),
        contentDescription = null,
        contentScale = ContentScale.FillBounds
    )

    Box(modifier = Modifier.fillMaxSize(),contentAlignment = Alignment.Center) {
        Card(shape = RoundedCornerShape(16.dp), backgroundColor = Color.Yellow.copy(blue = 0.7F,alpha = 0.9F)) {
            Column(
                modifier = Modifier.padding(32.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                TicTaeButton(text = "Single") {
                    navController.navigate(LeprechaunStoryNavKeys.Game().route)
                }
                Spacer(modifier = Modifier.height(16.dp))
                TicTaeButton(text = "1 vs 1") {
                    navController.navigate(LeprechaunStoryNavKeys.Game(false.toString()).route)
                }
                Spacer(modifier = Modifier.height(16.dp))
                TicTaeButton(text = "Exit") {
                    activity.finish()
                }
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

@Preview
@Composable
fun MenuScreenPreview() {
    MenuScreen(rememberNavController())
}