package com.example.androiddevchallenge.ui

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.androiddevchallenge.model.Puppy

@Composable
fun PuppyDetailPage(puppy: Puppy, navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(puppy.nickname) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, null)
                    }
                }
            )
        }
    ) {

    }
}