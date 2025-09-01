package com.example.a10__thun_mengse_pvh_oop_practice003.screen.login

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.a10__thun_mengse_pvh_oop_practice003.component.NectarPassField
import com.example.a10__thun_mengse_pvh_oop_practice003.component.NectarTextField
import com.example.a10__thun_mengse_pvh_oop_practice003.component.Signup
import com.example.a10__thun_mengse_pvh_oop_practice003.component.TopSection
import com.example.a10__thun_mengse_pvh_oop_practice003.ui.HomeActivity.HomeActivity
import com.example.a10__thun_mengse_pvh_oop_practice003.ui.SignupActivity.SignUpActivity

@Composable
fun LoginScreen(navController: NavController){
    Column (
        modifier = Modifier
            .systemBarsPadding()
            .padding(25.dp)
    ){

        val title = "Loging"
        val description1 = "Enter your emails and password"

        TopSection(title, description1)

        Spacer(modifier = Modifier.height(35.dp))

        // form section

        var email by remember { mutableStateOf("") }

        NectarTextField(
            label = "Email1",
        ) { e -> email = e}

        Spacer(modifier = Modifier.height(35.dp))

        var password by remember { mutableStateOf("") }

        NectarPassField("Password") { p -> password = p}

        var validationState by remember { mutableStateOf(true) }

        // provide context of current screen use for navigation
        val context = LocalContext.current

        Alert(validationState)

        ForgotPassword()

        Spacer(modifier = Modifier.height(30.dp))

        LoginButton(email, password, context) { v -> validationState = v }

        Spacer(modifier = Modifier.height(30.dp))

        val description2 = "Don't have an account?"
        val description3 = "SignUp"

        Signup(description2, description3, context, SignUpActivity())
    }
}


// alert section
@Composable
private fun Alert(validationState: Boolean){
    if (!validationState){

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Invalid Email or Password",
            fontSize = 17.sp,
            color = Color.Red
        )
    }
}

// forgot password section
@Composable
private fun ForgotPassword(){
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp),
        horizontalArrangement = Arrangement.End
    ){
        Text(
            text = "Forgot Password?",
            fontSize = 16.sp,
            modifier = Modifier
                .clickable{

                }
        )
    }
}

//login section
@Composable
private fun LoginButton(
    email: String,
    password: String,
    context: Context,
    setValidationState:(Boolean)-> Unit){

    var validationState by remember { mutableStateOf(true) }
    setValidationState(validationState)

    Button(
        onClick = {
            validation(email, password, context){
                    it -> validationState = it
            }
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

// validation
private val validation : (String, String, Context, (Boolean) -> Unit) -> Unit = {
        email, password , context, validateState->
    if (email == "chanelle@gmail.com" && password == "Chanelle123@"){
        val intent = Intent(context, HomeActivity::class.java)
        context.startActivity(intent)
//        validateState(true)
    } else {
        validateState(false)
    }
}