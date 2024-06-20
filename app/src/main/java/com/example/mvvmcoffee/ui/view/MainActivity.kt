package com.example.mvvmcoffee.ui.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mvvmcoffee.data.dto.UserDTO
import com.example.mvvmcoffee.ui.theme.MVVMCoffeeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MVVMCoffeeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val user1: UserDTO = UserDTO(1, "Lucas")
                    val user2: UserDTO = UserDTO(2, "Thiago")
                    Greeting(
                        user1,
                        modifier = Modifier.padding(innerPadding)
                    )
                    Greeting(
                        user2,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(user: UserDTO, modifier: Modifier = Modifier) {
    Text(
        text = "Hello! You ID is ${user.getId} and your name is ${user.getName}",
        modifier = modifier
            .padding(24.dp)
            .height(8.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    val user1: UserDTO = UserDTO(1, "Lucas")
    val user2: UserDTO = UserDTO(2, "Thiago")
    MVVMCoffeeTheme {
        Greeting(user1)
        Greeting(user2)
    }
}