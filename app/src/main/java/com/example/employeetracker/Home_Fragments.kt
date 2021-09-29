package com.example.employeetracker

import android.app.AlertDialog
import android.content.Intent
import android.hardware.Sensor
import android.hardware.SensorManager
import android.os.Bundle
import android.view.*
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Home_Fragments : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
//        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.toolbaroptions, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.AbouttUs -> {
                startActivity(Intent(context, AboutUs_Activity::class.java))
                true
            }
            R.id.contactUs -> {
                startActivity(Intent(context, ContactUs_Activity::class.java))
                true
            }
//            R.id.locationBaniyatar -> {
//                startActivity(Intent(context, BaniyatarMapsActivity::class.java))
//                true
//            }
//            R.id.locationChabahil -> {
//                startActivity(Intent(context, ChabahilMapsActivity::class.java))
//                true
//            }
//
//            R.id.locationGyaneswor -> {
//                startActivity(Intent(context, GyanesworMapsActivity::class.java))
//                true
//            }
//            R.id.locationKritipur -> {
//                startActivity(Intent(context, KritipurMapsActivity::class.java))
//                true
//            }
//            R.id.locationPutalisadak -> {
//                startActivity(Intent(context, PutalisadakMapsActivity::class.java))
//                true
//            }
            R.id.rateus -> {
                startActivity(Intent(context, RateUsActivity::class.java))
                true
            }
            R.id.logout -> {
                alerdialogforlogout()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }


    private fun alerdialogforlogout() {
        val builder = AlertDialog.Builder(requireContext())

        //set title for alert dialog
        builder.setTitle("Logout")

        //set message alert box
        builder.setMessage("Are you sure you want to LOGOUT?")

        builder.setIcon(android.R.drawable.ic_dialog_alert)

        //performing positive action
        builder.setPositiveButton("YES")
        { dialogInterface, which ->
            val sharedPref = context?.getSharedPreferences("MyPref", AppCompatActivity.MODE_PRIVATE)
            val editor = sharedPref?.edit()?.clear()?.apply()
            startActivity(
                Intent(
                    requireContext(),
                    LoginActivity::class.java
                )
            )
//                finish()
        }

        //performing negative action
        builder.setNegativeButton("NO")
        { dialogInterface, which ->

        }

        //Create the AlertDialog
        val alertDialog: AlertDialog = builder.create()
        alertDialog.setCancelable(false)
        alertDialog.show()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home__fragments, container, false)
        return view

    }


}