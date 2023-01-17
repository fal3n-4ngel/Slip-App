package com.example.slipapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.slipapp.ui.theme.SlipAppTheme

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PermissionCard(
    perm: Permission,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(16.dp), backgroundColor = MaterialTheme.colors.primary,
        elevation = 4.dp
    ) {
        Column(
            modifier = Modifier.width(320.dp)
        ) {
            Row(
                modifier = Modifier
                    .wrapContentWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = perm.date, style = MaterialTheme.typography.caption, fontSize = 12.sp
                )
                Spacer(modifier = Modifier.weight(1f))
                Chip(
                    onClick = { },
                    shape = RoundedCornerShape(4.dp),
                ) {
                    Text(
                        text = perm.permissionStatus.toString().lowercase()
                            .replaceFirstChar { it.uppercase() }, fontSize = 12.sp,
                        style = MaterialTheme.typography.caption
                    )
                }

            }

            Row(
                Modifier
                    .padding(16.dp)
                    .fillMaxWidth(0.6f)
            ) {

                Text(
                    text = perm.content
                )
            }



            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colors.background)
                    .padding(16.dp), verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier.weight(0.5f)
                ) {
                    Text(
                        text = "Granted by: ",
                        style = MaterialTheme.typography.caption,
                        fontSize = 12.sp
                    )
                    Text(
                        text = perm.grantedBy,
                        style = MaterialTheme.typography.body2,
                    )

                }
                Column(
                    modifier = Modifier.weight(0.5f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    TextButton(
                        onClick = { println("Text-button clicked") },
                        modifier = Modifier.width(128.dp),
                        colors = ButtonDefaults.textButtonColors(
                            backgroundColor = MaterialTheme.colors.primary
                        ),
                        shape = RoundedCornerShape(8.dp),
                    ) {
                        Text(
                            text = "Learn More",
                            color = MaterialTheme.colors.onPrimary
                        )
                    }
                }
            }
        }
    }
}


@Preview
@Composable
private fun CardPreview1() {
    SlipAppTheme {
        PermissionCard(
            perm = Permission(
                "Permission to leave early",
                "Dr. Tom Riddle",
                "15 Nov 2022",
                PermissionStatus.ACCEPTED
            )
        )
    }
}

@Preview
@Composable
private fun CardPreview2() {
    SlipAppTheme {
        PermissionCard(
            perm = Permission(
                "Hosting freshers day for juniors",
                "--",
                "18 Nov 2022",
                PermissionStatus.UNDER_REVIEW
            )
        )
    }
}