package com.movietracker

import android.app.Activity
import android.os.Bundle
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

class CoroutineActivity : Activity(), CoroutineScope {
    // This is responsible for managing the lifecycle of all coroutines
    // started in the `Activity`.
    lateinit var job: Job

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // We create the job in `onCreate`, and afterward, we can use coroutines
        // in the `Activity`.
        job = Job()
    }

    // This tells our coroutines about the context to use.
    override val coroutineContext: CoroutineContext
        // Make sure to use `Dispatchers.Main` so the Android UI thread
        // is used by default.
        get() = Dispatchers.Main + job

    override fun onDestroy() {
        super.onDestroy()
        // This will cancel all currently running coroutines.
        job.cancel()
    }
}