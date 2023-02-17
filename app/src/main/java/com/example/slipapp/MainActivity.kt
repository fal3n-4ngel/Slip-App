package com.example.slipapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.slipapp.screens.CreateSlipLayout
import com.example.slipapp.screens.CreateSlipLightPreview
import com.example.slipapp.screens.Home
import com.example.slipapp.screens.IdCard
import com.example.slipapp.ui.theme.SlipAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SlipAppTheme {
                Surface(
                    modifier = Modifier
                        .background(color = Color(0xFFFFFFFF))

                ) {
                    CreateSlipLayout()
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SlipAppTheme {

    }
}