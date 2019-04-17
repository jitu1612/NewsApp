package com.news.newsapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.LinearLayout
import android.widget.Toast
import com.android.volley.DefaultRetryPolicy
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.news.newsapp.Model.NewsAdapter
import com.news.newsapp.Model.NewsDto
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

class NewsList : AppCompatActivity() {


    val urlbusi = "https://newsapi.org/v2/top-headlines?country=in&category=business&apiKey=5fa8bff3704d4949bcc5b4720f46d9f5"
    val urltech = "https://newsapi.org/v2/top-headlines?country=in&category=technology&apiKey=5fa8bff3704d4949bcc5b4720f46d9f5"
    val urlhealth = "https://newsapi.org/v2/top-headlines?country=in&category=health&apiKey=5fa8bff3704d4949bcc5b4720f46d9f5"
    val urlscience = "https://newsapi.org/v2/top-headlines?country=in&category=science&apiKey=5fa8bff3704d4949bcc5b4720f46d9f5"
    val urlsports = "https://newsapi.org/v2/top-headlines?country=in&category=sports&apiKey=5fa8bff3704d4949bcc5b4720f46d9f5"
    val urlenter = "https://newsapi.org/v2/top-headlines?country=in&category=entertainment&apiKey=5fa8bff3704d4949bcc5b4720f46d9f5"
    lateinit var swipe: SwipeRefreshLayout



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_list)

        swipe = findViewById(R.id.swipe) as SwipeRefreshLayout

        swipe.setOnRefreshListener {
            request()
        }

        swipe.isRefreshing=true
        request()
    }

    public fun request () {

        val intent=getIntent()
        var typeURL=""

        if (intent.getStringExtra("type").equals("business")){
            typeURL=urlbusi
        }else if (intent.getStringExtra("type").equals("entertainment")){
            typeURL=urlenter
        }else if (intent.getStringExtra("type").equals("health")){
            typeURL=urlhealth
        }else if (intent.getStringExtra("type").equals("science")){
            typeURL=urlscience
        }else if (intent.getStringExtra("type").equals("sports")){
            typeURL=urlsports
        }else if (intent.getStringExtra("type").equals("technology")){
            typeURL=urltech
        }

        val url = "https://newsapi.org/v2/top-headlines?country=in&category=business&apiKey=5fa8bff3704d4949bcc5b4720f46d9f5"

        val jsonObjectRequest = JsonObjectRequest(Request.Method.GET, typeURL, null,
                Response.Listener { response ->
                    Log.d("r",response.toString())
                    show(response)
                },
                Response.ErrorListener { error ->
                    // TODO: Handle error
                    Toast.makeText(applicationContext!!.getApplicationContext(), "No Internet Access, Check your internet connection.",
                            Toast.LENGTH_SHORT).show()
                    Log.d("r",error.toString())
                }
        )

        val requestQueue = Volley.newRequestQueue(applicationContext!!)

        jsonObjectRequest.setRetryPolicy(DefaultRetryPolicy(10 * 1000, 0,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES.toFloat()))
        //requestQueue.add(jsonArrayRequest);
        requestQueue.add<JSONObject>(jsonObjectRequest)

    }

    private fun show(jsonObject: JSONObject) {


        val list = ArrayList<NewsDto>()

        var jsonArray : JSONArray
        jsonArray=jsonObject.getJSONArray("articles")

        Log.d("r",jsonArray.toString())
        //if (images.isEmpty()) {
        for (i in 0 until jsonArray.length()) {
            //Creating a json object of the current index
            var obj: JSONObject? = null
            try {

                obj = jsonArray.getJSONObject(i)

                list.add(NewsDto(obj.optString("title"),obj.optString("description"),obj.optString("url"),obj.optString("urlToImage"),obj.optString("content"),obj.optString("publishedAt"),
                        obj.getJSONObject("source").optString("name")))
                Log.d("list "+i," "+list.get(i).title)
            } catch (e: JSONException) {
                e.printStackTrace()
            }

        }
        //}

        val recyclerView = findViewById(R.id.recyclerview) as RecyclerView

        //adding a layoutmanager
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)

        val RecyclerAdapter = NewsAdapter(list, applicationContext)
        recyclerView.setHasFixedSize(true)
        recyclerView.setAdapter(RecyclerAdapter)
        RecyclerAdapter.notifyDataSetChanged()

        swipe.isRefreshing=false
    }

}
