package com.example.madapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    private lateinit var loginLink:TextView
    private lateinit var createLink:TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        connectXML()
    }

    private fun connectXML() {
        try {
            //linking front end button with the backend as we need to go into the another activity
            createLink = findViewById(R.id.create_Link)
            createLink.setOnClickListener {
                val objectIntent = Intent(this,CreateAccount::class.java)
                startActivity((objectIntent))
            }

//            linking front end button with the backend as we need to go into the another activity
            loginLink = findViewById(R.id.login_Link)
            loginLink.setOnClickListener {
                val objectIntent = Intent(this,LoginIn::class.java);
                startActivity(objectIntent);


            }
        }
        catch (ex:Exception)
        {
            Toast.makeText(this,"Logical Error:${ex.message.toString()}",Toast.LENGTH_LONG).show()
        }
    }




}