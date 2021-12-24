package com.example.madapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class CreateAccount : AppCompatActivity() {

    private lateinit var createBTN: Button

    private lateinit var password: TextView
    private lateinit var name: TextView
    private lateinit var email:TextView
    private lateinit var dateOfBirth:TextView
    private lateinit var address:TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)

        connectXML()
    }

    private fun connectXML() {
        password = findViewById(R.id.createPassword)
        name = findViewById(R.id.createFullNameInsert)
        email = findViewById(R.id.createEmailInsert)
        dateOfBirth = findViewById(R.id.dobId)
        address = findViewById(R.id.createAddress)

        createBTN = findViewById(R.id.createBtn)

        createBTN.setOnClickListener {
            val nm = name.text.toString()
            val el = email.text.toString()
            val pass = password.text.toString()
            val dob = dateOfBirth.text.toString()
            val add = address.text.toString()

            val databaseHandler: dbHelp= dbHelp(this)

            if(nm == "" || el == "" || pass == "" || dob == "" || add == ""){
                Toast.makeText(this,"Please enter all the fields ", Toast.LENGTH_LONG).show()
            }
            else{
//                Toast.makeText(this,"before email check ", Toast.LENGTH_LONG).show()
                val checkUserEmail = databaseHandler.checkEmail(el)
//                Toast.makeText(this,"after email check ", Toast.LENGTH_LONG).show()
                if (checkUserEmail < 1)
                {
                    val insert = databaseHandler.insertValues(nm,el,dob,pass,add)
                    if (insert > -1)
                    {
                        Toast.makeText(this,"data inserted done", Toast.LENGTH_LONG).show()
                        val objectIntent1 = Intent(this,MainActivity::class.java);// stay towards the login page
                        startActivity(objectIntent1)
                    }
                    else
                    {
                        Toast.makeText(this,"Registration failed" , Toast.LENGTH_LONG).show()
                    }
                }
                else{

                    Toast.makeText(this,"Email already exist please sign in",Toast.LENGTH_LONG).show()

                }


            }
        }

    }
}