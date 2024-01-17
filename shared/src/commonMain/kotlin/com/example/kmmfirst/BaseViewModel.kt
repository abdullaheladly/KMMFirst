package com.example.kmmfirst

import kotlinx.coroutines.CoroutineScope

expect open class BaseViewModel() {
    val scope:CoroutineScope
}