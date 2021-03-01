/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.*
import com.example.androiddevchallenge.model.Puppy
import com.example.androiddevchallenge.model.puppyList
import com.example.androiddevchallenge.ui.PuppyDetailPage
import com.example.androiddevchallenge.ui.theme.MyTheme

class MainActivity : AppCompatActivity() {
    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                MyApp()
            }
        }
    }
}

@ExperimentalAnimationApi
@Composable
fun MyApp() {
    val navController = rememberNavController()

    Surface(color = MaterialTheme.colors.background) {
        NavHost(navController, startDestination = "puppyList") {
            composable("puppyList") {
                PuppyList(puppies = puppyList, navController)
            }
            composable(
                "puppyList/{puppyName}",
                arguments = listOf(navArgument("puppyName") { type = NavType.StringType })
            ) {
                val puppyName = it.arguments?.getString("puppyName")!!
                val puppy = puppyList.find { it.nickname == puppyName }!!
                PuppyDetailPage(puppy, navController)
            }
        }
    }
}

@Composable
fun PuppyList(puppies: List<Puppy>, navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Adopt a Puppy!") }
            )
        }
    ) {
        LazyColumn(
            contentPadding = PaddingValues(top = 16.dp)
        ) {
            items(items = puppies) { puppy ->
                PuppyItem(puppy) { navController.navigate("puppyList/${puppy.nickname}") }
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

@Composable
private fun PuppyItem(puppy: Puppy, onPuppyClick: (Puppy) -> Unit) {
    Column(modifier = Modifier
        .clip(RoundedCornerShape(4.dp))
        .clickable { onPuppyClick(puppy) }
        .padding(horizontal = 16.dp)) {

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Card(
                modifier = Modifier
                    .size(80.dp),
                elevation = 2.dp
            ) {
                Image(
                    painter = painterResource(puppy.pictureRes),
                    contentScale = ContentScale.Crop,
                    contentDescription = null
                )
            }

            Spacer(modifier = Modifier.width(8.dp))

            Column {
                Row {
                    Text(
                        text = puppy.nickname,
                        style = MaterialTheme.typography.h6
                    )

                    Icon(puppy.gender.genderImage, null, tint = puppy.gender.tint)
                }

                Text(text = puppy.breed)

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        Icons.Default.DateRange,
                        contentDescription = null,
                        modifier = Modifier.padding(end = 4.dp)
                    )

                    Text(text = puppy.dateBorn)
                }
            }
        }

        Text(
            text = puppy.shortSummary,
            modifier = Modifier.padding(
                vertical = 8.dp
            )
        )

        Divider()
    }
}

@ExperimentalAnimationApi
@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        MyApp()
    }
}
