package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class  MainActivity : AppCompatActivity() {

        private lateinit var editText: EditText

        private var operand1: Double? = null
        private var pendingOperation = ""

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            editText = findViewById(R.id.editText)

            val button0: Button = findViewById(R.id.button0)
            val button1: Button = findViewById(R.id.button1)
            val button2: Button = findViewById(R.id.button2)
            val button3: Button = findViewById(R.id.button3)
            val button4: Button = findViewById(R.id.button4)
            val button5: Button = findViewById(R.id.button5)
            val button6: Button = findViewById(R.id.button6)
            val button7: Button = findViewById(R.id.button7)
            val button8: Button = findViewById(R.id.button8)
            val button9: Button = findViewById(R.id.button9)

            val buttonPlus: Button = findViewById(R.id.buttonPlus)
            val buttonMinus: Button = findViewById(R.id.buttonMinus)
            val buttonMultiply: Button = findViewById(R.id.buttonMultiply)
            val buttonDivide: Button = findViewById(R.id.buttonDivide)
            val buttonEqual: Button = findViewById(R.id.buttonEqual)
            val buttonAC: Button = findViewById(R.id.buttonAC)

            val buttonDecimal: Button = findViewById(R.id.buttonDecimal)

            val listener = { v: android.view.View ->
                val b = v as Button
                editText.append(b.text)
            }

            button0.setOnClickListener(listener)
            button1.setOnClickListener(listener)
            button2.setOnClickListener(listener)
            button3.setOnClickListener(listener)
            button4.setOnClickListener(listener)
            button5.setOnClickListener(listener)
            button6.setOnClickListener(listener)
            button7.setOnClickListener(listener)
            button8.setOnClickListener(listener)
            button9.setOnClickListener(listener)
            buttonDecimal.setOnClickListener(listener)

            buttonPlus.setOnClickListener {
                performOperation()
                pendingOperation = "+"
                editText.append("+")
            }

            buttonMinus.setOnClickListener {
                performOperation()
                pendingOperation = "-"
                editText.append("-")
            }

            buttonMultiply.setOnClickListener {
                performOperation()
                pendingOperation = "*"
                editText.append("x")
            }

            buttonDivide.setOnClickListener {
                performOperation()
                pendingOperation = "/"
                editText.append("/")
            }

            buttonEqual.setOnClickListener {
                performOperation()
                pendingOperation = ""
            }

            buttonAC.setOnClickListener {
                operand1 = null
                pendingOperation = ""
                editText.text.clear()
            }
        }

        private fun performOperation() {
            if (operand1 == null) {
                try {
                    operand1 = editText.text.toString().toDouble()
                } catch (e: NumberFormatException) {
                    editText.text.clear()
                }
            } else {
                val operand2 = editText.text.toString().toDouble()
                var result = 0.0
                when (pendingOperation) {
                    "+" -> result = operand1!! + operand2
                    "-" -> result = operand1!! - operand2
                    "*" -> result = operand1!! * operand2
                    "/" -> {
                        if (operand2 != 0.0) {
                            result = operand1!! / operand2
                        }
                    }
                }
                editText.setText(result.toString())
                operand1 = result
            }
            editText.text.clear()
        }
    }
