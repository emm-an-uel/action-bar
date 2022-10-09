package com.example.actionbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TableLayout
import android.widget.TableRow
import com.google.android.material.floatingactionbutton.FloatingActionButton

class SettingsActivity : AppCompatActivity() {

    lateinit var tableLayout: TableLayout
    lateinit var fabNewColor: FloatingActionButton
    lateinit var btnConfirm: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        tableLayout = findViewById(R.id.tableLayout)
        fabNewColor = findViewById(R.id.fabNewColor)
        btnConfirm = findViewById(R.id.btnConfirm)

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
        val mapColors = mutableMapOf<String, String>()

        // TODO: implement this
    }
}