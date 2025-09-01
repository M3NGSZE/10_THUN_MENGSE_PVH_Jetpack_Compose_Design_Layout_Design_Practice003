package com.example.a10__thun_mengse_pvh_oop_practice003.ui.PracticeActivity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class PracticeActivity : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Practice()
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun Practice(){
    Scaffold (
        topBar = {
            PracticeTopBar()
        }
    ){
        paddingValues ->
        Column (
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            PracticeTextFiled(namePass =  "First Name")

            Spacer(modifier = Modifier.height(20.dp))

            PracticeTextFiled(namePass =  "Last Name")

            Spacer(modifier = Modifier.height(20.dp))

            PracticeCheckBox()

            Spacer(modifier = Modifier.height(20.dp))

            PracticeButton()
        }
    }
}

@Composable
fun PracticeButton(){
    Button(
        modifier = Modifier
            .padding(start = 190.dp),
        onClick = {},
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFFC4A4D)
        )
    ) {
        Text(
            text = "Submit"
        )
    }
}

@Composable
fun PracticeCheckBox(){

    var checkVal by remember { mutableStateOf(false) }

    Row (
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ){
        Checkbox(
            checked = checkVal,
            onCheckedChange = {checkVal = it},
            colors = CheckboxDefaults.colors(
                checkedColor = Color(0xFFF96266),      // when checked
                uncheckedColor = Color.Gray,     // when unchecked
                checkmarkColor = Color.White     // color of the checkmark inside
            )
        )
        Text(
            text = "I agree to the terms and conditions",
            fontWeight = FontWeight.Medium,
            fontSize = 15.sp
        )
    }
}

@Composable
fun PracticeTextFiled(namePass: String){

    var name by remember { mutableStateOf("") }

    OutlinedTextField(
        value = name,
        onValueChange = {name = it},
        leadingIcon = {
            Icon(
                imageVector = Icons.Rounded.Person,
                contentDescription = "Person Icon",
                modifier = Modifier
                    .size(25.dp)
            )
        },
        placeholder = {
            Text(
                text = namePass,
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium
            )
        },
        singleLine = true,
        textStyle = TextStyle(
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium
        ),
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Color.Gray,
            unfocusedIndicatorColor = Color.Gray,
            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent,
        )

    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PracticeTopBar(){
    TopAppBar(
        title = {
            Text(
                text = "Android Class",
                color = Color.White
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color(0xFFFB6266)
        ),
        navigationIcon = {
            IconButton(
                onClick = {}
            ) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "Hammer Icon",
                    tint = Color.White
                )
            }
        },
        actions = {
            IconButton(
                onClick = {}
            ) {
                Icon(
                    imageVector = Icons.Default.Notifications,
                    contentDescription = "Hammer Icon",
                    tint = Color.White
                )
            }
        }
    )
}