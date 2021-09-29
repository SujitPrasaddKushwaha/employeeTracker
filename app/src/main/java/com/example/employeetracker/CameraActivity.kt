package com.example.employeetracker

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import kotlinx.coroutines.*
import java.io.File

private const val REQUEST_CODE = 123

class CameraActivity : AppCompatActivity() {


    private lateinit var  imagepreview : ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera)

        val takepictures = findViewById<Button>(R.id.btnTakePicture)
        val btnSendImage = findViewById<Button>(R.id.btnSendImage)
        imagepreview = findViewById(R.id.imageView)

        takepictures.setOnClickListener {
            val take = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            if (take.resolveActivity(this.packageManager) != null) {
                startActivityForResult(take, REQUEST_CODE)
            } else {
                Toast.makeText(this, "Unable to open camera", Toast.LENGTH_SHORT).show()
            }
        }

        btnSendImage.setOnClickListener{
            imagepreview.setImageResource(android.R.color.darker_gray);
            Toast.makeText(this, "Send", Toast.LENGTH_SHORT).show()
            CoroutineScope(Dispatchers.IO).launch {
                delay(1000)
                withContext(Dispatchers.Main) {
                    startActivity(Intent(this@CameraActivity, DashboardActivity::class.java))
                    finish()
                }
            }
        }
    }

    private fun getPhotoFile(fileName: String): File {
        val storageDirectory = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        return File.createTempFile(fileName, ".jpg", storageDirectory)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        if (requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            val takenimage = data?.extras?.get("data") as Bitmap
            imagepreview.setImageBitmap(takenimage)
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }
}