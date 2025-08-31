package com.example.a10__thun_mengse_pvh_oop_practice003.ui.component

import android.content.Context
import android.content.Intent
import androidx.activity.ComponentActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.a10__thun_mengse_pvh_oop_practice003.R

@Composable
fun NectarButton(context: Context, screen: ComponentActivity, text: String){
    Button(
        onClick = {
            val intent = Intent(context, screen::class.java)
            context.startActivity(intent)
        },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF53B175)
        ),
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
    ) {
        Text(
            text = text,
            fontSize = 23.sp,
            fontWeight = FontWeight.ExtraBold
        )
    }
}

@Composable
fun NectarTextField(label: String, isIcon: Boolean = false, getValue: (String) -> Unit){

    var x by remember { mutableStateOf("") }
    getValue(x)

    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp),
        value = x,
        onValueChange = { x = it },
        label = {
            Text(
                text = label,
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                color = Color(0xFF919090),
                modifier = Modifier.padding(bottom = 8.dp)
            )
        },
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = Color.Transparent,
            focusedContainerColor = Color.Transparent,
            focusedIndicatorColor = Color(0xFF53B175),
            unfocusedIndicatorColor = Color(0x73919090)
        ),
        singleLine = true,
        textStyle = TextStyle(
            fontSize = 18.sp
        ),
        trailingIcon = {
            if (isIcon) {
                Icon(
                    painter = painterResource(id = R.drawable.tick_icon),
                    contentDescription = "Visible Icon",
                    modifier = Modifier.size(20.dp),
                    tint = Color(0xFF53B175)
                )
            }
        },
        keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Done
            )
        )
}

// password text field
@Composable
fun NectarPassField(label: String, setPassword: (String) -> Unit){

    var password by remember { mutableStateOf("") }
    setPassword(password)

    var passwordVisibility by remember { mutableStateOf(false) }

    val icon = if (passwordVisibility)
        painterResource(id = R.drawable.visible_icon)
    else
        painterResource(id = R.drawable.invisible_icon)


    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp),
        value = password,
        onValueChange = { password = it },
        label = {
            Text(
                text = label,
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                color = Color(0xFF919090),
                modifier = Modifier.padding(bottom = 8.dp)
            )
        },
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = Color.Transparent,
            focusedContainerColor = Color.Transparent,
            focusedIndicatorColor = Color(0xFF53B175),
            unfocusedIndicatorColor = Color(0x73919090)
        ),
        singleLine = true,
        textStyle = TextStyle(
            fontSize = 18.sp
        ),
        trailingIcon = {
            IconButton(
                onClick = {
                    passwordVisibility = !passwordVisibility
                }
            ) {
                Icon(
                    painter = icon,
                    contentDescription = "Visible Icon",
                    modifier = Modifier.size(20.dp),
                )
            }
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password, // Keyboard type
            imeAction = ImeAction.Done            // Action button on keyboard
        ),
        visualTransformation = if (passwordVisibility)
            VisualTransformation.None
        else
            PasswordVisualTransformation(),
    )
}

@Composable
fun TopSection(title: String, description: String){

    // icon section

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.2f),
        contentAlignment = Alignment.TopCenter
    ){
        Image(
            painter = painterResource(id = R.drawable.orange_carrot),
            contentDescription = "Orange Carrot",
            modifier = Modifier
                .size(80.dp)
                .padding(top = 20.dp)
        )
    }

    // text section

    Text(
        text = title,
        fontSize = 30.sp,
        fontWeight = FontWeight.Medium
    )

    Spacer(modifier = Modifier.height(15.dp))

    Text(
        text = description,
        fontSize = 17.sp,
        fontWeight = FontWeight.W500,
        color = Color(0xFF919090),
    )
}

@Composable
fun Signup(description1: String, description2: String, context: Context, activity: ComponentActivity){
    Row (
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ){
        Text(
            text = description1,
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium
        )
        Text(
            text = " $description2",
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
            color = Color(0xFF53B175),
            modifier = Modifier
                .clickable{
                    val intent = Intent(context, activity::class.java)
                    context.startActivity(intent)
                }
        )
    }
}

@Preview
@Composable
fun SearchField(){

    var search by remember { mutableStateOf("") }

    TextField(
        value = search,
        onValueChange = {
            it -> search = it
                        },
        placeholder = {
            Text(
                text = "Search Store",
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium
            )
        },
        modifier = Modifier
            .fillMaxWidth()
            .height(65.dp)
            .clip(RoundedCornerShape(20.dp)),
        leadingIcon = {
            Icon(
                imageVector = Icons.Rounded.Search,
                contentDescription = "Search Icon",
                modifier = Modifier
                    .padding(start = 15.dp)
                    .size(30.dp)
            )
        },
        singleLine = true,
        textStyle = TextStyle(
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium
        ),
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Color.Transparent,   // remove line when focused
            unfocusedIndicatorColor = Color.Transparent, // remove line when not focused
            disabledIndicatorColor = Color.Transparent // remove line when disabled
        ),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Done
        ),
    )
}