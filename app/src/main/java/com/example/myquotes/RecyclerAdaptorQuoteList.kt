package com.example.myquotes

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitlearning.pair

class RecyclerAdaptorQuoteList(var context: Context,var arr :ArrayList<pair>) :RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    inner class ViewHolder(item : View) :RecyclerView.ViewHolder(item){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.quote_card,parent,false))
    }

    override fun getItemCount(): Int {
        return arr.size
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var quote :TextView =holder.itemView.findViewById(R.id.quoteText)
        var author: TextView=holder.itemView.findViewById(R.id.quoteAuthor)
        quote.text=arr[position].quote

        author.text=arr[position].authour
    }
}