package com.asthabansal.chatviewtask

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter (var chatlist:ArrayList<>):RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    class meViewHolder(view:View) : RecyclerView.ViewHolder(view){

        var meChat = view.findViewById<TextView>(R.id.tvMe)
    }

    class otherViewHolder(view:View):RecyclerView.ViewHolder(view){

    }

    class groupViewHolder(view:View):RecyclerView.ViewHolder(view){


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

}
