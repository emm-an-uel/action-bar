package com.example.actionbar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity2 : AppCompatActivity() {

    lateinit var btnActivity1: Button
    lateinit var listSubjectColor: ArrayList<SubjectColor>
    lateinit var tvEnglish: TextView
    lateinit var tvMaths: TextView
    lateinit var tvScience: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        btnActivity1 = findViewById(R.id.btnActivity1)

        // go back to MainActivity
        btnActivity1.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        // get data from intent
        getFromIntent()
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

    private fun getFromIntent() {
        val bundle = intent.extras
        if (bundle != null) {
            listSubjectColor = bundle.getParcelableArrayList("listSubjectColor")!!

            tvEnglish = findViewById(R.id.tvEnglish)
            tvMaths = findViewById(R.id.tvMaths)
            tvScience = findViewById(R.id.tvScience)

            for (item in listSubjectColor) {
                if (item.subject == "english") {
                    tvEnglish.text = "English: ${item.color}"
                } else if (item.subject == "maths") {
                    tvMaths.text = "Maths: ${item.color}"
                } else if (item.subject == "science") {
                    tvScience.text = "Science: ${item.color}"
                }
            }
        }
    }
}