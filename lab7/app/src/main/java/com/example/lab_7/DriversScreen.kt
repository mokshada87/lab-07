package com.example.lab_7

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun DriversScreen(navController: NavController) {
    var name by remember {
        mutableStateOf("")
    }
    val drivers = remember {
        mutableStateListOf<String>()
    }
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        Spacer(modifier = Modifier.height(16.dp))

    Button(
        onClick = {
            navController.popBackStack()
        },
        modifier = Modifier.testTag("driversBackButton"),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xfffc0362),
            contentColor = Color.White
        )
    ) {
        Text("Back")
    }
    Spacer(modifier = Modifier.height(16.dp))

    Text(text = "FormulaZero Drivers", fontSize = 40.sp)

    Spacer(modifier = Modifier.height(16.dp))

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        TextField(
            value = name,
            onValueChange = {
                name = it
            },
            label = {
                Text("Driver Name")
            },
            modifier = Modifier.weight(1f).testTag("driverInput")
        )
        Spacer(modifier = Modifier.width(8.dp))
        Button(
            onClick = {
                if (name.isNotBlank()) {
                    drivers.add(name)
                    name = ""
                }
            },
            modifier = Modifier.testTag("addDriverButton"),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xfffc0362),
                contentColor = Color.White
            )
        ) {
            Text("Add")
        }
    }
            Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                drivers.clear()
            },
            modifier = Modifier.testTag("clearDriversButton"),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xfffc0362),
                contentColor = Color.White
            )
        ) {
            Text("Clear")
        }

        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn {
            items(drivers) { driver ->
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = driver,
                    fontSize = 24.sp
                )
            }
        }
    }
}



