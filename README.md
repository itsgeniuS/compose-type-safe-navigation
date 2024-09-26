# Compose Navigation type safety

### Overview of how to..

- how to work with the new type safe Jetpack Compose navigation.
- how to send data to next screen via TypeSafe Navigation
- how to setResultAndPop current screen to send data back to the previous screen

You can find more info about the motivation behind this repository in the
post [Type Safety in Navigation Compose](https://medium.com/@edmiro/type-safety-in-navigation-compose-23c03e3d74a5)

#### To Launch a screen with arguments

```kotlin
composable<BookDetail>(
    typeMap = BookDetail.typeMap
) {
    BookDetailScreen(modifier = modifier, navController = navController)
}
```

#### Set result back to previous screen using previousBackStateEntry

```kotlin
fun <T> NavController.setResultAndPop(key: String, value: T) {
    this.apply {
        previousBackStackEntry
            ?.savedStateHandle
            ?.set(key, value)
        popBackStack()
    }
}
```

#### To get the screen result from last screen on current screen

```kotlin
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
```
