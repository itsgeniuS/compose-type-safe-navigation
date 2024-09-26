package com.example.composenavigation.typesafety.features.bookList

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.composenavigation.typesafety.data.Book
import com.example.composenavigation.typesafety.data.BookReadStatus
import com.example.composenavigation.typesafety.shared.SampleData
import com.example.composenavigation.typesafety.shared.showToast

@Composable
fun ListOfBooksScreen(
    bookReadStatus: BookReadStatus? = null,
    modifier: Modifier = Modifier,
    onBookClick: (Book) -> Unit,
) {
    val context = LocalContext.current

    LaunchedEffect(
        key1 = bookReadStatus,
        block = {
            bookReadStatus?.let { bookStatus ->
                if (bookStatus.status) {
                    context.showToast("Glad, you liked the book :)")
                } else {
                    context.showToast("See more books to check your likings :)")
                }
            }
        }
    )

    LazyColumn(
        modifier = modifier.fillMaxSize(),
    ) {
        items(SampleData.books) {
            BookCell(
                modifier = Modifier.clickable(onClick = { onBookClick(it) }),
                book = it,
            )
        }
    }
}

@Composable
fun BookCell(book: Book, modifier: Modifier = Modifier) {
    Text(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        text = book.title,
    )
}
