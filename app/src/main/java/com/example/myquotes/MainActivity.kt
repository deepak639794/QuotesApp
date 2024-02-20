package com.example.myquotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.RecyclerView
import com.example.checkbox.RecyclerAdaptorAuthor

class MainActivity : AppCompatActivity() ,LoadingFragment {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //loadFragment(AuthourNameCard(),0)

        loadFragment(AuthorListFragment(this),0)
//        var randomQuotestext :TextView= findViewById(R.id.RandomQoutes)
//        randomQuotestext.setOnClickListener {
//            Log.d("yaha ho gya print? ","ha ho gaya")
//            loadFragment(QuoteList(),1)
//        }
    }


    override fun loadFragment(fragment: Fragment, flag: Int) {
        var fragmentManager =supportFragmentManager
        var fragmentTransaction: FragmentTransaction =fragmentManager.beginTransaction()
        if(flag==0)
            fragmentTransaction.add(R.id.container_mainactivity,fragment)
        else
            fragmentTransaction.replace(R.id.container_mainactivity,fragment)

        fragmentTransaction.commit()
    }

}