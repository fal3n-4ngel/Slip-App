package com.example.slipapp.screens
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.animation.core.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.slipapp.R
import androidx.compose.ui.Modifier
import android.content.res.Configuration
import androidx.compose.ui.Alignment
import com.example.slipapp.SlipViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.slipapp.data.SlipData
import com.example.slipapp.data.slips


import java.text.SimpleDateFormat
import java.util.*

@Preview(showSystemUi = true)
@Composable
fun CreateSlipLightPreview() {

        CreateSlipLayout()

}

@Preview(showSystemUi = true)
@Composable
fun CreateSlipDarkPreview() {

        CreateSlipLayout()

}

@Composable
fun CreateSlipLayout(model: SlipViewModel = viewModel()) {
    val scroll = rememberScrollState(0)
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background),
        contentAlignment = Alignment.TopCenter,
    ) {
        Card(

            contentColor = MaterialTheme.colors.onBackground,
            backgroundColor = MaterialTheme.colors.secondary,
            modifier = Modifier

                .padding(all = 20.dp)


        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(40.dp))
                    .padding(horizontal = 20.dp)
                    .verticalScroll(scroll, reverseScrolling = true)
            ) {
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    TypeSelectorDropdown(model)
                    val sdf = SimpleDateFormat("dd/MM/yyyy")
                    val currentDateAndTime = sdf.format(Date())
                    Box(
                        contentAlignment = Alignment.Center,
                    ) {
                        Text(
                            text = currentDateAndTime,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                        )
                    }
                }
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = stringResource(R.string.FillUpSlipDetails),
                    fontWeight = FontWeight.Bold,
                    color = Color.Gray
                )
                Spacer(modifier = Modifier.height(10.dp))
                Divider(
                    thickness = 2.dp,
                )
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = stringResource(R.string.Name),
                    fontWeight = FontWeight.Bold,
                    color = Color.Gray
                )
                Text(
                    text = stringResource(id = R.string.name),
                    fontWeight = FontWeight.Bold,
                )
                Spacer(modifier = Modifier.height(20.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(Modifier.weight(1f)) {
                        Text(
                            text = stringResource(R.string.RegNo),
                            fontWeight = FontWeight.Bold,
                            color = Color.Gray
                        )
                        Text(
                            text = stringResource(id = R.string.id),
                            fontWeight = FontWeight.Bold,
                        )
                    }
                    Box(
                        Modifier.weight(2f),
                        contentAlignment = Alignment.Center
                    ) {
                        Column {
                            Text(
                                text = stringResource(R.string.AdmnNo),
                                fontWeight = FontWeight.Bold,
                                color = Color.Gray
                            )
                            Text(
                                text = stringResource(id = R.string.adnod1),
                                fontWeight = FontWeight.Bold,
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(Modifier.weight(1f)) {
                        Text(
                            text = stringResource(R.string.ClassTitle),
                            fontWeight = FontWeight.Bold,
                            color = Color.Gray
                        )
                        Text(
                            text = stringResource(R.string.CS1),
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Box(
                        Modifier.weight(2f),
                        contentAlignment = Alignment.Center
                    ) {
                        Column {
                            Text(
                                text = stringResource(R.string.SemesterTitle),
                                fontWeight = FontWeight.Bold,
                                color = Color.Gray
                            )
                            Text(
                                text = stringResource(R.string.semester),
                                fontWeight = FontWeight.Bold,
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))
                val pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f)
                val bg = MaterialTheme.colors.onPrimary
                val bg2 = MaterialTheme.colors.onPrimary

                Canvas(
                    Modifier
                        .fillMaxWidth()
                        .height(10.dp)
                ) {
                    drawCircle(bg, 100f, center = Offset(-100f, 0f))
                    drawCircle(bg, 100f, center = Offset(size.width + 100f, 0f))
                    drawLine(
                        color = bg2,
                        strokeWidth = 10f,
                        start = Offset(0f, 0f),
                        end = Offset(size.width, 10f),
                        pathEffect = pathEffect
                    )
                }
                Spacer(modifier = Modifier.height(20.dp))
                InputFields(model)
                Spacer(modifier = Modifier.height(0.dp))
                Text(
                    text = stringResource(R.string.CreateSlipFooter),
                    textAlign = TextAlign.Center,
                    color = Color.Gray,
                    fontSize = 12.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp)
                )
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }
}

//Components
@Composable
fun AppTextField(
    modifier: Modifier = Modifier,
    text: String,
    placeholder: String,
    leadingIcon: @Composable (() -> Unit)? = null,
    onChange: (String) -> Unit = {},
    imeAction: ImeAction = ImeAction.Next,
    keyboardType: KeyboardType = KeyboardType.Text,
    keyBoardActions: KeyboardActions = KeyboardActions(),
    isEnabled: Boolean = true
) {
    OutlinedTextField(
        modifier = modifier.fillMaxWidth(),
        value = text,
        onValueChange = onChange,
        leadingIcon = leadingIcon,
        textStyle = TextStyle(fontSize = 18.sp, color = MaterialTheme.colors.primary),
        keyboardOptions = KeyboardOptions(imeAction = imeAction, keyboardType = keyboardType),
        keyboardActions = keyBoardActions,
        enabled = isEnabled,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = Color.Gray,
            focusedBorderColor = MaterialTheme.colors.primary,
            disabledBorderColor = Color.Gray,
            disabledTextColor = Color.Black
        ),
        placeholder = {
            Text(text = placeholder, style = TextStyle(fontSize = 18.sp, color = Color.Gray))
        }
    )
}


@Composable
fun TypeSelectorDropdown(viewModel: SlipViewModel) {
    var expanded by remember { mutableStateOf(false) }

    Box (modifier=Modifier
        ){
        Button(onClick = { expanded = true }) {
            Text(
                text = stringResource(viewModel.slipType),
            )
            Spacer(Modifier.size(ButtonDefaults.IconSpacing))
            Icon(
                Icons.Default.ArrowDropDown,
                contentDescription = null,
                modifier = Modifier.size(ButtonDefaults.IconSize)

            )
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            DropdownMenuItem(onClick = {
                expanded = false
                viewModel.slipType = R.string.GatePass
            }) {
                Text(stringResource(R.string.GatePass))
            }
            DropdownMenuItem(onClick = {
                expanded = false
                viewModel.slipType = R.string.IDCardDuplicate
            }) {
                Text(stringResource(R.string.IDCardDuplicate))
            }
            DropdownMenuItem(onClick = {
                expanded = false
                viewModel.slipType = R.string.LabAccessRequest
            }) {
                Text(stringResource(R.string.LabAccessRequest))
            }
            DropdownMenuItem(onClick = {
                expanded = false
                viewModel.slipType = R.string.ExtraClassRequest
            }) {
                Text(stringResource(R.string.ExtraClassRequest))
            }
            DropdownMenuItem(onClick = {
                expanded = false
                viewModel.slipType = R.string.ExamGrievances
            }) {
                Text(stringResource(R.string.ExamGrievances))
            }
            DropdownMenuItem(onClick = {
                expanded = false
                viewModel.slipType = R.string.Misc
            }) {
                Text(stringResource(R.string.Misc))
            }
        }
    }
}

@Composable
fun InputFields(
    viewModel: SlipViewModel
) {
    val focusManager = LocalFocusManager.current
    AppTextField(
        text = viewModel.title,
        placeholder = "Title",
        onChange = {
            viewModel.title = it
        },
        imeAction = ImeAction.Next,
        keyboardType = KeyboardType.Text,
        keyBoardActions = KeyboardActions(
            onNext = {
                focusManager.moveFocus(FocusDirection.Down)
            }
        )
    )
    Spacer(modifier = Modifier.height(5.dp))
    AppTextField(
        modifier = Modifier.height(100.dp),
        text = viewModel.description,
        placeholder = "Description",
        onChange = {
            viewModel.description = it
        },
        imeAction = ImeAction.Default,
        keyboardType = KeyboardType.Text,
        keyBoardActions = KeyboardActions(
            onNext = {
                focusManager.moveFocus(FocusDirection.Down)
            }
        )
    )

    Spacer(modifier = Modifier.height(5.dp))
    Text(
        text = stringResource(R.string.SendTo),
        fontWeight = FontWeight.Bold,
        color = Color.Gray
    )
    Row {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = viewModel.sendToHOD,
                onCheckedChange = { viewModel.sendToHOD = it },
                enabled = true,
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.DarkGray,
                    uncheckedColor = Color.DarkGray,
                    checkmarkColor = MaterialTheme.colors.primary
                )
            )
            Text(text = stringResource(R.string.HOD), fontWeight = FontWeight.Bold)
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = viewModel.sendToAdvisors,
                onCheckedChange = { viewModel.sendToAdvisors = it },
                enabled = true,
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.DarkGray,
                    uncheckedColor = Color.DarkGray,
                    checkmarkColor = MaterialTheme.colors.primary
                )
            )
            Text(text = stringResource(R.string.Advisors), fontWeight = FontWeight.Bold)
        }
    }

    Button(
        onClick = {
            val deptHOD = R.string.hod_cs
            val classAdvisors = listOf(R.string.advisor_1, R.string.advisor_2, R.string.advisor_3)

//            if(viewModel.sendToHOD) {
//                var deptHOD = R.string.hod_cs
//            }
//            if(viewModel.sendToAdvisors) {
//                var classAdvisors = listOf(R.string.advisor_1, R.string.advisor_2, R.string.advisor_3)
//            }
            slips.add(
                SlipData(
                    name = R.string.name,
                    slipType = viewModel.slipType,
                    className = R.string.CS1,
                    HoD = deptHOD,
                    advisors = listOf( "Dr. Dumbledore", "Mr. Gandalf"),
                    semester = R.string.semester,
                    rollNo = R.string.id,
                    title = viewModel.title,
                    slipDescribe = viewModel.description
                )
            )
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp)
            .height(40.dp)
    ) {
        Text(
            text = stringResource(R.string.SubmitButtomText),
            fontSize = 20.sp
        )
    }
}