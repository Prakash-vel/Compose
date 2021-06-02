package com.example.compose

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

class DetailScreen {
}

@Composable
fun DetailContainer(context: Context, navController: NavHostController) {

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
    ) {
        //Toolbar with backButton
        SecondaryToolbar(navController = navController)


        Text(text = "This is the Detail screen")
    }
}