package com.subhambikash.jetpackcomposerecyclerviewandlistview

import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.subhambikash.jetpackcomposerecyclerviewandlistview.ui.theme.JetPackComposeRecyclerViewAndListViewTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            JetPackComposeRecyclerViewAndListViewTheme {
//                // A surface container using the 'background' color from the theme
//                Surface(modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colors.background) {
//                    Greeting("Android")
//                }
//            }

         //  ListView()

            RecyclerView()


        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetPackComposeRecyclerViewAndListViewTheme {
        Greeting("Android")
    }
}

@Composable
fun ListView(){
    val scrollState= rememberScrollState()
    Column(modifier = Modifier.verticalScroll(scrollState).padding(10.dp,0.dp,0.dp,0.dp)) {
        for (i in 0..100){

            Text(text = "text ${i+1}", style = MaterialTheme.typography.h3)
            Divider(color = Color.Black, thickness = 10.dp)
            
        }
    }

}

@Composable
fun RecyclerView(){
    val context= LocalContext.current
    LazyColumn(modifier = Modifier.padding(10.dp,0.dp)){

        items(100) {
            Text(text = "text ${it+1} ", style = MaterialTheme.typography.h3, modifier = Modifier.clickable {
                Toast.makeText(context,"$it selected item",Toast.LENGTH_SHORT).show()
            }.fillMaxWidth())
            Divider(color = Color.Red, thickness = 5.dp)
        }

    }
}