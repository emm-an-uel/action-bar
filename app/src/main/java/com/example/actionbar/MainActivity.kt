package com.example.actionbar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var btnActivity2: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // btnActivity2 to start Activity 2
        btnActivity2 = findViewById(R.id.btnActivity2)
        btnActivity2.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.custom_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.Search -> {
                Toast.makeText(this,"You clicked Search", Toast.LENGTH_LONG).show()
                return true
            }

            R.id.Favourite -> {
                Toast.makeText(this,"You clicked Favourite", Toast.LENGTH_LONG).show()
                return true
            }

            R.id.Share -> {
                Toast.makeText(this,"You clicked Share", Toast.LENGTH_LONG).show()
                return true
            }

            R.id.whatsapp -> {
                Toast.makeText(this,"You clicked Whatsapp", Toast.LENGTH_LONG).show()
                return true
            }

            R.id.instagram -> {
                Toast.makeText(this,"You clicked Instagram", Toast.LENGTH_LONG).show()
                return true
            } else -> super.onOptionsItemSelected(item)
        }
    }
}