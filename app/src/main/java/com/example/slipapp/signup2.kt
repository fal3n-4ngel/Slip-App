package com.example.slipapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.slipapp.ui.theme.Poppins
import com.example.slipapp.ui.theme.SlipAppTheme


@Composable
fun ResendCodePrompt() {
    Row(modifier = Modifier.fillMaxWidth()) {
        Text(text = stringResource(R.string.receive_code_yet_question), fontSize = 12.sp, fontFamily = Poppins)
        Spacer(modifier = Modifier.width(2.dp))
        Text(text = stringResource(R.string.resend_code), fontSize = 12.sp, fontFamily = Poppins, fontWeight = FontWeight.Black, modifier = Modifier.clickable(onClick = {/*TODO*/}))
    }
}

@Composable
fun InputCode() {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
        val outlinedTextFieldWidth = 48.dp
        val outlinedTextFieldHeight = 56.dp
        var codeDigit1 by remember { mutableStateOf("") }
        var codeDigit2 by remember { mutableStateOf("") }
        var codeDigit3 by remember { mutableStateOf("") }
        var codeDigit4 by remember { mutableStateOf("") }
        var codeDigit5 by remember { mutableStateOf("") }

        Column() {
            OutlinedTextField(
                value = codeDigit1,
                onValueChange = { codeDigit1 = it },
                singleLine = true,
                shape = RoundedCornerShape(12.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = MaterialTheme.colors.primary,
                    unfocusedBorderColor = MaterialTheme.colors.onBackground,
                ),

                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next
                ),
                modifier = Modifier.size(outlinedTextFieldWidth, outlinedTextFieldHeight)
            )
        }
        Column() {
            OutlinedTextField(
                value = codeDigit2,
                onValueChange = { codeDigit2 = it },
                singleLine = true,
                shape = RoundedCornerShape(12.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = MaterialTheme.colors.primary,
                    unfocusedBorderColor = MaterialTheme.colors.onBackground,
                ),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next
                ),
                modifier = Modifier.size(outlinedTextFieldWidth, outlinedTextFieldHeight)
            )
        }
        Column() {
            OutlinedTextField(
                value = codeDigit3,
                onValueChange = { codeDigit3 = it },
                singleLine = true,
                shape = RoundedCornerShape(12.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = MaterialTheme.colors.primary,
                    unfocusedBorderColor = MaterialTheme.colors.onBackground,
                ),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next
                ),
                modifier = Modifier.size(outlinedTextFieldWidth, outlinedTextFieldHeight)
            )
        }
        Column() {
            OutlinedTextField(
                value = codeDigit4,
                onValueChange = { codeDigit4 = it },
                singleLine = true,
                shape = RoundedCornerShape(12.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = MaterialTheme.colors.primary,
                    unfocusedBorderColor = MaterialTheme.colors.onBackground,
                ),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next
                ),
                modifier = Modifier.size(outlinedTextFieldWidth, outlinedTextFieldHeight)
            )
        }
        Column() {
            OutlinedTextField(
                value = codeDigit5,
                onValueChange = { codeDigit5 = it },
                singleLine = true,
                shape = RoundedCornerShape(12.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = MaterialTheme.colors.primary,
                    unfocusedBorderColor = MaterialTheme.colors.onBackground,
                ),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(
                    onDone = { /*TODO - does whatever pressing verified button does */ }
                ),
                modifier = Modifier.size(outlinedTextFieldWidth, outlinedTextFieldHeight)
            )
        }
    }
}

@Composable
fun VerifiedButton() {
    Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
        Button(
            onClick = { /*TODO*/ },
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(MaterialTheme.colors.surface)
        ) {
            Text(
                text = stringResource(R.string.verified),
                fontSize = 24.sp,
                fontFamily = Poppins,
                color = MaterialTheme.colors.onSurface
            )
        }
    }
}


@Composable
fun SignUpPage2() {
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
                Text(text = stringResource(R.string.verification), style = MaterialTheme.typography.h1)

                Spacer(modifier = Modifier.height(16.dp))
                Text(text = stringResource(id = R.string.enter_verification_code), fontSize = 12.sp, style = MaterialTheme.typography.body1)

                Spacer(modifier = Modifier.height(16.dp))
                InputCode()

                Spacer(modifier = Modifier.height(8.dp))
                ResendCodePrompt()

                Spacer(modifier = Modifier.height(32.dp))
                VerifiedButton()
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun DefaultPreviewSignUp2() {
    SlipAppTheme {
        SignUpPage2()
    }
}