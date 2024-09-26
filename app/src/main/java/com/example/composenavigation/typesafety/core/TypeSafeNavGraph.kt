package com.example.composenavigation.typesafety.core

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composenavigation.typesafety.data.BookReadStatus
import com.example.composenavigation.typesafety.features.bookDetails.BookDetailScreen
import com.example.composenavigation.typesafety.features.bookList.ListOfBooksScreen
import com.example.composenavigation.typesafety.shared.BookDetail
import com.example.composenavigation.typesafety.shared.ListOfBooks
import com.example.composenavigation.typesafety.shared.clearSnapShot
import com.example.composenavigation.typesafety.shared.getSnapShot


@Composable
fun TypeSafetyNavigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(navController, startDestination = ListOfBooks) {
        composable<ListOfBooks>(
            typeMap = ListOfBooks.typeMap,
            content = {
                var result by rememberSaveable { mutableStateOf<BookReadStatus?>(null) }

                LaunchedEffect(key1 = Unit) {
                    snapshotFlow {
                        navController.getSnapShot<BookReadStatus>()
                    }.collect { resultData ->
                        if (resultData != null) {
                            result = resultData
                            Log.e("data", "data received on callback ${resultData.status}")
                            navController.clearSnapShot<BookReadStatus>()
                        }
                    }
                }

                ListOfBooksScreen(
                    result,
                    onBookClick = {
                        navController.navigate(BookDetail(it))
                    },
                )
            }
        )

        composable<BookDetail>(
            typeMap = BookDetail.typeMap
        ) {
            BookDetailScreen(modifier = modifier, navController = navController)
        }
    }
}
