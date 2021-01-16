package com.aj.firebaselogin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var imageViewSun: ImageView
    private lateinit var imageViewDayLandScape: ImageView
    private lateinit var imageViewNightLandScape: ImageView
    private lateinit var daySkyView: View
    private lateinit var nightSkyView: View
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageViewSun = findViewById(R.id.sunImageView)
        imageViewDayLandScape = findViewById(R.id.dayLSImageView)
        imageViewNightLandScape = findViewById(R.id.nightLSImageView)

        daySkyView = findViewById(R.id.dayView)
        nightSkyView = findViewById(R.id.nightView)

        val hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
        Log.e(TAG, hour.toString())
        if (hour > 18) {
            //Night Time
            imageViewSun.animate().translationY(110f).duration = 1000
            daySkyView.animate().alpha(0.0f).duration = 1000
            imageViewDayLandScape.animate().alpha(0.0f).duration = 1000
        } else if (hour < 18) {
            if (hour < 12) {
                imageViewSun.animate().translationY(-110f).duration = 1000
            } else {
                imageViewSun.animate().translationY(-410f).duration = 1000
            }
            nightSkyView.animate().alpha(0.0f).duration = 1000
            imageViewNightLandScape.animate().alpha(0.0f).duration = 1000
        }
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}