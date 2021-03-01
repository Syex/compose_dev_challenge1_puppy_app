package com.example.androiddevchallenge.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.androiddevchallenge.model.Puppy
import kotlinx.coroutines.launch

@ExperimentalAnimationApi
@Composable
fun PuppyDetailPage(puppy: Puppy, navController: NavController) {
    val coroutineScope = rememberCoroutineScope()
    val alphaAnimatable = remember { Animatable(initialValue = 0f) }
    val longSummaryVisible = remember { mutableStateOf(false) }

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
        PuppyDetailContent(alphaAnimatable.value, puppy, longSummaryVisible)
    }

    coroutineScope.launch {
        alphaAnimatable.animateTo(
            targetValue = 1f,
            animationSpec = tween(durationMillis = 500)
        ) {
            if (value == targetValue) longSummaryVisible.value = true
        }
    }
}

@ExperimentalAnimationApi
@Composable
private fun PuppyDetailContent(
    alpha: Float,
    puppy: Puppy,
    longSummaryVisible: MutableState<Boolean>
) {
    Column(
        modifier = Modifier.fillMaxHeight()
    ) {
        Box(
            modifier = Modifier
                .alpha(alpha)
                .padding(top = 16.dp)
                .fillMaxWidth(),
            contentAlignment = Alignment.TopCenter
        ) {
            Image(
                painter = painterResource(puppy.pictureRes),
                contentScale = ContentScale.Fit,
                contentDescription = null
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        AnimatedVisibility(
            visible = longSummaryVisible.value,
            enter = slideInHorizontally(
                animationSpec = tween(durationMillis = 500)
            )
        ) {
            Text(
                text = puppy.longSummary,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
    }

    AnimatedVisibility(
        visible = longSummaryVisible.value,
        enter = slideInVertically(
            animationSpec = tween(durationMillis = 500),
            initialOffsetY = { it }
        )
    ) {
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(),
            contentAlignment = Alignment.BottomCenter
        ) {
            Button(
                modifier = Modifier.padding(bottom = 16.dp),
                onClick = {}
            ) {
                Icon(Icons.Default.FavoriteBorder, null)

                Text(
                    text = "Adopt this one",
                )
            }
        }
    }
}