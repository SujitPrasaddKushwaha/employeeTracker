package com.example.employeetracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast

class RateUsActivity : AppCompatActivity() {

    private lateinit var btnCancel: Button
    private lateinit var btnSubmit: Button
    private lateinit var rbexcellant: RadioButton
    private lateinit var rbverygood: RadioButton
    private lateinit var rbgood: RadioButton
    private lateinit var rbsatisfactory: RadioButton
    private lateinit var rbppor: RadioButton
    private lateinit var rg: RadioGroup


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rate_us)

        binding()

        btnCancel.setOnClickListener() {
            finish()
        }

        btnSubmit.setOnClickListener() {
            val selectedid = rg.checkedRadioButtonId
            val radio = findViewById<RadioButton>(selectedid)
            var ratingresult = radio.text.toString()

            Toast.makeText(this, "You rated : $ratingresult", Toast.LENGTH_SHORT).show()
            Toast.makeText(this, "Thank you for your rating", Toast.LENGTH_LONG).show()
            finish()
        }
    }

    private fun binding() {
        btnCancel = findViewById(R.id.btnCancel)
        btnSubmit = findViewById(R.id.btnSubmit)
        rg = findViewById(R.id.ratingRadtio)
        rbexcellant = findViewById(R.id.excellentRadioButton)
        rbverygood = findViewById(R.id.veryGoodRadioButton)
        rbgood = findViewById(R.id.goodRadioButton)
        rbsatisfactory = findViewById(R.id.sastisfactaryRadioButton)
        rbppor = findViewById(R.id.poorRadioButton)
    }
}