package com.example.a10__thun_mengse_pvh_oop_practice003.ui.Activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
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
import com.example.a10__thun_mengse_pvh_oop_practice003.ui.component.NectarPassField
import com.example.a10__thun_mengse_pvh_oop_practice003.ui.component.NectarTextField
import com.example.a10__thun_mengse_pvh_oop_practice003.ui.component.Signup
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
        val description1 = "Enter your credentials to continue"

        TopSection(title, description1)

        Spacer(modifier = Modifier.height(35.dp))

        var username by remember { mutableStateOf("") }

        var isUsernameState: Boolean? by remember { mutableStateOf(null) }
        var isUserIcon = false

        if (isUsernameState == true){
            isUserIcon = true
        }

        NectarTextField  (
            label ="Username",
            isIcon = isUserIcon
        ) { u -> username = u}

        if (isUsernameState == false){
            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Invalid Username",
                fontSize = 17.sp,
                color = Color.Red
            )
        }

        Spacer(modifier = Modifier.height(25.dp))

        var email by remember { mutableStateOf("") }

        var isEmailState: Boolean? by remember { mutableStateOf(null) }
        var isEmailIcon = false

        if (isEmailState == true){
            isEmailIcon = true
        }

        NectarTextField (
            label = "Email",
            isIcon = isEmailIcon
        ) { e -> email = e }

        if (isEmailState == false){
            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Invalid Email",
                fontSize = 17.sp,
                color = Color.Red
            )
        }

        Spacer(modifier = Modifier.height(25.dp))

        var password by remember { mutableStateOf("") }

        var isPasswordState: Boolean by remember { mutableStateOf(true) }

        NectarPassField("Password") { p -> password = p}

        if (!isPasswordState){
            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "password: must be 8+ characters with uppercase, lowercase, number, and symbol",
                fontSize = 17.sp,
                color = Color.Red
            )
        }

        // provide context of current screen use for navigation
        val context = LocalContext.current

        Spacer(modifier = Modifier.height(20.dp))

        TermPolicy()

        Spacer(modifier = Modifier.height(30.dp))

        SignupButton(
            label = "Sign Upl",
            username = username,
            email = email,
            password = password,
            context = context,
            setValidationState = { x,y, z ->
                    isUsernameState = x
                    isEmailState = y
                    isPasswordState = z

            }
        ){
            username,email,password , context , setValidationState->
            validationSignUp(username, email, password, context, setValidationState)
        }

        Spacer(modifier = Modifier.height(30.dp))

        val description2 = "Already have an account?"
        val description3 = "SignIn"

        Signup(description2, description3, context, LoginActivity())
    }
}

@Composable
private fun TermPolicy(){
    Row (
        modifier = Modifier
            .fillMaxWidth(),
    ){
        Text(
            text = "By continuing you agree to our ",
            fontSize = 16.sp,
            color = Color(0xFF919090),
        )
        Text(
            text = " Terms of Service",
            fontSize = 16.sp,
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
            fontSize = 16.sp,
            color = Color(0xFF919090),
        )
        Text(
            text = " Privacy Policy",
            fontSize = 16.sp,
            color = Color(0xFF53B175),
            modifier = Modifier
                .clickable{
                }
        )
    }
}

@Composable
fun SignupButton(
    label: String,
    username: String,
    email: String,
    password: String,
    context: Context,
    setValidationState: (Boolean, Boolean, Boolean) -> Unit,
    navigate: (String, String, String, Context, (Boolean, Boolean, Boolean) -> Unit) -> Unit
){

    var isUsername by remember { mutableStateOf(true) }
    var isEmail by remember { mutableStateOf(true) }
    var isPassword by remember { mutableStateOf(true) }

    setValidationState(isUsername, isEmail, isPassword)

    Button(
        onClick = {
            navigate(username, email, password, context){
                x ,y,z -> setValidationState(x,y,z)
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
            text = label,
            fontSize = 23.sp,
            fontWeight = FontWeight.ExtraBold
        )
    }
}


val validationSignUp : (String, String, String, Context, (Boolean, Boolean, Boolean) -> Unit) -> Unit = {
    username, email, password, context , isValidateState   ->
    if (isValidUsername(username) && isValidEmail(email) && isValidPassword(password)){
        val intent = Intent(context, LoginActivity::class.java)
        context.startActivity(intent)
        isValidateState(true, true, true)
    }else {
        isValidateState(isValidUsername(username), isValidEmail(email), isValidPassword(password))
    }
}

val usernameRegex = Regex("^[A-Za-z][A-Za-z0-9_]{4,15}$")
val emailRegex = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")
val passwordRegex = Regex("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@\$!%*?&])[A-Za-z\\d@\$!%*?&]{8,}$")

fun isValidUsername(u: String) = usernameRegex.matches(u)
fun isValidEmail(e: String) = emailRegex.matches(e)
fun isValidPassword(p: String) = passwordRegex.matches(p)

