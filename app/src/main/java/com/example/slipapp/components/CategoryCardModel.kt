package com.example.slipapp.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.slipapp.ui.theme.SlipAppTheme

@Composable
fun CategoryCard(
    category: Category,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(16.dp), backgroundColor = MaterialTheme.colors.background,
        elevation = 4.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp, horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(0.7f)) {
                Text(
                    text = category.content
                )
            }

            Column(modifier = Modifier.weight(0.3f)) {
                TextButton(
                    onClick = { println("Text-button clicked") },
                    modifier = Modifier.width(128.dp),
                    colors = ButtonDefaults.textButtonColors(
                        backgroundColor = MaterialTheme.colors.primary
                    ),
                    shape = RoundedCornerShape(8.dp),
                ) {
                    Text(
                        text = category.buttonText,
                        color = MaterialTheme.colors.onPrimary
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun CardPreview1() {
    SlipAppTheme {
        CategoryCard(
            category = Category(
                "Create Request",
                "Apply"
            ),
        )
    }
}