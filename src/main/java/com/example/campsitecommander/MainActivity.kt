package com.example.campsitecommander

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    // Declare arrays in companion object so they are accessible from Splashscreen
    companion object {
        val itemArray = Array<String>(5) { "" }
        val categoryArray = Array<String>(5) { "" }
        val qualityArray = Array<String>(5) { "" }
        val commentsArray = Array<String>(5) { "" }
        var count = 0
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val edtItem = findViewById<EditText>(R.id.edtItem)
        val edtCategory = findViewById<EditText>(R.id.edtCategory)
        val edtQuality = findViewById<EditText>(R.id.edtQuality)
        val edtComments = findViewById<EditText>(R.id.edtComments)
        val btnAdd = findViewById<Button>(R.id.btnAdd)
        val btnSecond = findViewById<Button>(R.id.btnSecond)
        val btnExit = findViewById<Button>(R.id.btnExit)
        
        btnSecond.setOnClickListener {
            val intent = Intent(this, Splashscreen::class.java)
            startActivity(intent)
        }
        
        btnExit.setOnClickListener {
            finish()
        }
        
        btnAdd.setOnClickListener {
            val item = edtItem.text.toString()
            val category = edtCategory.text.toString()
            val quality = edtQuality.text.toString()
            val comments = edtComments.text.toString()

            if (count >= 5) {
                Toast.makeText(this, "Maximum 5 items reached", Toast.LENGTH_SHORT).show()
            } else if (item.isEmpty() || category.isEmpty() || quality.isEmpty() || comments.isEmpty()) {
                Toast.makeText(this, "Please enter all fields", Toast.LENGTH_SHORT).show()
            } else {
                // Storing the data at the current count index
                itemArray[count] = item
                categoryArray[count] = category
                qualityArray[count] = quality
                commentsArray[count] = comments
                count++
                
                Toast.makeText(this, "Item added successfully ($count/5)", Toast.LENGTH_SHORT).show()

                // Clear fields
                edtItem.text.clear()
                edtCategory.text.clear()
                edtQuality.text.clear()
                edtComments.text.clear()
            }
        }
    }
}
