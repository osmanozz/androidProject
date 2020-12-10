package com.example.uurloon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val newintent: Button = findViewById(R.id.buttonRegister)
        newintent.setOnClickListener {
            val intent = Intent(this@MainActivity, registerAct::class.java)

            startActivity(intent)
        }

    }
}


