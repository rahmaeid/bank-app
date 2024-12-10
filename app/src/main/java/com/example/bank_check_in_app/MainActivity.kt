package com.example.bank_check_in_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}
 

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    var phoneNumber by remember { mutableStateOf("") }
    var isValid by remember { mutableStateOf(true) }

    Scaffold(
    modifier = Modifier.fillMaxSize()
) { _ ->
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo), // Replace with your asset name
            contentDescription = "App Logo",
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
        )
        Spacer(modifier = Modifier.height(32.dp))

        // Phone Number Row
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Egyptian Flag
            Image(
                painter = painterResource(id = R.drawable.egypt_flag), // Replace with your drawable
                contentDescription = "Egypt Flag",
                modifier = Modifier.size(40.dp)
            )

            Spacer(modifier = Modifier.width(8.dp))

            // Country Code
            Text(
                text = "+20",
                fontSize = 18.sp,
                color = Color.Black
            )

            Spacer(modifier = Modifier.width(8.dp))

            // Phone Number Input
            OutlinedTextField(
                value = phoneNumber,
                onValueChange = { input ->
                    // Allow only numbers and limit to 10 digits
                    if (input.length <= 10 && input.all { it.isDigit() }) {
                        phoneNumber = input
                    }
                    isValid = phoneNumber.length == 10 // Update validation status
                },
                isError = !isValid,
                placeholder = { Text("Phone Number") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth()
            )
        }

        // Validation Error Message
        if (!isValid) {
            Text(
                text = "Phone number must be exactly 10 digits.",
                color = Color.Red,
                fontSize = 14.sp,
                modifier = Modifier.padding(top = 8.dp)
            )
        }
    }
}
}