package com.example.madapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.lang.Exception

class LoginIn : AppCompatActivity() {

    private lateinit var emailInsertion: TextView
    private lateinit var passwordInsertion: TextView
    private lateinit var loginBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_in)

        connectXML()

    }

    private fun connectXML() {
        try{
            emailInsertion = findViewById(R.id.emailInsert)
            passwordInsertion = findViewById(R.id.passwordInsert)
            loginBtn = findViewById(R.id.loginBtn)

            loginBtn.setOnClickListener {
                val emailIns = emailInsertion.text.toString()
                val passIns = passwordInsertion.text.toString()

                val databaseHandler: dbHelp= dbHelp(this)
                if(emailIns == "" || passIns == "")
                {
                    Toast.makeText(this,"Please enter all the fields ", Toast.LENGTH_LONG).show()
                }
                else{
                    val checkEmail = databaseHandler.checkEmail(emailIns)
                    if(checkEmail>0){
                        val checkPass = databaseHandler.checkPass(passIns)
                        if(checkPass>0){
                            Toast.makeText(this, "Login Successfully", Toast.LENGTH_LONG).show()
                            val objIntent = Intent(this, CustomListPage::class.java)
                            startActivity(objIntent)
                        }
                        else{
                            Toast.makeText(this,"Invalid password",Toast.LENGTH_LONG).show()
                        }
                    }
                    else{
                        Toast.makeText(this,"Invalid Credentials",Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
        catch (ex:Exception){

        }
    }
}