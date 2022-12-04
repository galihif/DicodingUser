package com.giftech.dicodinguser.ui.screens.detail

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.giftech.dicodinguser.di.Injection
import com.giftech.dicodinguser.model.User
import com.giftech.dicodinguser.ui.ViewModelFactory
import com.giftech.dicodinguser.ui.common.UiState
import com.giftech.dicodinguser.ui.screens.home.HomeViewModel
import com.giftech.dicodinguser.ui.theme.DicodingUserTheme

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun DetailScreen(
    userId:Int=0,
    onBack:()->Unit,
    viewModel: DetailViewModel = viewModel(
        factory = ViewModelFactory(Injection.provideRepository())
    ),
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("User Detail")
                },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(imageVector = Icons.Filled.ArrowBack, contentDescription ="")
                    }
                }
            )
        }
    ){
        viewModel.uiState.collectAsState(initial = UiState.Loading).value.let {
            when(it){
                is UiState.Error -> {}
                UiState.Loading -> viewModel.getUserById(userId)
                is UiState.Success -> {
                    DetailContent(user = it.data)
                }
            }
        }
    }
}

@Composable
fun DetailContent(
    user: User
) {
    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.Top
    ) {
        AsyncImage(
            model = user.imageUrl,
            contentDescription = null,
            modifier = Modifier.size(64.dp)
        )
        Text(
            text = user.name,
            style = MaterialTheme.typography.h6
        )
        Text(
            text = user.university,
            style = MaterialTheme.typography.body2
        )
        Text(
            text = "${user.numCertificationsCompleted} certifications",
            style = MaterialTheme.typography.body2
        )
    }
}



