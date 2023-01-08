package com.example.slipapp.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.slipapp.R
import com.example.slipapp.components.CategoryDataSource
import com.example.slipapp.components.PermissionCardDataSource
import com.example.slipapp.components.PermissionsList
import com.example.slipapp.ui.theme.SlipAppTheme

@Composable
fun Home() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
            .verticalScroll(rememberScrollState()),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 32.dp)
        ) {
            Column(
                modifier = Modifier
                    .weight(0.8f)
            ) {
                Text(
                    text = "Hello Rick",
                    style = MaterialTheme.typography.h1
                )
                Text(
                    text = "Let's get things done in a flash",
                    style = MaterialTheme.typography.caption
                )
            }
            Column(
                modifier = Modifier
                    .weight(0.2f)
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box {
                    Image(
                        painter = painterResource(id = R.drawable.baseline_notifications_24),
                        contentDescription = "Notifications",
                        modifier = Modifier
                            .clickable {
                                println("Button Clicked")
                            }
                            .size(36.dp),
                        colorFilter = ColorFilter.tint(MaterialTheme.colors.primary)
                    )
                }
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = MaterialTheme.colors.primary)
                .padding(horizontal = 16.dp, vertical = 32.dp)
        ) {
            Column(
                modifier = Modifier
                    .weight(0.5f)
            ) {
                Text(
                    text = "Need permission for something?",
                    color = MaterialTheme.colors.onPrimary,
                    fontSize = 20.sp
                )
                Text(
                    text = "Let's do it in a flash",
                    color = Color(0x99FFFFFF),
                    fontSize = 12.sp
                )
                Spacer(modifier = Modifier.height(16.dp))
                TextButton(
                    onClick = { println("Text-button clicked") },
                    modifier = Modifier.width(128.dp),
                    colors = ButtonDefaults.textButtonColors(
                        backgroundColor = Color.White
                    ),
                    shape = RoundedCornerShape(8.dp),
                ) {
                    Text("Apply Now")
                }
            }
            Column(
                modifier = Modifier
                    .weight(0.5f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.plane_pic),
                    contentDescription = "Plane",
                    modifier = Modifier.size(128.dp)
                )
            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 32.dp)
        ) {

            Text(
                text = "Request Station",
                style = MaterialTheme.typography.h2
            )

            val perms = PermissionCardDataSource.permissions
            PermissionsList(perms = perms)
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 16.dp)
        ) {
            Text(
                text = "Categories",
                style = MaterialTheme.typography.h2
            )

            val categories = CategoryDataSource.categories
//            CategoryList(categories = categories)
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun HomePreview() {
    SlipAppTheme {
        Home()
    }
}