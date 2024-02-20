package com.example.myquotes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.checkbox.RecyclerAdaptorAuthor


class AuthourNameCard(var inter :LoadingFragment,var arr:ArrayList<String>) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_authour_name_card, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       // inter.loadFragment()
        var recyclerView :RecyclerView=view.findViewById(R.id.recyclerveiw)
        var recyclerAdaptor=RecyclerAdaptorAuthor(requireContext(),arr)
        recyclerView.layoutManager= LinearLayoutManager(requireContext())
        recyclerView.adapter=recyclerAdaptor


    }



}