package com.example.jetpack2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders

class MainActivity : AppCompatActivity() {

    var model=BackgroundGenerator()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.button)
        var root=findViewById<LinearLayout>(R.id.root)
        model = ViewModelProviders.of(this).get(BackgroundGenerator::class.java)
        lifecycle.addObserver(model)
        root.setBackgroundColor(model.getColor())
        button.setOnClickListener(){

            lifecycle.addObserver(model)
            var randomColor=model.generateBackground()
            root.setBackgroundColor(randomColor)

        }
    }
}
