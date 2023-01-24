package com.app.businesscardapp

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.businesscardapp.ui.theme.BusinessCardAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ShowContentWithImageAndText()
                }
            }
        }
    }
}

@Composable
fun ShowContentWithImageAndText() {
    Column(
        modifier = Modifier
            .background(Color(R.color.background))
    ) {
        IdentificationInformation(
            image = painterResource(id = R.drawable.android_logo),
            name = stringResource(R.string.developer_name),
            role = stringResource(R.string.android_developer)
        )
        ContactInformation(
            phone = stringResource(R.string.phone),
            email = stringResource(R.string.email)
        )
    }
}

@Composable
fun IdentificationInformation(
    image: Painter,
    name: String,
    role: String,
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = image,
            contentDescription = null,
            Modifier.size(150.dp),
        )
        Text(
            text = name,
            color = Color.White,
            fontSize = 26.sp,
            modifier = Modifier.padding(8.dp)
        )
        Text(
            text = role,
            color = Color(0xFF3ddc84),
            fontSize = 18.sp
        )
    }
}

@Composable
fun ContactInformation(
    phone: String,
    email: String
) {
    Column(
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = phone,
            color = Color.White,
            fontSize = 20.sp,
            modifier = Modifier.padding(8.dp)
        )
        Text(
            text = email,
            color = Color.White,
            fontSize = 20.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BusinessCardAppTheme {
        ShowContentWithImageAndText()
    }
}