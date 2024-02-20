package com.example.myquotes

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitlearning.pair

class QuoteList(var arr1:ArrayList<pair>) : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_quote_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        var recycler:RecyclerView =view.findViewById(R.id.RecyclerView1)
        var recyclerAdaptor =RecyclerAdaptorQuoteList(requireContext(),arr1)
        recycler.layoutManager= LinearLayoutManager(requireContext())
        recycler.adapter=recyclerAdaptor

    }


}