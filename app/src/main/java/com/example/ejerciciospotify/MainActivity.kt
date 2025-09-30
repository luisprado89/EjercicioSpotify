package com.example.ejerciciospotify

import android.R.attr.title
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ejerciciospotify.ui.theme.EjercicioSpotifyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EjercicioSpotifyTheme {
                SpotifyHomeScreen()
            }
        }
    }
}

@Composable
fun SpotifyHomeScreen() {
    Scaffold(
        bottomBar = {
            NavigationBar(containerColor = Color.Black) {
                NavigationBarItem(
                    icon = {
                        Icon(
                            Icons.Default.Home,
                            contentDescription = "Home",
                            tint = Color.White
                        )
                    },
                    label = { Text("Home", color = Color.White) },
                    selected = true,
                    onClick = {}
                )
                NavigationBarItem(
                    icon = {
                        Icon(
                            Icons.Default.Search,
                            contentDescription = "Search",
                            tint = Color.White
                        )
                    },
                    label = { Text("Search", color = Color.White) },
                    selected = false,
                    onClick = {}
                )
                NavigationBarItem(
                    icon = {
                        Icon(
                            Icons.Default.ShoppingCart,
                            contentDescription = "Library",
                            tint = Color.White
                        )
                    },
                    label = { Text("Your Library", color = Color.White) },
                    selected = false,
                    onClick = {}
                )
            }
        },
        containerColor = Color.Black
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(Color.Red)
                .padding(16.dp)
        ) {
            //Titulo de arriba que saluda
            Text(
                text = "Good morning",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.padding(bottom = 15.dp)
            )
            //Rejilla de una playlists/de artistas
            val playlists = listOf(
                R.drawable.ic_launcher_foreground to "Hola 1",
                R.drawable.ic_launcher_foreground to "Hola 2",
                R.drawable.ic_launcher_foreground to "Hola 3",
                R.drawable.ic_launcher_foreground to "Hola 4",


                )
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(playlists) { (img, title) ->
                    Row(
                        modifier = Modifier
                            .background(Color.DarkGray, shape = RoundedCornerShape(8.dp))
                            .padding(8.dp)
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = img),
                            contentDescription = title,
                            modifier = Modifier.size(40.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(text = title, color = Color.White, fontSize = 12.sp)
                    }
                }
            }
            Spacer(modifier = Modifier.height(24.dp))
        //Siguiente apartado Made For You
        Text(
            text = "Made For You",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun SpotifyStarScreenPreview() {
    EjercicioSpotifyTheme {
        SpotifyHomeScreen()
    }
}