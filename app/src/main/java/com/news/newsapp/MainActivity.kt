package com.news.newsapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) //5fa8bff3704d4949bcc5b4720f46d9f5



        val tvbussiness = findViewById(R.id.tvbussiness) as TextView
        val tvent = findViewById(R.id.tvent) as TextView
        val tvhealth = findViewById(R.id.tvhealth) as TextView
        val tvscience = findViewById(R.id.tvscience) as TextView
        val tvsports = findViewById(R.id.tvsports) as TextView
        val tvtech = findViewById(R.id.tvtech) as TextView

        tvbussiness.setOnClickListener{

            val intent = Intent(applicationContext, NewsList::class.java)
            intent.putExtra("type","business")
            startActivity(intent)
                //Your code here
            }
        tvent.setOnClickListener{

            val intent = Intent(applicationContext, NewsList::class.java)
            intent.putExtra("type","entertainment")
            startActivity(intent)
                //Your code here
            }
        tvhealth.setOnClickListener{

            val intent = Intent(applicationContext, NewsList::class.java)
            intent.putExtra("type","health")
            startActivity(intent)
                //Your code here
            }
        tvscience.setOnClickListener{

            val intent = Intent(applicationContext, NewsList::class.java)
            intent.putExtra("type","science")
            startActivity(intent)
                //Your code here
            }
        tvsports.setOnClickListener{

            val intent = Intent(applicationContext, NewsList::class.java)
            intent.putExtra("type","sports")
            startActivity(intent)
                //Your code here
            }
        tvtech.setOnClickListener{

            val intent = Intent(applicationContext, NewsList::class.java)
            intent.putExtra("type","technology")
            startActivity(intent)
                //Your code here
            }
    }
}
