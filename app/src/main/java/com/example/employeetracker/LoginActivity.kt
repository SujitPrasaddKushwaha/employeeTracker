package com.example.employeetracker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class LoginActivity : AppCompatActivity() {

    private lateinit var userid: EditText
    private lateinit var password: EditText
    private lateinit var loginbutton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        userid = findViewById(R.id.editTextTextPersonName)
        password = findViewById(R.id.editTextTextPassword)
        loginbutton = findViewById(R.id.button2)

        loginbutton.setOnClickListener() {
            loginProcess()
        }
    }

    private fun loginProcess() {
        if (userid.text.toString().isEmpty()) {
            userid.error = "Please Enter username"
            userid.requestFocus()
        } else if (password.text.toString().isEmpty()) {
            password.error = "Please Enter password"
            password.requestFocus()
        } else {
            startActivity(Intent(this, DashboardActivity::class.java))
            finish()
        }
    }
}