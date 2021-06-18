package com.example.messagingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.messagingapp.Dao.PostDao

class CreatePostActivity : AppCompatActivity() {
    private lateinit var postDao :PostDao
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_post)
        postDao= PostDao()
        findViewById<Button>(R.id.postButton).setOnClickListener {
            val input = findViewById<EditText>(R.id.inputText).text.toString().trim()
            if (input.isNotEmpty()) {
                postDao.addPost(input)
                finish()

            }
        }
    }
}