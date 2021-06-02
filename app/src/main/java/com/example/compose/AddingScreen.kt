package com.example.compose

import android.content.Context
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.compose.ui.theme.Teal200

//class AddingScreen {
//}

@Composable
fun AddingContainer(context: Context, navController: NavHostController) {

    val viewModel: AddingViewModel = viewModel()
    val scrollState = rememberScrollState()
    val name by viewModel.data.observeAsState(initial = "")
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
    ) {
        //Toolbar with backButton
        secondaryToolbar(navController = navController)


        Column(
            modifier = Modifier
                .verticalScroll(scrollState)
                .fillMaxWidth()
                .padding(10.dp)
        )
        {


            Surface(
                modifier = Modifier
                    .clip(RoundedCornerShape(5.dp))
                    .width(150.dp)
                    .height(150.dp)
                    .align(Alignment.CenterHorizontally)
                    .clickable(onClick = {}),
                shape = RectangleShape,
                MaterialTheme.colors.onSurface.copy(alpha = 0.4f),


                ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_baseline_person_24),
                    contentDescription = null
                )
            }

            Column(
                modifier = Modifier
                    .clip(RoundedCornerShape(15.dp))
                    .background(Teal200)
                    .padding(start = 20.dp, end = 20.dp, top = 30.dp, bottom = 30.dp)

            ) {

                TextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = name,
                    onValueChange = {
                        viewModel.search(it)
                    },
                    label = {
                        Text(text = "First Name")
                    },
                    colors = TextFieldDefaults.textFieldColors(backgroundColor = Teal200)

                )

                TextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = name,
                    onValueChange = {
                        viewModel.search(it)
                    },
                    label = {
                        Text(text = "Last Name")
                    },
                    colors = TextFieldDefaults.textFieldColors(backgroundColor = Teal200)
                )


                Row {

                    TextField(
                        modifier = Modifier.width(100.dp),
                        value = name,
                        onValueChange = {
                            viewModel.search(it)
                        },
                        label = {
                            Text(text = "Code")
                        },
                        colors = TextFieldDefaults.textFieldColors(backgroundColor = Teal200)
                    )

                    TextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = name,
                        onValueChange = {
                            viewModel.search(it)
                        },
                        label = {
                            Text(text = "Phone Number")
                        },
                        colors = TextFieldDefaults.textFieldColors(backgroundColor = Teal200)
                    )

                }

                TextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = name,
                    onValueChange = {
                        viewModel.search(it)
                    },
                    label = {
                        Text(text = "E Mail")
                    },
                    colors = TextFieldDefaults.textFieldColors(backgroundColor = Teal200)
                )

            }


            Row(
                Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(10.dp)
            ) {
                Button(
                    onClick = { navController.backQueue },
                    modifier = Modifier.padding(end = 10.dp)
                ) {
                    Text("Cancel")
                }
                Button(
                    onClick = { navController.backQueue },
                    modifier = Modifier.padding(start = 10.dp)
                ) {
                    Text("Add")

                }
            }

        }

    }
}
