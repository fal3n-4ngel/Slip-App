package com.example.slipapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
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
import com.example.slipapp.ui.theme.SlipAppTheme


@Composable
fun InputYourPassword() {
    var password by remember { mutableStateOf("") }
    var passwordVisible by rememberSaveable { mutableStateOf(false) }
    OutlinedTextField(
        value = password,
        onValueChange = { password = it },
        singleLine = true,
        shape = RoundedCornerShape(12.dp),
        leadingIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon( imageVector = Icons.Filled.Lock, contentDescription = null, tint = MaterialTheme.colors.surface )
            }
        },
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            val image = if (passwordVisible)
                R.drawable.ic_baseline_visibility_24
            else R.drawable.ic_baseline_visibility_off_24
            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                Icon( painter = painterResource(id = image) , contentDescription = null, tint = MaterialTheme.colors.surface)
            }
        },
        label = {
            Text(
                text = stringResource(R.string.mbcet_password),
                fontSize = 12.sp,
                color = MaterialTheme.colors.surface,
            )
        },
        placeholder = { Text(text = stringResource(R.string.minimum_6_characters), color = MaterialTheme.colors.surface, fontSize = 12.sp) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = MaterialTheme.colors.primary,
            unfocusedBorderColor = MaterialTheme.colors.onBackground,
        ),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Next
        ),
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun ConfirmYourPassword() {
    var confirmPassword by remember { mutableStateOf("") }
    var passwordVisible by rememberSaveable { mutableStateOf(false) }
    OutlinedTextField(
        value = confirmPassword,
        onValueChange = { confirmPassword = it },
        singleLine = true,
        shape = RoundedCornerShape(12.dp),
        leadingIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon( imageVector = Icons.Filled.Lock, contentDescription = null, tint = MaterialTheme.colors.surface )
            }
        },
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            val image = if (passwordVisible)
                R.drawable.ic_baseline_visibility_24
            else R.drawable.ic_baseline_visibility_off_24
            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                Icon( painter = painterResource(id = image) , contentDescription = null, tint = MaterialTheme.colors.surface)
            }
        },
        label = {
            Text(
                text = stringResource(R.string.confirm_password),
                fontSize = 12.sp,
                color = MaterialTheme.colors.surface,
            )
        },
        placeholder = { Text(text = stringResource(R.string.reenter_password), color = MaterialTheme.colors.surface, fontSize = 12.sp) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = MaterialTheme.colors.primary,
            unfocusedBorderColor = MaterialTheme.colors.onBackground,
        ),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(
            onDone = { /*TODO - functionality of done button*/ }
        ),
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun DoneButton() {
    Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
        Button(
            onClick = { /*TODO*/ },
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(MaterialTheme.colors.surface)
        ) {
            Text(
                text = stringResource(R.string.done),
                fontSize = 24.sp,
                color = MaterialTheme.colors.onSurface
            )
        }
    }
}


@Composable
fun SignUpPage3() {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colors.surface), contentAlignment = Alignment.BottomCenter) {
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
                Text(text = stringResource(id = R.string.set_new_password), fontWeight = FontWeight.Black, fontSize = 24.sp)

                Spacer(modifier = Modifier.height(16.dp))
                InputYourPassword()

                Spacer(modifier = Modifier.height(32.dp))
                ConfirmYourPassword()

                Spacer(modifier = Modifier.height(96.dp))
                DoneButton()
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun DefaultPreviewSignUp3() {
    SlipAppTheme {
        SignUpPage3()
    }
}