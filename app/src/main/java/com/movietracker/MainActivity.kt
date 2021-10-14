package com.movietracker

import android.os.Bundle
import android.os.StrictMode
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import okhttp3.OkHttpClient
import okhttp3.Request

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)


        val client = OkHttpClient()

        val request = Request.Builder()
            .url("https://imdb8.p.rapidapi.com/auto-complete?q=game%20of%20throne")
            .get()
            .addHeader("x-rapidapi-host", "imdb8.p.rapidapi.com")
            .addHeader("x-rapidapi-key", "YOUR_KEY")
            .build()

//        val response = client.newCall(request).execute()
//
//        val textView = findViewById<TextView>(R.id.text1)
//        textView.text = "test 123"
    }

}