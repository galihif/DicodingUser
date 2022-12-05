package com.giftech.dicodinguser.ui.screens.home

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.giftech.dicodinguser.di.Injection
import com.giftech.dicodinguser.model.User
import com.giftech.dicodinguser.ui.ViewModelFactory
import com.giftech.dicodinguser.ui.common.UiState
import com.giftech.dicodinguser.ui.theme.DicodingUserTheme

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    onClickItem: (Int) -> Unit,
    onAboutClick: () -> Unit,
    viewModel: HomeViewModel = viewModel(
        factory = ViewModelFactory(Injection.provideRepository())
    ),
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Home")
                },
                actions = {
                    IconButton(onClick = onAboutClick) {
                        Icon(imageVector = Icons.Default.Person, contentDescription = "about_page")
                    }
                }
            )
        }
    ) {
        viewModel.uiState.collectAsState().value.let {
            when(it){
                is UiState.Error -> {}
                UiState.Loading -> viewModel.getAllUser()
                is UiState.Success -> {
                    HomeContent(users = it.data, onClickItem = onClickItem)
                }
            }
        }
    }
}

@Composable
fun HomeContent(
    users: List<User>,
    onClickItem: (Int) -> Unit
) {
    LazyColumn(
        modifier = Modifier,
        contentPadding = PaddingValues(8.dp)
    ) {
        items(users) {
            UserItem(user = it) { id ->
                onClickItem(id)
            }
        }
    }
}

@Composable
fun UserItem(user: User, onClickItem: (Int) -> Unit) {
    Row(
        modifier = Modifier
            .padding(8.dp)
            .clickable { onClickItem(user.id) },
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            modifier = Modifier.width(64.dp).clip(CircleShape),
            model = user.imageUrl,
            contentDescription = null,
            contentScale = ContentScale.Crop,
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = user.name)
            Text(
                text = user.university,
                style = MaterialTheme.typography.body2
            )
        }
    }
}