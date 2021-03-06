package com.uttab.halcondeoro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        Thread.sleep(2000)
        setTheme(R.style.Theme_HalconDeOro)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        radios.setOnClickListener {
            val intent: Intent = Intent(this, RadiosActivity::class.java)
            startActivity(intent)
        }


        btnguardar.setOnClickListener {
            val intent : Intent = Intent(this, AgregarActivity::class.java)
            startActivity(intent)
        }
    }
}