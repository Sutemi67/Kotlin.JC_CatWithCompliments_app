package com.example.kotik

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.floor

@Composable
fun CatMain() {

    var textRandomCount by remember { mutableStateOf(1) }
    var page by remember { mutableStateOf(1) }

    val image = when (page) {
        1 -> R.drawable.kotik1
        else -> R.drawable.kotik2
    }

    fun textChanger() {
        page = if (page == 1) {
            2
        } else {
            1
        }
        textRandomCount = floor(Math.random() * 101).toInt()
    }

    val textYes = if (page == 2) {
        text(textRandomCount)
    } else {
        ""
    }

    Column(
        horizontalAlignment = CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        Text(
            text = textYes,
            fontSize = 25.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            style = androidx.compose.ui.text.TextStyle(
                shadow = Shadow(
                    Color.Magenta,
                    Offset(1f, 5f),
                    50f
                )
            ),
            modifier = Modifier
                .padding(6.dp, 100.dp, 6.dp, 0.dp)
        )
        Image(
            painter = painterResource(id = image),
            contentDescription = "kotik1",
            modifier = Modifier
                .clickable { textChanger() }
                .padding(bottom = 150.dp)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Preview() {
    CatMain()
}