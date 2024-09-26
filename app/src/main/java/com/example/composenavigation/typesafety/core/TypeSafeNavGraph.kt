package com.example.composenavigation.typesafety.core

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composenavigation.typesafety.features.bookDetails.BookDetailScreen
import com.example.composenavigation.typesafety.features.bookList.ListOfBooksScreen
import com.example.composenavigation.typesafety.shared.BookDetail
import com.example.composenavigation.typesafety.shared.ListOfBooks


@Composable
fun TypeSafetyNavigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(navController, startDestination = ListOfBooks) {
        composable<ListOfBooks> {
            ListOfBooksScreen(
                modifier = modifier,
                onBookClick = { navController.navigate(BookDetail(it)) },
            )
        }

        composable<BookDetail>(
            typeMap = BookDetail.typeMap
        ) {
            BookDetailScreen(modifier = modifier)
        }
    }
}
