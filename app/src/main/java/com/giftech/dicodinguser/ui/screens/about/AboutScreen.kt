package com.giftech.dicodinguser.ui.screens.about

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AboutScreen(
    onBack:()->Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("About Me") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(imageVector = Icons.Filled.ArrowBack, contentDescription ="")
                    }
                }
            )
        },
    ) {
        Column(Modifier.padding(16.dp)) {
            AsyncImage(
                model = "https://avatars.githubusercontent.com/u/61546756?s=400&u=1f3efc7594d42a92ffd8f12b60fe03f937c51ca6&v=4",
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(64.dp).clip(CircleShape),
            )
            Spacer(Modifier.height(16.dp))
            Text(
                text = "Galih Indra Firmansyah",
                style = TextStyle(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "galihindra2401@mail.ugm.ac.id",
                style = TextStyle(fontSize = 18.sp)
            )
        }
    }
}