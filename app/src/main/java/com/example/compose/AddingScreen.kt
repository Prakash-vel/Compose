package com.example.compose

import android.content.Context
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.compose.ui.theme.Teal200

@ExperimentalComposeUiApi
@Composable
fun AddingContainer(context: Context, navController: NavHostController) {
    val focusRequester = FocusRequester.createRefs()
    val f1 = focusRequester.component1()
    val f2 = focusRequester.component2()
    val f3 = focusRequester.component3()
    val f4 = focusRequester.component4()
    val f5 = focusRequester.component5()
    val viewModel: AddingViewModel = viewModel()
    val scrollState = rememberScrollState()
    val name by viewModel.data.observeAsState(initial = "")

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
    ) {
        //Toolbar with backButton
        SecondaryToolbar(navController = navController)


        Column(
            modifier = Modifier
                .verticalScroll(scrollState)
                .fillMaxWidth()
                .padding(10.dp)

        )
        {


            Surface(
                modifier = Modifier
                    .padding(20.dp)
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
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth()
                        .focusRequester(f1),
                    value = name,
                    onValueChange = {
                        viewModel.search(it)
                    },
                    label = {
                        Text(text = "First Name")
                    },
                    colors = TextFieldDefaults.textFieldColors(backgroundColor = Teal200),
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(
                        capitalization = KeyboardCapitalization.Sentences,
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Next
                    ),
                    keyboardActions = KeyboardActions(onNext = {
                        f2.requestFocus()

                    })

                )

                TextField(
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth()
                        .focusRequester(f2),
                    value = name,
                    onValueChange = {
                        viewModel.search(it)
                    },
                    label = {
                        Text(text = "Last Name")
                    },
                    colors = TextFieldDefaults.textFieldColors(backgroundColor = Teal200),
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(
                        capitalization = KeyboardCapitalization.Sentences,
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Next
                    ),
                    keyboardActions = KeyboardActions(onNext = {
                        f3.requestFocus()
                    })
                )


                Row {

                    TextField(
                        modifier = Modifier
                            .padding(10.dp)
                            .width(100.dp)
                            .focusRequester(f3),
                        value = name,
                        onValueChange = {
                            viewModel.search(it)
                        },
                        label = {
                            Text(text = "Code")
                        },
                        colors = TextFieldDefaults.textFieldColors(backgroundColor = Teal200),
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(
                            capitalization = KeyboardCapitalization.Sentences,
                            keyboardType = KeyboardType.Number,
                            imeAction = ImeAction.Next
                        ),
                        keyboardActions = KeyboardActions(onNext = {
                            f4.requestFocus()
                        })
                    )

                    TextField(
                        modifier = Modifier
                            .padding(10.dp)
                            .fillMaxWidth()
                            .focusRequester(f4),
                        value = name,
                        onValueChange = {
                            viewModel.search(it)
                        },
                        label = {
                            Text(text = "Phone Number")
                        },
                        colors = TextFieldDefaults.textFieldColors(backgroundColor = Teal200),
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(
                            capitalization = KeyboardCapitalization.Sentences,
                            keyboardType = KeyboardType.Number,
                            imeAction = ImeAction.Next
                        ),
                        keyboardActions = KeyboardActions(onNext = {

                            f5.requestFocus()

                        })
                    )

                }

                Box {
                    val focusManager = LocalFocusManager.current

                    TextField(
                        modifier = Modifier
                            .padding(10.dp)
                            .fillMaxWidth()
                            .focusRequester(f5),
                        value = name,
                        onValueChange = {
                            viewModel.search(it)
                        },
                        label = {
                            Text(text = "E Mail")
                        },
                        colors = TextFieldDefaults.textFieldColors(backgroundColor = Teal200),
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(
                            capitalization = KeyboardCapitalization.Sentences,
                            keyboardType = KeyboardType.Email,
                            imeAction = ImeAction.Go
                        ),
                        keyboardActions = KeyboardActions(onGo = {

//                        f5.freeFocus()
                            focusManager.clearFocus()
                        })
                    )
                }

            }


            Row(
                Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(40.dp)
            ) {
                Button(
                    onClick = { navController.popBackStack() },
                    modifier = Modifier.padding(end = 10.dp)
                ) {
                    Text("Cancel")
                }
                Button(
                    onClick = { navController.popBackStack() },
                    modifier = Modifier.padding(start = 10.dp)
                ) {
                    Text("Add")

                }
            }

        }

    }
}
