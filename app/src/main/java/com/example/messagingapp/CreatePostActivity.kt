package com.example.messagingapp

import android.content.Intent
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.messagingapp.Dao.PostDao

class CreatePostActivity : AppCompatActivity() {
    private lateinit var postDao: PostDao
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_create_post)
        postDao = PostDao()
        findViewById<Button>(R.id.postButton).setOnClickListener {

            val input = findViewById<EditText>(R.id.inputText).text.toString().trim()
            if (input.isNotEmpty()) {
                postDao.addPost(input)
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }
}
