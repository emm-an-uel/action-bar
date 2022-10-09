package com.example.actionbar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class SettingsActivity : AppCompatActivity() {

    lateinit var etColor: EditText
    lateinit var btnSubmit: Button
    lateinit var color: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        etColor = findViewById(R.id.etColor)
        btnSubmit = findViewById(R.id.btnSubmit)
        btnSubmit.setOnClickListener {
            color = etColor.text.toString()

            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("color", color)
            startActivity(intent)
            finish()
        }
    }
}