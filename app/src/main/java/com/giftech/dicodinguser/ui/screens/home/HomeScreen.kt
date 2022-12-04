package com.giftech.dicodinguser.ui.screens.home

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.giftech.dicodinguser.model.User
import com.giftech.dicodinguser.ui.theme.DicodingUserTheme

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    onClickItem: (Int) -> Unit,
    onAboutClick: () -> Unit
) {
    val users = listOf(
        User(
            id = 1,
            name = "John Doe",
            imageUrl = "https://randomuser.me/api/portraits/women/1.jpg",
            university = "University of California, Berkeley",
            numCertificationsCompleted = 5
        ),
        User(
            id = 2,
            name = "Jane Doe",
            imageUrl = "https://randomuser.me/api/portraits/men/1.jpg",
            university = "University of California, Los Angeles",
            numCertificationsCompleted = 3
        ),
        User(
            id = 3,
            name = "Alice Smith",
            imageUrl = "https://i.pravatar.cc/150?img=1",
            university = "Stanford University",
            numCertificationsCompleted = 7
        )
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Home")
                },
                actions = {
                    IconButton(onClick = {
                        // Show profile screen
                    }) {
                        Icon(imageVector = Icons.Default.Person, contentDescription = "")
                    }
                }
            )
        }
    ) {
        HomeContent(users = users, onClickItem = onClickItem)
    }
}

@Composable
fun HomeContent(
    users: List<User>,
    onClickItem: (Int) -> Unit
) {
    LazyColumn(
        modifier = Modifier,
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
            model = user.imageUrl,
            contentDescription = null,
            modifier = Modifier.width(64.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = user.name)
            Text(
                text = "${user.university} • ${user.numCertificationsCompleted} certifications",
                style = MaterialTheme.typography.body2
            )
        }
    }
}