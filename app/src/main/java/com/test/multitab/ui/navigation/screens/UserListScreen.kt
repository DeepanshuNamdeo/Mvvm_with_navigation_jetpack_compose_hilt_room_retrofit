package com.test.multitab.ui.navigation.screens

import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.test.multitab.R
import com.test.multitab.data.entities.User
import com.test.multitab.ui.viewmodels.MainActivityViewModel

@Composable
fun UserListScreen(
    mainActivityViewModel: MainActivityViewModel = hiltViewModel(),
    modifier: Modifier
) {
    val userListState by mainActivityViewModel.state.collectAsState()
    if (userListState.isEmpty()) {
        Box(
            modifier = modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column {
                CircularProgressIndicator()
            }
        }
    } else {
        LazyColumn() {
            items(userListState) { item: User ->
                UserListItem(
                    modifier = modifier,
                    user = item,
                    onClickDelete = {
                        mainActivityViewModel.deleteUser(item)
                    })
            }
        }
    }
}


@Composable
fun UserListItem(modifier: Modifier, user: User, onClickDelete: () -> Unit) {
    Row(modifier = modifier) {
        Column(modifier = modifier.padding(2.dp)) {
            Text(text = "Name : ${user.name}")
            Text(text = "Gender : ${user.gender}")
            Text(text = "Email : ${user.name}")
        }

        Column(
            modifier = modifier.padding(2.dp),
        ) {
            Text(text = "status : ${user.status}")
            IconButton(onClick = {
                onClickDelete()
            }) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_baseline_delete_24),
                    contentDescription = null
                )
            }
        }
    }
}

