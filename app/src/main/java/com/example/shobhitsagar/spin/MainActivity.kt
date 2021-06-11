package com.example.shobhitsagar.spin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.RotateAnimation
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

import java.util.Random

abstract class MainActivity : AppCompatActivity() {

    internal abstract var txt: TextView
    internal abstract var iv_bottle: ImageView
    internal abstract var random: Random
    internal abstract var string: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        string = arrayOf("TRUTH", "DARE")
        iv_bottle = findViewById(R.id.iv_bottle) as ImageView
        txt = findViewById(R.id.txt) as TextView
        random = Random()

        iv_bottle.setOnClickListener {
            val rotate = RotateAnimation(0f, (random.nextInt(36000) + 360).toFloat(), RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f)
            rotate.fillAfter = true
            rotate.duration = 5000
            rotate.interpolator = AccelerateDecelerateInterpolator()
            iv_bottle.startAnimation(rotate)
            val rando = (Math.random() * 2).toInt()
            txt.text = string[rando]
            Toast.makeText(this@MainActivity, "SHOBHIT", Toast.LENGTH_SHORT).show()
        }
    }

    fun msg(view: View) {
        txt.text = "Tu PAGAL hai kya!!"
    }
}