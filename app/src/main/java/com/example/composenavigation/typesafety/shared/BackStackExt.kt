package com.example.composenavigation.typesafety.shared

import android.util.Log
import androidx.navigation.NavController

fun <T> NavController.setResultAndPop(key: String, value: T) {
    this.apply {
        previousBackStackEntry
            ?.savedStateHandle
            ?.set(key, value)
        popBackStack()
    }
}

fun <T> NavController.getResult(key: String): T? {
    return this.currentBackStackEntry
        ?.savedStateHandle
        ?.getLiveData<T>(key)?.value
}

fun <T> NavController.getSnapShot(): T? {
    return this.currentBackStackEntry?.savedStateHandle?.get<T>("result")
}

fun <T> NavController.clearSnapShot() {
    runCatching {
        this.currentBackStackEntry?.savedStateHandle?.remove<T>("result")
    }.onSuccess {
        Log.e("Removed -->", "backstack data removed")
    }.onFailure {
        Log.e("Removed -->", "backstack data Failed to remove")
    }
}