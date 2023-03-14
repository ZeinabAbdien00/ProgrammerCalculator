package com.example.programmercalculator

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    private lateinit var decimalInputField: TextInputEditText
    private lateinit var incomeBinary: TextInputEditText
    private lateinit var octalInputField: TextInputEditText
    private lateinit var hexadecimalInputField: TextInputEditText
    private lateinit var clearButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setFindViewById()
        setOnClickListeners()
        setOnTextChanged()

    }

    private fun setFindViewById() {
        decimalInputField = findViewById(R.id.et_decimal)
        incomeBinary = findViewById(R.id.et_binary)
        octalInputField = findViewById(R.id.et_octal)
        hexadecimalInputField = findViewById(R.id.et_hexa)
        clearButton = findViewById(R.id.clear_btn)
    }

    private fun setOnClickListeners() {
        clearButton.setOnClickListener {
            clearData()
        }
    }

    private fun setOnTextChanged() {

        incomeBinary.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (incomeBinary.hasFocus()) {
                    val binary = s.toString().toULongOrNull(2) ?: return

                    decimalInputField.setText(binary.toString(10))
                    octalInputField.setText(binary.toString(8))
                    hexadecimalInputField.setText(binary.toString(16).uppercase())
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun afterTextChanged(s: Editable?) {}

        })

        decimalInputField.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (decimalInputField.hasFocus()) {
                    val decimal = s.toString().toULongOrNull(10) ?: return

                    incomeBinary.setText(decimal.toString(2))
                    octalInputField.setText(decimal.toString(8))
                    hexadecimalInputField.setText(decimal.toString(16).uppercase())
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun afterTextChanged(s: Editable?) {}

        })

        hexadecimalInputField.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (hexadecimalInputField.hasFocus()) {
                    val hexadecimal = s.toString().toULongOrNull(16) ?: return

                    decimalInputField.setText(hexadecimal.toString(10))
                    incomeBinary.setText(hexadecimal.toString(2))
                    octalInputField.setText(hexadecimal.toString(8))
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun afterTextChanged(s: Editable?) {}

        })

        octalInputField.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (octalInputField.hasFocus()) {
                    val octal = s.toString().toULongOrNull(8) ?: return

                    decimalInputField.setText(octal.toString(10))
                    incomeBinary.setText(octal.toString(2))
                    hexadecimalInputField.setText(octal.toString(16).uppercase())
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun afterTextChanged(s: Editable?) {}

        })

    }

    private fun clearData() {
        decimalInputField.text?.clear()
        incomeBinary.text?.clear()
        octalInputField.text?.clear()
        hexadecimalInputField.text?.clear()
    }

}