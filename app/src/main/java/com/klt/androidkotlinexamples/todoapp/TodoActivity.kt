package com.klt.androidkotlinexamples.todoapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import com.klt.androidkotlinexamples.R

class TodoActivity : AppCompatActivity() {

    private lateinit var rvCategory: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_todo)

        initComponent()
        initUI()
    }

    private fun initComponent(){

        rvCategory = findViewById(R.id.rvCategories)

    }

    private fun initUI() {

    }

}