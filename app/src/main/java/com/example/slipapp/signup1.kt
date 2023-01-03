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
import com.example.slipapp.ui.theme.SlipAppTheme


@Composable
fun InputRegistrationID() {
    var username by remember { mutableStateOf("") }
    OutlinedTextField(
        value = username,
        onValueChange = { username = it
            /*onChange*/},
        singleLine = true,
        shape = RoundedCornerShape(12.dp),
        label = {
            Text(
                text = stringResource(R.string.mbcet_reg_id),
                fontSize = 12.sp,
                color = MaterialTheme.colors.surface,
            )
        },
        placeholder = { Text(text= stringResource(R.string.placeholder_mbcet_reg_id), color = MaterialTheme.colors.surface, fontSize = 12.sp,) },
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
fun InputEmailID() {
    var emailID by remember { mutableStateOf("") }
    OutlinedTextField(
        value = emailID,
        onValueChange = { emailID = it
            /*onChange*/},
        singleLine = true,
        shape = RoundedCornerShape(12.dp),
        label = {
            Text(
                text = stringResource(id = R.string.mbcet_email_id),
                fontSize = 12.sp,
                color = MaterialTheme.colors.surface,
            )
        },
        placeholder = { Text(text= stringResource(R.string.placeholder_mbcet_email_id), color = MaterialTheme.colors.surface, fontSize = 12.sp,) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = MaterialTheme.colors.primary,
            unfocusedBorderColor = MaterialTheme.colors.onBackground
        ),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Next
        ),
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun InputFullName() {
    var fullName by remember { mutableStateOf("") }
    OutlinedTextField(
        value = fullName,
        onValueChange = { fullName = it
            /*onChange*/},
        singleLine = true,
        shape = RoundedCornerShape(12.dp),
        label = {
            Text(
                text = stringResource(id = R.string.full_name),
                fontSize = 12.sp,
                color = MaterialTheme.colors.surface,
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
fun InputMobileNumber() {
    var mobileNumber by remember { mutableStateOf("") }
    OutlinedTextField(
        value = mobileNumber,
        onValueChange = { mobileNumber = it
            /*onChange*/},
        singleLine = true,
        shape = RoundedCornerShape(12.dp),
        label = {
            Text(
                text = stringResource(id = R.string.mobile_number),
                fontSize = 12.sp,
                color = MaterialTheme.colors.surface,
            )
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = MaterialTheme.colors.primary,
            unfocusedBorderColor = MaterialTheme.colors.onBackground
        ),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number,
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(
            onDone = { /*TODO - does whatever pressing proceed button does*/ }
        ),
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun ProceedButton() {
    Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
        Button(
            onClick = { /*TODO*/ },
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(MaterialTheme.colors.surface)
        ) {
            Text(
                text = stringResource(id = R.string.proceed),
                fontSize = 24.sp,
                color = MaterialTheme.colors.onSurface
            )
        }
    }
}

@Composable
fun AccountAlreadyPresentPrompt() {
    Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
        Text(text = stringResource(R.string.already_has_account_question), fontSize = 12.sp)
        Spacer(modifier = Modifier.width(2.dp))
        Text(text = stringResource(R.string.log_in), fontSize = 12.sp, fontWeight = FontWeight.Black, modifier = Modifier.clickable(onClick = {/*TODO*/}))
    }
}


@Composable
fun SignUpPage1() {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colors.surface),
        contentAlignment = Alignment.BottomCenter) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 40.dp),
            contentAlignment = Alignment.TopCenter
        ) {
            Image(
                painter = painterResource(id = R.drawable.flashicon),
                contentDescription = null,
                modifier = Modifier.size(120.dp)
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
                Text(text = stringResource(id = R.string.get_started), fontWeight = FontWeight.Black, fontSize = 24.sp)

                Spacer(modifier = Modifier.height(16.dp))
                InputRegistrationID()

                Spacer(modifier = Modifier.height(16.dp))
                InputEmailID()

                Spacer(modifier = Modifier.height(16.dp))
                InputFullName()

                Spacer(modifier = Modifier.height(16.dp))
                InputMobileNumber()

                Spacer(modifier = Modifier.height(32.dp))
                ProceedButton()

                Spacer(modifier = Modifier.height(8.dp))
                AccountAlreadyPresentPrompt()
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun DefaultPreviewSignUp1() {
    SlipAppTheme {
        SignUpPage1()
    }
}