package com.example.uurloon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class registerAct : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)


        val newintent2: Button = findViewById(R.id.buttonBack)
        newintent2.setOnClickListener {
            val intent = Intent(this@registerAct, MainActivity::class.java)
            startActivity(intent)
        }
    }
}