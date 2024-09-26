package com.example.composenavigation.typesafety.shared

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.toRoute
import com.example.composenavigation.typesafety.data.Book
import kotlinx.serialization.Serializable
import kotlin.reflect.typeOf

/**
 * @Author: Thulasirajan.P
 * @Date: 9/26/24
 */

@Serializable
object ListOfBooks

@Serializable
data class BookDetail(val book: Book) {
    companion object {
        val typeMap = mapOf(typeOf<Book>() to serializableType<Book>())

        fun from(savedStateHandle: SavedStateHandle) =
            savedStateHandle.toRoute<BookDetail>(typeMap)
    }
}