package com.shashank.day11.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.Info
import androidx.compose.material.icons.twotone.Email
import androidx.compose.material.icons.twotone.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import com.shashank.day11.R
import com.shashank.day11.routes.MyAppRoute

@Composable
fun LoginScreen(modifier: Modifier = Modifier, navController: NavController) {
    var email by rememberSaveable { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    Box(modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            //"https://rukminim2.flixcart.com/image/416/416/xif0q/mobile/e/y/n/pixel-8a-ga04432-in-google-original-imahyn3mqzdbzywg.jpeg

            AsyncImage(
                model = "https://rukminim2.flixcart.com/image/416/416/xif0q/mobile/e/y/n/pixel-8a-ga04432-in-google-original-imahyn3mqzdbzywg.jpeg",
                contentDescription = null
            )

            Image(
                painter = painterResource(R.drawable.ic_launcher_foreground),
                contentDescription = null
            )
            CustomTEditText(
                label = "Email",
                text = email,
                onTextChange = { email = it },
                Icons.TwoTone.Email
            )
            Spacer(Modifier.height(15.dp))
            CustomTEditText(
                label = "Password",
                text = password,
                onTextChange = { password = it },
                Icons.Sharp.Info
            )
            Spacer(Modifier.height(15.dp))
            Button({
                navController.navigate(MyAppRoute.HomeScree(email))
            }) {
                Text("Login")
            }

        }
    }
}


@Composable
fun CustomTEditText(
    label: String,
    text: String,
    onTextChange: (String) -> Unit,
    trailingIcon: ImageVector
) {
    TextField(
        modifier = Modifier.fillMaxWidth(),
        value = text,
        onValueChange = { onTextChange(it) },
        label = { Text(label) },
        trailingIcon = {
            Icon(imageVector = trailingIcon, contentDescription = null)
        }
    )
}

//@Preview(showBackground = true)
//@Composable
//fun LoginScreenPreview() {
//    LoginScreen()
//}