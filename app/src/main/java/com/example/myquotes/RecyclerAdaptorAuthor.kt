package com.example.checkbox

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

import com.example.myquotes.R


class RecyclerAdaptorAuthor(var context : Context,
                      var arr: ArrayList<String>
):RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    inner  class ViewHolder(item    : View) :RecyclerView.ViewHolder(item) {
        //var img :ImageView =item.findViewById(R.id.ImageId)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.card,parent,false))
    }

    override fun getItemCount(): Int {
        return arr.size
    }
//ed7a59a05941410c8c131d0d09cbba83
    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        var text : TextView=holder.itemView.findViewById(R.id.CardViewId)
        Log.d("my output",arr[position])
        text.text=arr[position]


    }







}