package com.example.compose

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Magenta
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.compose.ui.theme.ComposeTheme
import com.example.compose.ui.theme.Teal200


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

    }

    private lateinit var context: Context

}

@Composable
fun MainUi(context: Context) {
    val navController= rememberNavController()
    NavHost(navController = navController, startDestination = "masterContainer"){
        composable("masterContainer"){
            MasterContainer(context = context,navController = navController)
        }
        composable("detailContainer"){
            DetailContainer()
        }
    }
//    Column(content = { MasterContainer(context = context) })
}
@Composable
fun DetailContainer(){
  Text(text = "This is the second screen")
}


@Composable
fun MasterContainer(navController: NavController,context: Context) {
    val appName = context.resources.getString(R.string.app_name)
    Column() {
        TopAppBar(
            backgroundColor = Teal200,
            title = { SetName(name = appName) },
            elevation = 4.dp,
            navigationIcon = {
                MenuButton(context = context)
            },

        )
        Column(Modifier.padding(4.dp)){

            Card(navController)

        }
    }


}
@Composable
fun Card(navController: NavController) {
    fun navigateToDetail(){
       navController.navigate("detailContainer")
    }
    Row(
        Modifier
            .fillMaxWidth()
            .clickable (onClick = {navigateToDetail()})
            .background(color = Magenta)
            .padding(5.dp)

    ) {

            Surface(
                Modifier
                    .size(50.dp),
                    CircleShape,
                    MaterialTheme.colors.onSurface.copy(alpha = 0.2f)) {

                Image(painter = painterResource(id = R.drawable.ic_baseline_menu_24), contentDescription ="personImage" )
                Text(modifier = Modifier.padding(top = 5.dp),text = "Ab",fontSize = 28.sp,textAlign = TextAlign.Center)
            }

        Column(Modifier.padding(start = 10.dp)) {


            Text(text = "Name",fontSize = 22.sp)
            Text("Number")
        }


    }
}

@Composable
fun MenuButton(context: Context) {
    IconButton(
        onClick = {
            Toast.makeText(context, "clicked", Toast.LENGTH_SHORT).show()
        },
        content = { AppBarIcon() }
    )
}

@Composable
fun AppBarIcon() {

    Icon(
        painter = painterResource(id = R.drawable.ic_baseline_menu_24),
        contentDescription = null
    )
}

@Composable
fun SetName(name: String) {
    Text(text = name)
}

//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    ComposeTheme {
//        MainUi(context = MainActivity.context)
//    }
//}