package com.example.planetapp

import android.annotation.SuppressLint
import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_planet_detail.*

class planetDetail : AppCompatActivity() {
    private lateinit var  obj:planetData
    private var planetImage: Int? =null
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_planet_detail)
        window.decorView.apply { systemUiVisibility=
            View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN }


        obj= intent.getParcelableExtra("data")!!
        planetImage=intent.getIntExtra("planetImage",-1)
        setData(obj, planetImage!!)

        button_info.setOnClickListener{
            val intent = Intent(this, finalActivity::class.java)
            startActivity(intent)
        }

    }

    private fun setData(obj: planetData, planetImage: Int){
        title_info.text = obj.title
        gravity_info.text = obj.gravity+" m/ss"
        distance_info.text = obj.distance + "m km"
        overviewInfo.text = obj.overview
        galaxy_info.text = obj.galaxy
        planet_info.setImageResource(planetImage)


    }
}