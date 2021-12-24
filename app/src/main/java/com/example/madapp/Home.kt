package com.example.madapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.madapp.databinding.ActivityHomeBinding
import java.lang.Exception



class CustomListPage : AppCompatActivity() {

    private lateinit var customListPageBindingObject:ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        customListPageBindingObject= ActivityHomeBinding.inflate(layoutInflater)
        setContentView(customListPageBindingObject.root)

        createPlayerObjects()
    }

    private fun createPlayerObjects()
    {
        try
        {
            var objAzharAli=CricketPlayer("Azhar Ali","Right Hand Batsman",R.drawable.azhar_ali)
            var objMohammadBabarAzam=CricketPlayer("Babar Azam","Right Hand Batsman",R.drawable.mohammad_babar_azam)

//            var objAzharAli1=CricketPlayer("Azhar Ali","Right Hand Batsman",R.drawable.azhar_ali)
//            var objMohammadBabarAzam1=CricketPlayer("Babar Azam","Right Hand Batsman",R.drawable.mohammad_babar_azam)
//
//            var objAzharAli2=CricketPlayer("Azhar Ali","Right Hand Batsman",R.drawable.azhar_ali)
//            var objMohammadBabarAzam2=CricketPlayer("Babar Azam","Right Hand Batsman",R.drawable.mohammad_babar_azam)
//
//            var objAzharAli3=CricketPlayer("Azhar Ali","Right Hand Batsman",R.drawable.azhar_ali)
//            var objMohammadBabarAzam3=CricketPlayer("Babar Azam","Right Hand Batsman",R.drawable.mohammad_babar_azam)
//
//            var objAzharAli4=CricketPlayer("Azhar Ali","Right Hand Batsman",R.drawable.azhar_ali)
//            var objMohammadBabarAzam4=CricketPlayer("Babar Azam","Right Hand Batsman",R.drawable.mohammad_babar_azam)
//
//            var objAzharAli5=CricketPlayer("Azhar Ali","Right Hand Batsman",R.drawable.azhar_ali)
//            var objMohammadBabarAzam5=CricketPlayer("Babar Azam","Right Hand Batsman",R.drawable.mohammad_babar_azam)
//
//            var objAzharAli6=CricketPlayer("Azhar Ali","Right Hand Batsman",R.drawable.azhar_ali)
//            var objMohammadBabarAzam6=CricketPlayer("Babar Azam","Right Hand Batsman",R.drawable.mohammad_babar_azam)

            var listOfPlayers= listOf(objMohammadBabarAzam,objAzharAli,
                objMohammadBabarAzam,objAzharAli,objMohammadBabarAzam,objAzharAli,objMohammadBabarAzam,objAzharAli,objMohammadBabarAzam,objAzharAli,
                objMohammadBabarAzam,objAzharAli,objMohammadBabarAzam,objAzharAli,objMohammadBabarAzam,objAzharAli,objMohammadBabarAzam,objAzharAli,
                objMohammadBabarAzam,objAzharAli,objMohammadBabarAzam,objAzharAli,objMohammadBabarAzam,objAzharAli,objMohammadBabarAzam,objAzharAli,
                objMohammadBabarAzam,objAzharAli,objMohammadBabarAzam,objAzharAli,objMohammadBabarAzam,objAzharAli,objMohammadBabarAzam,objAzharAli)

            customListPageBindingObject.listView.adapter=CustomArrayAdapter(Home@this, listOfPlayers)

        }
        catch (ex:Exception)
        {
            Toast.makeText(Home@this,"Logical Error:${ex.message}",Toast.LENGTH_LONG).show()
        }
    }
}


