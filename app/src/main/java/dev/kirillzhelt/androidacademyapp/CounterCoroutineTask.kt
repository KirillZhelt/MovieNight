package dev.kirillzhelt.androidacademyapp

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay

class CounterCoroutineTask {

    suspend fun count() = coroutineScope {
        repeat(10) {
            delay(500)
        }
    }

}