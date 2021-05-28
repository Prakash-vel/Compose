package com.example.compose

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.compose.ui.theme.ComposeTheme
import com.example.compose.ui.theme.Teal200


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    MainUi(this.applicationContext)
                }
            }
        }
    }
}

@Composable
fun MainUi(context: Context) {
    Column(
        content = { ToolBar(context = context) },
        modifier = Modifier.padding(top = 0.dp)
    )
}


@Composable
fun ToolBar(context: Context) {
    Image(
        painter = painterResource(id = R.drawable.ic_baseline_menu_24), contentDescription = null
    )

    val appName = context.resources.getString(R.string.app_name)
    TopAppBar(
        backgroundColor = Teal200,
        title = { SetName(name = appName) },
        elevation = 4.dp,
        navigationIcon = {
            MenuButton(context = context)
        }
    )

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
//        ToolBar("Android")
//    }
//}