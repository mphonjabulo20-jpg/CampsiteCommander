package com.example.campsitecommander

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Splashscreen : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splashscreen)
        
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnDisplay: Button = findViewById(R.id.btnDisplay)
        val btnQuantity: Button = findViewById(R.id.btnQuantity)
        val btnBack: Button = findViewById(R.id.btnBack)
        val txtOutput: TextView = findViewById(R.id.txtOutput)

        btnDisplay.setOnClickListener {
            var output = ""
            var found = false
            // Arrays in MainActivity are size 5 (indices 0..4)
            for (i in 0 until MainActivity.itemArray.size) {
                if (MainActivity.itemArray[i].isNotEmpty()) {
                    output += "Item: ${MainActivity.itemArray[i]}\n" +
                            "Category: ${MainActivity.categoryArray[i]}\n" +
                            "Quality: ${MainActivity.qualityArray[i]}\n" +
                            "Comments: ${MainActivity.commentsArray[i]}\n\n"
                    found = true
                }
            }
            txtOutput.text = if (found) output else "No items found"
        }

        btnBack.setOnClickListener {
            finish()
        }
    }
}
