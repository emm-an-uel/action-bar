package com.example.actionbar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {

    lateinit var tvFavColor: TextView
    lateinit var btnActivity1: Button
    lateinit var color: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        tvFavColor = findViewById(R.id.tvFavColor)
        btnActivity1 = findViewById(R.id.btnActivity1)

        // getting color from SettingsActivity
        val bundle = intent.extras
        if (bundle != null) {
            color = bundle.getString("color")!!
            tvFavColor.text = "Your favourite color is: $color"
        }

        // go back to MainActivity
        btnActivity1.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.settings_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.settings -> {
                val intent = Intent(this, SettingsActivity::class.java)
                startActivity(intent)

                return true
            } else -> super.onOptionsItemSelected(item)
        }
    }
}