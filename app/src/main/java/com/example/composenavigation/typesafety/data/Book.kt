package com.example.composenavigation.typesafety.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class Book(val id: Int, val title: String): Parcelable

@Parcelize
@Serializable
data class BookReadStatus(
    val id: Int,
    val title: String,
    val status: Boolean,
    val list: List<String>,
) : Parcelable