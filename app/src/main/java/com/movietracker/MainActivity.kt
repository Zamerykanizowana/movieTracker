package com.movietracker

import android.os.Bundle
import android.os.StrictMode
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.Request

class MainActivity : AppCompatActivity() {
    @DelicateCoroutinesApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        GlobalScope.launch {
            val responseIMDb = loadTheData()
            val textView = findViewById<TextView>(R.id.text1)
            textView.text = responseIMDb
        }

//
//        val textView = findViewById<TextView>(R.id.text1)
//        textView.text = "test 123"
    }

    suspend fun loadTheData(): String {
        Thread.sleep(3000)
        val client = OkHttpClient()
        val request = Request.Builder()
            .url("https://imdb8.p.rapidapi.com/auto-complete?q=game%20of%20throne")
            .get()
            .addHeader("x-rapidapi-host", "imdb8.p.rapidapi.com")
            .addHeader("x-rapidapi-key", "YOUR_KEY")
            .build()
        val response = client.newCall(request).execute()
        return response.toString()
    }

}