package com.example.employeetracker

import android.content.Intent
import android.graphics.*
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.*

class Splash_Screen_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash__screen_)
//        title = "Grocery Department"

        //to make image corner round
        val imageview: ImageView = findViewById(R.id.imageview)
        val bitmap = (resources.getDrawable(R.drawable.app_icon) as BitmapDrawable).bitmap
        val imageRounded = Bitmap.createBitmap(bitmap.width, bitmap.height, bitmap.config)
        val canvas = Canvas(imageRounded)
        val paint = Paint()
        paint.isAntiAlias = true
        paint.shader = BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
        canvas.drawRoundRect(
            RectF(10F, 10F, bitmap.width.toFloat(), bitmap.height.toFloat()),
            200F, 200F, paint
        ) // Round Image Corner 100 100 100 100
        imageview.setImageBitmap(imageRounded)

        //Background Thread
        CoroutineScope(Dispatchers.IO).launch {
            delay(10000)
            withContext(Dispatchers.Main) {
                startActivity(Intent(this@Splash_Screen_Activity, MainActivity::class.java))
                finish()
            }
        }
    }

}