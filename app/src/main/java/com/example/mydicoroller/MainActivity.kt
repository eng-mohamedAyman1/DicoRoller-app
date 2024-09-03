package com.example.mydicoroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    lateinit var textView: TextView
    lateinit var button: Button
    lateinit var imageView1: ImageView
    lateinit var imageView2: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        textView=findViewById(R.id.textView)
        button=findViewById(R.id.button)
        imageView1=findViewById(R.id.imageView)
        imageView2=findViewById(R.id.imageView2)
        var random1= Random.nextInt(6)+1
        var random2= Random.nextInt(6)+1
        textView.text="${random1 + random2}"
        imageView1.setImageResource(image(random1))
        imageView2.setImageResource(image(random2))
        button.setOnClickListener(){
            Toast.makeText(this, "button click", Toast.LENGTH_SHORT).show()
            var random1= Random.nextInt(6)+1
            var random2= Random.nextInt(6)+1

            imageView1.setImageResource(image(random1))
            imageView2.setImageResource(image(random2))
            textView.text="${random1+random2}"
        }
    }

    fun image(namber:Int): Int {

        return when(namber){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
    }

}