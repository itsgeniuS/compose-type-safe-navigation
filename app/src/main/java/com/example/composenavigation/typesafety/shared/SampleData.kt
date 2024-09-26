package com.example.composenavigation.typesafety.shared

import com.example.composenavigation.typesafety.data.Book

object SampleData {
    val books = (0..25).map {
        Book(it, "Book $it")
    }

    fun getBook(id: Int) = books.first { it.id == id }
}
