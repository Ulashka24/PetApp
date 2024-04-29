package com.sathiyavan.petapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView


class MainActivity2 : AppCompatActivity() {
    //Declaring variables
    private lateinit var buttonPlay: button
    private lateinit var buttonFeed: button
    private lateinit var buttonBath: button
    private lateinit var imageViewPet: ImageView
    class myPet(var myPet: String){
    }

    private var Happiness = 100
    private var Cleanliness = 100
    private var Hunger = 0

    @SuppressLint("MissingInflatedId", "ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        //Initializing variables
        buttonPlay= findViewById<button>(R.id.buttonPlay)
        buttonFeed= findViewById<button>(R.id.buttonFeed)
        buttonBath= findViewById<button>(R.id.buttonBath)

        imageViewPet= findViewById(R.id.imageViewPet)

        //set image
        imageViewPet.setImageResource(R.drawable.eating)
        //set button
        buttonFeed.setOnClickListener {
            if(imageViewPet){
                imageViewPet.setImageResource(R.drawable.eating)
            }else{
                imageViewPet.setImageResource(R.id.imageViewPet)
            }
        }
        imageViewPet.setImageResource(R.drawable.bathing)
        buttonBath.setOnClickListener {
            if (imageViewPet){
                imageViewPet.setImageResource(R.drawable.bathing)
            }else{
                imageViewPet.setImageResource(R.id.imageViewPet)
            }
        }
        imageViewPet.setImageResource(R.drawable.playing)
        buttonPlay.setOnClickListener {
            if (imageViewPet) {
                imageViewPet.setImageResource(R.drawable.playing)
            }else{
                imageViewPet.setImageResource(R.id.imageViewPet)
            }
        }
        //feed
        fun Feed(){
            Hunger = 10
            if(Hunger<0) Hunger=0
            Happiness += 5
            Cleanliness-= 3
        }
        //play
        fun Play(){
            Happiness+= 10
            if (Happiness>100)Happiness=100
            Hunger +=5
            if (Hunger>100)Hunger=100
            Cleanliness-= 5
            if(Cleanliness<0)Cleanliness=0
        }
        //Clean
        fun Clean (){
            Cleanliness=100
            Happiness-=5
            if(Happiness<0)Happiness=0
        }

        fun printIn(Hunger: String) {

        }

        fun printin(Clean: String) {

        }

        //Print pets status
        fun checkStatus(){
            printIn("Hunger:$Hunger")
            printIn("Happiness:$Happiness")
            printin("Cleanliness:$Cleanliness")
        }


    }

}
