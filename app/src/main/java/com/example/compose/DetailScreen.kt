package com.example.compose

import android.content.Context
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

class DetailScreen {
}

@Composable
fun DetailContainer(context: Context, navController: NavHostController) {
    Text(text = "This is the Detail screen")
}