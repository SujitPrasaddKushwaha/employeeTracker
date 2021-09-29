package com.example.employeetracker

import android.content.ContentValues.TAG
import android.content.Context
import android.util.Log
import android.view.SurfaceHolder
import android.view.SurfaceView

class CameraPreview(
    context: Context,
    private var mCamera: android.hardware.Camera
):SurfaceView(context), SurfaceHolder.Callback{
    private val mHolder : SurfaceHolder = holder.apply {
        /*Install a SurfaceHolder.Callback so we get notified when the
         underlying surface is created and destroyed*/
        addCallback(this@CameraPreview)
        setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS)
    }

    override fun surfaceCreated(holder: SurfaceHolder) {
        // The Surface has been created, now tell the camera where to draw the preview.
        mCamera.apply {
            try {
                setPreviewDisplay(holder)
                startPreview()
            }
            catch (e:Exception)
            {
                Log.d(TAG, "Error setting camera preview:${e.message}")
            }
        }
    }

    override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int)
    {
        /* If your preview can change or rotate, take care of those events here.
         Make sure to stop the preview before resizing or reformatting it.*/
        if(mHolder.surface == null)
        {
            //preview surface doesn't exist
            return
        }

        //stop preview making changes
        try {
            mCamera.stopPreview()
        }catch (e:Exception)
        {
            // ignore: tried to stop a non-existent preview
        }

        // set preview size and make any resize, rotate or
        // reformatting changes here

        // start preview with new settings
        mCamera.apply {
            try {
                setPreviewDisplay(mHolder)
                startPreview()
            }catch (e:Exception)
            {
                Log.d(TAG, "Error starting camera preview: ${e.message}")
            }
        }
    }

    override fun surfaceDestroyed(holder: SurfaceHolder) {
        // empty. Take care of releasing the Camera preview in your activity.
    }
}