package com.example.androiddevchallenge.model

import androidx.annotation.DrawableRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Female
import androidx.compose.material.icons.filled.Male
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.androiddevchallenge.R

data class Puppy(
    val nickname: String,
    val breed: String,
    val dateBorn: String,
    val gender: Gender,
    @DrawableRes val pictureRes: Int,
    val shortSummary: String,
    val longSummary: String
) {

    enum class Gender(val genderImage: ImageVector, val tint: Color) {
        Male(Icons.Default.Male, Color.Blue),
        Female(Icons.Default.Female, Color.Magenta)
    }
}

val puppyList by lazy {
    listOf(
        Puppy(
            nickname = "Andriyko",
            breed = "Husky",
            dateBorn = "2020-08-31",
            gender = Puppy.Gender.Male,
            pictureRes = R.drawable.andriyko_unsplash,
            shortSummary = "A lovely little puppy",
            longSummary = "This little dog is very friendly, polite and a typical young puppy.\n\n" +
                    "If you have a lovely home and are eager to spend time with this good boy, please " +
                    "apply for an adoption."
        ),
        Puppy(
            nickname = "Kate",
            breed = "Mix",
            dateBorn = "2020-09-10",
            gender = Puppy.Gender.Female,
            pictureRes = R.drawable.kate_unsplash,
            shortSummary = "A lovely little puppy",
            longSummary = "This little dog is very friendly, polite and a typical young puppy.\n\n" +
                    "If you have a lovely home and are eager to spend time with this good girl, please " +
                    "apply for an adoption."
        ),
        Puppy(
            nickname = "Dong",
            breed = "Mix",
            dateBorn = "2020-10-15",
            gender = Puppy.Gender.Male,
            pictureRes = R.drawable.dong_unsplash,
            shortSummary = "A lovely little puppy",
            longSummary = "This little dog is very friendly, polite and a typical young puppy.\n\n" +
                    "If you have a lovely home and are eager to spend time with this good boy, please " +
                    "apply for an adoption."
        ),
        Puppy(
            nickname = "Flouffy",
            breed = "Cavalier",
            dateBorn = "2020-08-31",
            gender = Puppy.Gender.Male,
            pictureRes = R.drawable.flouffy_unsplash,
            shortSummary = "A lovely little puppy",
            longSummary = "This little dog is very friendly, polite and a typical young puppy.\n\n" +
                    "If you have a lovely home and are eager to spend time with this good boy, please " +
                    "apply for an adoption."
        ),
        Puppy(
            nickname = "Ignacio",
            breed = "Mix",
            dateBorn = "2020-06-22",
            gender = Puppy.Gender.Male,
            pictureRes = R.drawable.ignacio_unsplash,
            shortSummary = "A lovely little puppy",
            longSummary = "This little dog is very friendly, polite and a typical young puppy.\n\n" +
                    "If you have a lovely home and are eager to spend time with this good boy, please " +
                    "apply for an adoption."
        ),
        Puppy(
            nickname = "Karsten",
            breed = "Mix",
            dateBorn = "2020-07-10",
            gender = Puppy.Gender.Male,
            pictureRes = R.drawable.karsten_unsplash,
            shortSummary = "A lovely little puppy",
            longSummary = "This little dog is very friendly, polite and a typical young puppy.\n\n" +
                    "If you have a lovely home and are eager to spend time with this good boy, please " +
                    "apply for an adoption."
        ),
        Puppy(
            nickname = "Matthew",
            breed = "White Labradoodle",
            dateBorn = "2020-07-29",
            gender = Puppy.Gender.Male,
            pictureRes = R.drawable.matthew_unsplash,
            shortSummary = "A lovely little puppy",
            longSummary = "This little dog is very friendly, polite and a typical young puppy.\n\n" +
                    "If you have a lovely home and are eager to spend time with this good boy, please " +
                    "apply for an adoption."
        ),
        Puppy(
            nickname = "Rogelio",
            breed = "Mix",
            dateBorn = "2020-12-02",
            gender = Puppy.Gender.Male,
            pictureRes = R.drawable.rogelio_unsplash,
            shortSummary = "A lovely little puppy",
            longSummary = "This little dog is very friendly, polite and a typical young puppy.\n\n" +
                    "If you have a lovely home and are eager to spend time with this good boy, please " +
                    "apply for an adoption."
        ),
    )
}