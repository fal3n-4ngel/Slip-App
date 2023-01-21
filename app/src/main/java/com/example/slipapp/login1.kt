package com.example.slipapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.slipapp.ui.theme.Poppins
import com.example.slipapp.ui.theme.SlipAppTheme
import com.example.slipapp.ui.theme.SonicSilver


@Composable
fun EnterRegID() {
    var username by remember { mutableStateOf("") }
    OutlinedTextField(
        value = username,
        onValueChange = {
            username = it
            /*onChange*/
        },
        singleLine = true,
        leadingIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Filled.Email,
                    contentDescription = null,
                    tint = MaterialTheme.colors.surface
                )
            }
        },
        shape = RoundedCornerShape(12.dp),
        label = {
            Text(
                text = stringResource(R.string.mbcet_reg_id),
                fontSize = 12.sp,
                color = MaterialTheme.colors.surface,
                fontFamily = Poppins
            )
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = MaterialTheme.colors.primary,
            unfocusedBorderColor = MaterialTheme.colors.onBackground
        ),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Next
        ),
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun EnterPassword() {
    var password by remember { mutableStateOf("") }
    var passwordVisible by rememberSaveable { mutableStateOf(false) }
    OutlinedTextField(
        value = password,
        onValueChange = { password = it },
        singleLine = true,
        shape = RoundedCornerShape(12.dp),
        leadingIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Filled.Lock,
                    contentDescription = null,
                    tint = MaterialTheme.colors.surface
                )
            }
        },
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            val image = if (passwordVisible)
                R.drawable.ic_baseline_visibility_24
            else R.drawable.ic_baseline_visibility_off_24
            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                Icon(
                    painter = painterResource(id = image),
                    contentDescription = null,
                    tint = MaterialTheme.colors.surface
                )
            }
        },
        label = {
            Text(
                text = stringResource(R.string.mbcet_password),
                fontSize = 12.sp,
                color = MaterialTheme.colors.surface,
                fontFamily = Poppins
            )
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = MaterialTheme.colors.primary,
            unfocusedBorderColor = MaterialTheme.colors.onBackground,
        ),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(
            onDone = { /*TODO - does whatever pressing login button does*/ }
        ),
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun LoginButton() {
    Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
        Button(
            onClick = { /*TODO*/ },
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(MaterialTheme.colors.surface)
        ) {
            Text(
                text = stringResource(R.string.login_button_text),
                fontSize = 24.sp,
                fontFamily = Poppins,
                color = MaterialTheme.colors.onSurface,
            )
        }
    }
}

@Composable
fun ForgotPasswordPrompt() {
    Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
        Text(
            text = stringResource(R.string.forgot_password_question),
            fontSize = 12.sp,
            fontFamily = Poppins,
            color = SonicSilver
        )
        Spacer(modifier = Modifier.width(2.dp))
        Text(
            text = stringResource(R.string.click_if_forgot_password),
            fontSize = 12.sp,
            fontFamily = Poppins,
            fontWeight = FontWeight.Black,
            modifier = Modifier.clickable(onClick = {/*TODO*/ })
        )
    }
}

@Composable
fun SignUpPrompt() {
    Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
        Text(
            text = stringResource(R.string.has_no_account_question),
            fontFamily = Poppins,
            fontSize = 12.sp,
            color = SonicSilver
        )
        Spacer(modifier = Modifier.width(2.dp))
        Text(
            text = stringResource(R.string.click_to_sign_up),
            fontSize = 12.sp,
            fontFamily = Poppins,
            fontWeight = FontWeight.Black,
            modifier = Modifier.clickable(onClick = {/*TODO*/ })
        )
    }
}


@Composable
fun LoginPage() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.surface),
        contentAlignment = Alignment.BottomCenter
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 100.dp),
            contentAlignment = Alignment.TopCenter
        ) {
            Image(
                painter = painterResource(id = R.drawable.flashicon),
                contentDescription = null,
                modifier = Modifier.size(200.dp)
            )
        }

        Card(
            modifier = Modifier
                .fillMaxWidth(),
            elevation = 10.dp,
            backgroundColor = Color.White,
            shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(32.dp)
            ) {
                Text(
                    text = stringResource(R.string.welcome_back),
                    style = MaterialTheme.typography.h1
                )

                Spacer(modifier = Modifier.height(16.dp))
                EnterRegID()

                Spacer(modifier = Modifier.height(16.dp))
                EnterPassword()

                Spacer(modifier = Modifier.height(8.dp))
                ForgotPasswordPrompt()

                Spacer(modifier = Modifier.height(32.dp))
                LoginButton()

                Spacer(modifier = Modifier.height(8.dp))
                SignUpPrompt()
            }
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun DefaultPreviewLogin1() {
    SlipAppTheme {
        LoginPage()
    }
}