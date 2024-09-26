package com.example.composenavigation.typesafety.features.bookDetails

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.example.composenavigation.typesafety.data.BookReadStatus
import com.example.composenavigation.typesafety.shared.setResultAndPop

@Composable
fun BookDetailScreen(
    modifier: Modifier = Modifier,
    viewModel: BookDetailViewModel = hiltViewModel(),
    navController: NavHostController,
) {
    val book by viewModel.book.collectAsStateWithLifecycle()

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        Text("Id: ${book.id}")
        Text("Title: ${book.title}")


        Text("Do you like this book ?")

        Button(
            onClick = {
                navController.setResultAndPop(
                    "result",
                    BookReadStatus(
                        id = book.id,
                        title = book.title,
                        status = true,
                        list = emptyList()
                    )
                )
            },
            content = {
                Text("Yes, I Liked it!")
            },
        )

        Button(
            onClick = {
                navController.setResultAndPop(
                    "result",
                    BookReadStatus(
                        id = book.id,
                        title = book.title,
                        status = false,
                        list = emptyList()
                    )
                )
            },
            content = {
                Text("Not much")
            },
        )


        Button(
            onClick = {
                navController.popBackStack()
            },
            content = {
                Text("Go back")
            },
        )
    }
}
