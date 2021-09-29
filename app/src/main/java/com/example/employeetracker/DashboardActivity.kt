package com.example.employeetracker

import android.content.Intent
import android.hardware.Sensor
import android.hardware.SensorManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class DashboardActivity : AppCompatActivity() {

    private lateinit var bottom_navigation: BottomNavigationView

    private lateinit var sensormanager: SensorManager
    private var sensor: Sensor? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        bottom_navigation = findViewById(R.id.bottom_navigation)

        makeCurrentFragment(Home_Fragments())
        bottom_navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.home -> makeCurrentFragment(Home_Fragments())
                R.id.myProfile -> makeCurrentFragment(myProfileFragment())
                R.id.mytrack -> startActivity(Intent(this,MapsActivity::class.java))
                R.id.camera -> startActivity(Intent(this,CameraActivity::class.java))
            }
            true
        }
    }

    private fun makeCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, fragment)
            commit()
        }
    }
}