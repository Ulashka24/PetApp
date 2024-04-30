package com.sathiyavan.petapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView


class MainActivity2 : AppCompatActivity() {
    //Declaring variables
    private lateinit var buttonPlay: button
    private lateinit var buttonFeed: button
    private lateinit var buttonBath: button
    private lateinit var imageViewPet: ImageView
    class myPet(var myPet: String) {
    }
    private var happiness:Int =100
    private var cleanliness: Int = 100
    private var hungry: Int= 0



    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        //Initializing variables
        val buttonPlay= findViewById<Button>(R.id.buttonPlay)
        val buttonFeed= findViewById<Button>(R.id.buttonFeed)
        val buttonBath= findViewById<Button>(R.id.buttonBath)
        imageViewPet= findViewById(R.id.imageViewPet)

        //Linking the images to the correct buttons
        //initializing the buttons with setOnClickListener
        updateUI()
        buttonPlay.setOnClickListener {
            playWithPet()
            updateUI()
            imageViewPet.setImageResource(R.drawable.playing)
        }
        buttonBath.setOnClickListener {
            bathPet()
            updateUI()
            imageViewPet.setImageResource(R.drawable.bathing)
        }
        buttonFeed.setOnClickListener {
            feedPet()
            updateUI()
            imageViewPet.setImageResource(R.drawable.eating)
        }

        }

    //feeding the pet status
        private fun feedPet(){
            hungry += 10
            if(hungry>100) hungry=100
            happiness += 5
            cleanliness-= 5

        }
        //playing with the pet status
        private fun playWithPet(){
            happiness+= 10
            if (happiness>100)happiness=100
            hungry -=5
            if (hungry>100)hungry=100
            cleanliness-= 5
            if(cleanliness<0)cleanliness=0
        }
        //Cleaning the pet status
        private fun bathPet(){
            cleanliness=100
            happiness-=5
            if(happiness<0)happiness=0
        }
    private fun updateUI(){
        val happy= findViewById<TextView>(R.id.happy)
        val clean= findViewById<TextView>(R.id.clean)
        val hunger= findViewById<TextView>(R.id.hunger)

        happy.text ="Happy:$happiness"
        clean.text ="Clean:$cleanliness"
        hunger.text ="Hunger:$hungry"
    }



    }






