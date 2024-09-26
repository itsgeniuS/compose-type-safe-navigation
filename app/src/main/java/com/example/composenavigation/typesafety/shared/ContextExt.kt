package com.example.composenavigation.typesafety.shared

import android.content.Context
import android.widget.Toast

/**
 * @Author: Thulasirajan.P
 * @Date: 9/26/24
 */
fun Context.showToast(message: String?) {
    message?.let { mContent ->
        Toast.makeText(this, mContent, Toast.LENGTH_SHORT).show()
    }
}