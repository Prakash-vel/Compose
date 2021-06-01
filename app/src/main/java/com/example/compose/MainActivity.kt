package com.example.compose

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.Cyan
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.compose.ui.theme.ComposeTheme
import com.example.compose.ui.theme.Purple200
import com.example.compose.ui.theme.Teal200
import kotlinx.coroutines.launch


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeTheme {
                context = this.applicationContext
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    MainUi(context = context)
                }
            }
        }
//        val viewModel: MasterViewModel by rem

    }

    private lateinit var context: Context

}

@Composable
fun MainUi(context: Context) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "masterContainer") {
        composable("masterContainer") {
            MasterContainer(context = context, navController = navController)
        }
        composable("detailContainer") {
            DetailContainer()
        }
        composable("addingContainer") {
            AddingContainer()
        }
    }
//    Column(content = { MasterContainer(context = context) })
}

@Composable
fun DetailContainer() {
    Text(text = "This is the Detail screen")
}

@Composable
fun AddingContainer() {
    Text("this is the adding screen")
}


@Composable
fun MasterContainer(navController: NavController, context: Context) {
    val viewModel: MasterViewModel = viewModel()
    val appName = context.resources.getString(R.string.app_name)
    //dummy(navController = navController, appName = appName)

    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .background(Teal200)
    ) {
        TopAppBar(
            backgroundColor = Teal200,
            title = { SetName(name = appName) },
//            elevation = 4.dp,
            navigationIcon = {
                IconButton(
                    onClick = {
                        scope.launch { scaffoldState.drawerState.open() }
                    }
                ) {
                    Icon(
                        painterResource(id = R.drawable.ic_baseline_menu_24),
                        contentDescription = null
                    )
                }
            },
            actions = {
//                IconButton(onClick = { navController.navigate("addingContainer") }) {
//                    Icon(
//                        painterResource(id = R.drawable.ic_baseline_person_add_alt_1_24),
//                        contentDescription = null
//                    )
//                }
                IconButton(onClick = { }) {
                    Icon(Icons.Default.Search, contentDescription = null)
                }
            }

        )
        val query by viewModel.data.observeAsState("Search")
        Box(
            Modifier
                .background(Purple200)
                .fillMaxWidth()
                .height(65.dp)
        ) {

            OutlinedTextField(
                value = query,
                onValueChange = { viewModel.search(it) },
                leadingIcon = {
                    Icon(imageVector = Icons.Filled.Search, contentDescription = null)
                },
                trailingIcon = {
                    IconButton(onClick = {

                    }) {
                        Icon(
                            imageVector = Icons.Filled.Close,
                            contentDescription = null
                        )
                    }
                },
                label = {
                    Text(text = "Search")
                },
                placeholder = {
                    Text(text = "type a name or number")
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Search,
                ), keyboardActions = KeyboardActions(onSearch = {
                    viewModel.search(query)
                    this.defaultKeyboardAction(imeAction = ImeAction.Search)

                })

            )

        }

        Scaffold(
            scaffoldState = scaffoldState,
            drawerContent = { Text(text = "DrawerContent") },
            floatingActionButtonPosition = FabPosition.End,
            floatingActionButton = {
                ExtendedFloatingActionButton(
                    text = { Text("Add") },
                    onClick = { navController.navigate("addingContainer") },
                    icon = {
                        Icon(
                            painterResource(id = R.drawable.ic_baseline_person_add_alt_1_24),
                            contentDescription = null
                        )
                    },
                )
            },
            content = {
                Column {

                    val scrollState = rememberLazyListState()
                    LazyColumn(
                        state = scrollState,
                        modifier = Modifier
                            .padding(4.dp)
                            .clip(RoundedCornerShape(10.dp))
                    ) {

                        items(10) {
                            Card(navController)

                        }
                    }
                }
            }
        )
    }

}


@Composable
fun Card(navController: NavController) {
    fun navigateToDetail() {
        navController.navigate("detailContainer")
    }
    Row(
        Modifier
            .fillMaxWidth()
            .clickable(onClick = { navigateToDetail() })
            .background(color = Cyan)
            .padding(5.dp)

    ) {

        Surface(
            Modifier
                .size(50.dp),
            CircleShape,
            MaterialTheme.colors.onSurface.copy(alpha = 0.2f)
        ) {

            Image(
                painter = painterResource(id = R.drawable.ic_baseline_menu_24),
                contentDescription = "personImage"
            )
            Text(
                modifier = Modifier.padding(top = 5.dp),
                text = "Ab",
                fontSize = 28.sp,
                textAlign = TextAlign.Center
            )
        }

        Column(Modifier.padding(start = 10.dp)) {


            Text(text = "Name", fontSize = 22.sp)
            Text("Number")
        }


    }
}


@Composable
fun SetName(name: String) {
    Text(text = name)
}

//@ExperimentalComposeUiApi
//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview(viewModel: MasterViewModel = viewModel()) {
//    var query = ""
//    ComposeTheme {
//
//
//    }
//}

//@Composable
//fun dummy(navController: NavController, appName: String) {
//    val scaffoldState = rememberScaffoldState()
//    val scope = rememberCoroutineScope()
//    Scaffold(
//        scaffoldState = scaffoldState,
//        drawerContent = { Text("Drawer content") },
//        topBar = {
//
//            TopAppBar(
//                title = { Text("Top app bar") },
//                navigationIcon = {
//                    IconButton(
//                        onClick = {
//                            scope.launch { scaffoldState.drawerState.open() }
//                        }
//                    ) {
//                        Icon(
//                            Icons.Filled.Menu,
//                            contentDescription = stringResource(R.string.app_name)
//                        )
//                    }
//                }
//            )
//        },
//        floatingActionButtonPosition = FabPosition.End,
//        floatingActionButton = {
//            ExtendedFloatingActionButton(
//                text = { Text("Extended FAB") },
//                onClick = { /* Handle FAB click */ }
//            )
//        },
//        content = { innerPadding ->
//            LazyColumn(contentPadding = innerPadding) {
//                items(count = 20) {
//                    Card(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .wrapContentHeight()
//                            .padding(16.dp)
//                    ) { /* Card content */ }
//                }
//            }
//        }
//    )
//}

