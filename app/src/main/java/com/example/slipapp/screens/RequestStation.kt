package com.example.slipapp.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.slipapp.R
import com.example.slipapp.slips.Slip
import com.example.slipapp.slips.slips

@Composable
fun RequestStation () {
    Column(){
        Box(
            modifier = Modifier
                .background(color = Color(7, 48, 66))
                .fillMaxWidth()
                .height(200.dp)
        );
        Box(
            modifier = Modifier.background(Color.White).fillMaxSize()
        );
    }
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier.padding(30.dp)
        ) {
            Text("Request Station", fontSize = 27.sp, color = Color.White)
            Spacer(modifier = Modifier.width(25.dp))
            Image(
                painter = painterResource(id = R.drawable.request_station),
                contentDescription = "Request station logo",
                modifier = Modifier.size(62.17.dp, 90.dp)
            )
        }
        Column(verticalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxHeight()) {
            StationBody()
            Image(
                painter = painterResource(id = R.drawable.new_request_rs),
                contentDescription = "New Request",
                modifier = Modifier.align(Alignment.End).size(100.dp, 100.dp).padding(20.dp).clickable {  },
            )
        }
    }
}

@Composable
fun StationBody () {
    var selection by remember { mutableStateOf(0) }
    var f by remember {
        mutableStateOf(0)
    }
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.background(Color.Transparent)
            ) {

        Card(backgroundColor = Color.White,
            shape = RoundedCornerShape(8.dp),
            elevation = 10.dp,
            modifier = Modifier,
        ) {
            Row(modifier = Modifier
                .padding(2.dp, 1.dp),
            horizontalArrangement = Arrangement.SpaceEvenly) {
                Button(
                    onClick = {
                        selection = 0
                        f = 0
                    },
                    modifier = Modifier,
                    elevation = ButtonDefaults.elevation(0.dp),
                    shape = RoundedCornerShape(8.dp),
                    colors = if(selection==0){
                        ButtonDefaults.buttonColors(
                            backgroundColor =  Color(7, 48, 66),
                            contentColor = Color.White
                    )}
                    else{
                        ButtonDefaults.buttonColors(
                            backgroundColor = Color.White,
                            contentColor = Color.Black
                        )}
                ) {
                    Text("Approved",
                        modifier = Modifier.padding(4.dp))
                }
                Button(
                    onClick = {
                        selection = 1
                        f = 0
                    },
                    modifier = Modifier,
                    elevation = ButtonDefaults.elevation(0.dp),
                    shape = RoundedCornerShape(8.dp),
                    colors = if(selection==1){
                        ButtonDefaults.buttonColors(
                            backgroundColor = Color(7, 48, 66),
                            contentColor = Color.White
                        )}
                    else{
                        ButtonDefaults.buttonColors(
                            backgroundColor = Color.White,
                            contentColor = Color.Black
                        )}
                ) {
                    Text(stringResource(id = R.string.slip_status),
                    modifier = Modifier.padding(4.dp))
                }
                Button(
                    onClick = {
                        selection = 2
                        f = 0
                    },
                    modifier = Modifier,
                    elevation = ButtonDefaults.elevation(0.dp),
                    shape = RoundedCornerShape(8.dp),
                    colors = if(selection==2){
                        ButtonDefaults.buttonColors(
                            backgroundColor = Color(7, 48, 66),
                            contentColor = Color.White
                        )}
                    else{
                        ButtonDefaults.buttonColors(
                            backgroundColor = Color.White,
                            contentColor = Color.Black
                        )}
                ) {
                    Text(stringResource(id = R.string.slip_status_rejected),
                        modifier = Modifier.padding(4.dp))
                }
            }
        }
        Spacer(Modifier.height(20.dp))

        LazyVerticalGrid(columns = GridCells.Fixed(1), verticalArrangement = Arrangement.spacedBy(20.dp), horizontalArrangement = Arrangement.Center) {
            items(slips) {
                if (it.statusValue == selection) {
                    SlipCard(it)
                    f = 1
                }
            }
        }
        if (f == 0) {
            Text("Nothing to show here yet !", color = Color.Black)
        }
    }
}

@Composable
fun SlipCard(slip: Slip) {
    Card(shape = RoundedCornerShape(16.dp),
    modifier = Modifier
        .padding(8.dp)
        .background(Color.White)
        .shadow(2.dp)){
        Column() {
            Card(Modifier.background(Color(7, 48, 66)).padding(6.dp)) {
                Column() {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(stringResource(id = slip.date), fontSize = 8.sp, modifier = Modifier.padding(10.dp, 14.dp))
                        Card(
                            backgroundColor = Color(217, 217, 217, 54),
                            modifier = Modifier.padding(8.dp,13.dp)
                        ) {
                            Row(horizontalArrangement = Arrangement.SpaceEvenly, verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(2.dp,1.dp)) {
                                Canvas(modifier = Modifier.size(6.dp), onDraw = {
                                    drawCircle(
                                        color = when (slip.statusValue) {
                                            0 -> Color.Green
                                            1 -> Color.Yellow
                                            else -> {
                                                Color.Red
                                            }
                                        }
                                    )
                                })
                                Spacer(Modifier.width(2.dp))
                                Text(stringResource(id = slip.status), fontSize = 8.sp)
                            }
                        }
                    }
                    Text(stringResource(id = slip.title), modifier = Modifier
                        .padding(10.dp, 9.dp)
                        .fillMaxWidth(0.7f), fontSize = 16.sp, fontWeight = FontWeight.Bold)
                }
            }
            Card(modifier = Modifier
                .background(Color.White)
                .fillMaxWidth()) {
                Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
                    .background(Color.White)
                    .padding(14.dp, 9.dp,10.dp,9.dp), verticalAlignment = Alignment.CenterVertically) {
                    Column() {
                        Text("Granted By:", color = Color.Gray, fontSize = 10.sp)
                        Text(stringResource(id = slip.grantedBy), color=Color.Black, fontSize = 10.sp)
                    }
                    Button(onClick = {}, shape = RoundedCornerShape(8.dp)) {
                        Text("Learn More", fontSize = 10.sp, modifier = Modifier.padding(2.dp, 1.dp))
                    }
                }
            }
        }
    }
}