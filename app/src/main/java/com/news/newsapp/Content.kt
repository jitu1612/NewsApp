package com.news.newsapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.webkit.WebView

class Content : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content)

        val intent=intent
        var url=intent.getStringExtra("url")
        val webView=findViewById(R.id.webview) as WebView
        webView.loadUrl(url)

    }
}
