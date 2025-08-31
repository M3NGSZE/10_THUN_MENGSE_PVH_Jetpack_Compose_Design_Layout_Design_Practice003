package com.example.a10__thun_mengse_pvh_oop_practice003.ui.Activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.a10__thun_mengse_pvh_oop_practice003.R
import com.example.a10__thun_mengse_pvh_oop_practice003.ui.component.NectarPassField
import com.example.a10__thun_mengse_pvh_oop_practice003.ui.component.NectarTextField
import com.example.a10__thun_mengse_pvh_oop_practice003.ui.component.TopSection

class SignUpActivity : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Signup()
        }
    }
}

@Composable
fun Signup(){
    Column (
        modifier = Modifier
            .systemBarsPadding()
            .padding(25.dp)
    ) {
        val title = "Sign Up"
        val description = "Enter your credentials to continue"

        TopSection(title, description)

        Spacer(modifier = Modifier.height(35.dp))

        var username by remember { mutableStateOf("") }

        NectarTextField("Username") { u -> username = u}

        Spacer(modifier = Modifier.height(35.dp))

        var email by remember { mutableStateOf("") }

        NectarPassField1(
            label = "Emails",
            isIcon = true
        ) { e -> email = e }

        Spacer(modifier = Modifier.height(35.dp))

        var password by remember { mutableStateOf("") }

        NectarPassField("Password") { p -> password = p}

        // provide context of current screen use for navigation
        val context = LocalContext.current

        Spacer(modifier = Modifier.height(30.dp))

        TermPolicy()

        Spacer(modifier = Modifier.height(30.dp))

        var validationState by remember { mutableStateOf(true) }

        SignupButton(
            username = null,
            email = email,
            password = password,
            context = context,
            setValidationState = {
                    v -> validationState = v
            }
        ){
            username, email, password, context -> validationSignUp(username, email, password, context)
        }
    }
}

@Composable
fun NectarPassField1(label: String, isIcon: Boolean = false, setEmail: (String) -> Unit){

    var email by remember { mutableStateOf("") }
    setEmail(email)

    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp),
        value = email,
        onValueChange = { email = it },
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
        ),

    )
}

@Composable
private fun TermPolicy(){
    Row (
        modifier = Modifier
            .fillMaxWidth(),
    ){
        Text(
            text = "By continuing you agree to our ",
            fontSize = 18.sp,
            color = Color(0xFF919090),
        )
        Text(
            text = " Terms of Service",
            fontSize = 18.sp,
            color = Color(0xFF53B175),
            modifier = Modifier
                .clickable{
                }
        )
    }

    Spacer(modifier = Modifier.height(10.dp))

    Row (
        modifier = Modifier
            .fillMaxWidth(),
    ){
        Text(
            text = "and ",
            fontSize = 18.sp,
            color = Color(0xFF919090),
        )
        Text(
            text = " Privacy Policy",
            fontSize = 18.sp,
            color = Color(0xFF53B175),
            modifier = Modifier
                .clickable{
                }
        )
    }
}

@Composable
private fun SignupButton(username: String ?= null, email: String, password: String, context: Context, setValidationState:(Boolean)-> Unit,
                        navigate: (String?, String, String, Context) -> Unit){

    var validationState by remember { mutableStateOf(true) }
    setValidationState(validationState)

    Button(
        onClick = {
            navigate(username, email, password, context)
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
            text = "Log in",
            fontSize = 23.sp,
            fontWeight = FontWeight.ExtraBold
        )
    }
}

val validationSignUp : (String?, String, String, Context) -> Unit = {
    username, email, password, context ->

}