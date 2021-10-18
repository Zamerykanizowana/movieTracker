package com.movietracker

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONArray
import org.json.JSONObject
import java.nio.charset.Charset

class MainActivity : AppCompatActivity() {
    @DelicateCoroutinesApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        var responseIMDb: String
        GlobalScope.launch {
            responseIMDb = loadTheData()
            Log.i("DEBUG", responseIMDb)
            val options = JSONObject(responseIMDb).getJSONArray("d") as JSONArray
            for (i in 0 until options.length()) {
                val id = options.getJSONObject(i).getString("id")
                val title = options.getJSONObject(i).getString("l")
                Log.i("DEBUG", "ID: $id and title is : $title")
            }
        }
//        textView.text = responseIMDb
        val textView = findViewById<TextView>(R.id.text1)
        textView.text = "Test line Kotlin djfgfnbjjinn"
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
        return response.body!!.string()
    }

}