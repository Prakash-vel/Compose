package com.example.compose

import android.content.Context
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.resolveDefaults
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import com.example.compose.ui.theme.Teal200
import com.example.compose.ui.theme.customBlack


@Composable
fun DetailContainer(context: Context, navController: NavHostController) {
    val scrollState= rememberScrollState()
    Scaffold(
        topBar = {
            TopAppBar(

                backgroundColor = Teal200,
                title = { Text(text = appName) },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            navController.popBackStack()
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack, contentDescription = null
                        )
                    }
                },
            )
        },
        bottomBar = {
            Row( modifier = Modifier.fillMaxWidth()
            ) {
                Surface(
                    Modifier.padding(start = 15.dp)
                        .clickable(onClick = {})
                        .width(130.dp)
                        .padding(10.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_edit_24),
                        contentDescription = null,
                        tint = Teal200
                    )

                }
                Surface(
                    Modifier
                        .clickable(onClick = {})
                        .width(130.dp)
                        .padding(10.dp).align(Alignment.CenterVertically)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_delete_24),
                        contentDescription = null,
                        tint = Teal200
                    )

                }
                Surface(
                    Modifier
                        .clickable(onClick = {})
                        .width(130.dp)
                        .padding(10.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_share_24),
                        contentDescription = null,
                        tint = Teal200
                    )

                }
            }
        }
    ) {

        Column(
            Modifier
                .verticalScroll(scrollState)) {
            Surface(
                shape = CircleShape,
                border = BorderStroke(2.dp, Black),
                modifier = Modifier
                    .padding(top = 60.dp, start = 10.dp, end = 10.dp, bottom = 30.dp)
                    .width(200.dp)
                    .height(200.dp)
                    .align(Alignment.CenterHorizontally),
                color = MaterialTheme.colors.onSurface.copy(alpha = 0.4f)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_baseline_person_24),
                    contentDescription = null
                )
            }

            Text(
                text = "First Name", fontSize = 34.sp, modifier = Modifier
                    .padding(top = 10.dp, start = 30.dp, bottom = 10.dp)
            )
            Text(
                text = "Last Name", fontSize = 28.sp, modifier = Modifier
                    .padding(top = 10.dp, start = 30.dp, bottom = 10.dp)
            )

            val theme = if (isSystemInDarkTheme()) customBlack else White


            TextField(
                value = "987654321",
                onValueChange = {},
                label = {
                    Text(text = "Mobile")
                }, readOnly = true,
                trailingIcon = {
                    IconButton(onClick = {
                    }) {
                        Icon(
                            imageVector = Icons.Default.Call,
                            contentDescription = null,
                            tint = Teal200
                        )
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(90.dp)
                    .padding(10.dp),
                textStyle = TextStyle(fontSize = 20.sp, letterSpacing = 1.sp),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = theme,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                )
            )
            TextField(
                value = "abcdefg@gmail.com",
                onValueChange = {},
                label = {
                    Text(text = "E Mail")
                }, readOnly = true,
                trailingIcon = {
                    IconButton(onClick = {
                    }) {
                        Icon(
                            imageVector = Icons.Default.Email,
                            contentDescription = null,
                            tint = Teal200
                        )
                    }
                },
                modifier = Modifier
                    .padding(bottom = 40.dp)
                    .fillMaxWidth()
                    .height(90.dp)
                    .padding(10.dp),
                textStyle = TextStyle(fontSize = 20.sp, letterSpacing = 0.5.sp),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = theme,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                )
            )
        }
    }
}