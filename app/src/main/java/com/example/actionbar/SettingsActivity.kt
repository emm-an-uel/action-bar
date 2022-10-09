package com.example.actionbar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TableLayout
import android.widget.TableRow
import androidx.core.os.bundleOf
import com.google.android.material.floatingactionbutton.FloatingActionButton

class SettingsActivity : AppCompatActivity() {

    lateinit var tableLayout: TableLayout
    lateinit var fabNewColor: FloatingActionButton
    lateinit var btnConfirm: Button
    lateinit var idMap: MutableMap<Int, Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        tableLayout = findViewById(R.id.tableLayout)
        fabNewColor = findViewById(R.id.fabNewColor)
        btnConfirm = findViewById(R.id.btnConfirm)
        idMap = mutableMapOf()

        fabNewColor.setOnClickListener {
            newRow()
        }

        btnConfirm.setOnClickListener {
            confirmColors()
        }
    }

    private fun newRow() {
        val tableRow = TableRow(this)
        val etSubject = EditText(this)
        val etColor = EditText(this)

        etSubject.id = View.generateViewId()
        etColor.id = View.generateViewId()
        idMap.put(etSubject.id, etColor.id) // put etSubject.id with corresponding etColor.id in a map

        etSubject.layoutParams = TableRow.LayoutParams(
            TableRow.LayoutParams.WRAP_CONTENT,
            TableRow.LayoutParams.WRAP_CONTENT,
            1f
        )

        etColor.layoutParams = TableRow.LayoutParams(
            TableRow.LayoutParams.WRAP_CONTENT,
            TableRow.LayoutParams.WRAP_CONTENT,
            1f
        )

        tableRow.addView(etSubject)
        tableRow.addView(etColor)

        tableLayout.addView(tableRow)
    }

    private fun confirmColors() {

        val listSubjectColor = arrayListOf<SubjectColor>()

        for ((subjectID, colorID) in idMap) {
            val etSubject = findViewById<EditText>(subjectID)
            val etColor = findViewById<EditText>(colorID)

            val subject = etSubject.text.toString()
            val color = etColor.text.toString()

            val subjectColor = SubjectColor(subject, color)
            listSubjectColor.add(subjectColor)
        }

        val intent = Intent(this, MainActivity2::class.java)
        intent.putExtra("listSubjectColor", listSubjectColor)
        startActivity(intent)
        finish()
    }
}