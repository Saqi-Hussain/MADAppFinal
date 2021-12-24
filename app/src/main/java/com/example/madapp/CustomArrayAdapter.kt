package com.example.madapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView


class CustomArrayAdapter (context:Context,var playersData:List<CricketPlayer>)
    :ArrayAdapter<CricketPlayer>(context, R.layout.row,playersData)
{
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var singleRow=LayoutInflater.from(context).inflate(R.layout.row,
            null,true)

        var nameOfPlayerTV:TextView=singleRow.findViewById(R.id.TextView1)
        var battingStyleOfPlayer=singleRow.findViewById(R.id.TextView2) as TextView
        var playerImage=singleRow.findViewById(R.id.imageView) as ImageView

        nameOfPlayerTV.text=playersData.get(position).getPName()
        battingStyleOfPlayer.text=playersData.get(position).getPBattingStyle()

        playerImage.setImageResource(playersData.get(position).getPlayerImage())
        return singleRow
    }
}