package com.example.administrator.kotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.example.administrator.demo.R

class HelloKotlinActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hello_kotlin)
        //新添加的代码
        val textTv = findViewById(R.id.tv_easy) as TextView
        textTv.text = "Hello Kotlin!"
    }
}
