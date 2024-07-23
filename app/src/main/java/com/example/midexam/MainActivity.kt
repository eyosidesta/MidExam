package com.example.midexam

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etNumber1 = findViewById<EditText>(R.id.etNumber1)
        val etNumber2 = findViewById<EditText>(R.id.etNumber2)
        val btnAdd = findViewById<Button>(R.id.btnAdd)
        val btnSubtract = findViewById<Button>(R.id.btnSubtract)
        val btnMultiply = findViewById<Button>(R.id.btnMultiply)
        val btnDivide = findViewById<Button>(R.id.btnDivide)
        val tvResult = findViewById<TextView>(R.id.tvResult)

        btnAdd.setOnClickListener {
            performOperation(etNumber1, etNumber2, tvResult, "add")
        }

        btnSubtract.setOnClickListener {
            performOperation(etNumber1, etNumber2, tvResult, "subtract")
        }

        btnMultiply.setOnClickListener {
            performOperation(etNumber1, etNumber2, tvResult, "multiply")
        }

        btnDivide.setOnClickListener {
            performOperation(etNumber1, etNumber2, tvResult, "divide")
        }
    }

    private fun performOperation(etNumber1: EditText, etNumber2: EditText, tvResult: TextView, operation: String) {
        val number1 = etNumber1.text.toString().toDoubleOrNull()
        val number2 = etNumber2.text.toString().toDoubleOrNull()

        if (number1 != null && number2 != null) {
            val result = when (operation) {
                "add" -> number1 + number2
                "subtract" -> number1 - number2
                "multiply" -> number1 * number2
                "divide" -> {
                    if (number2 != 0.0) {
                        number1 / number2
                    } else {
                        "Error: Division by Zero"
                    }
                }
                else -> "Unknown Operation"
            }
            tvResult.text = result.toString()
        } else {
            tvResult.text = "Please enter valid numbers"
        }
    }
}
