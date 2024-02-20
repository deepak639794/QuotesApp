package com.example.myquotes

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentTransaction
import com.example.retrofitlearning.ArrayAuthor
import com.example.retrofitlearning.QuoteDataClass
import com.example.retrofitlearning.pair
import org.w3c.dom.Text
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AuthorListFragment(var inter:LoadingFragment) : Fragment() {

    //var frag =LoadingFragment()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_author_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var arr = arrayListOf<String>()
        loadApi(arr,view)
        //loadfrag(AuthourNameCard(inter,arr),0)
        var randomQuotesList :TextView= view.findViewById(R.id.RandomQoutes)
        randomQuotesList.setOnClickListener {
            inter.loadFragment(RandomQuotesList(inter),1)
        }

    }


    fun loadfrag(fragment: Fragment , flag :Int){
        var fragmentManager = childFragmentManager
        var fragmentTransaction: FragmentTransaction =fragmentManager.beginTransaction()
        if(flag==0)
        fragmentTransaction.add(R.id.container,fragment)
        else
            fragmentTransaction.add(R.id.container,fragment)

        fragmentTransaction.commit()
    }
    fun loadApi( arr:ArrayList<String>,view :View){
        //var arr = arrayListOf<pair>()
        var quotelist =APIInterface.QuoteInstance.GetAuthourName(5000)
        quotelist.enqueue(object : Callback<ArrayAuthor> {
            override fun onResponse(
                call: Call<ArrayAuthor>,
                response: Response<ArrayAuthor>
            ) {
                //Log.d("Response","${response.body()}")
                var mylist =response.body()

                if (mylist != null) {
                    for(i in mylist.results){

                        var author =i.name
                        Log.d("author_names","$author")
                        arr.add(author)

                    }
                    loadfrag(AuthourNameCard(inter,arr),1)
                    var text1:TextView=view.findViewById(R.id.textveiw)
                    text1.text=""
                }
            }

            override fun onFailure(call: Call<ArrayAuthor>, t: Throwable) {
                Log.d("here is the failure","jfjf",t)
            }

        })



    }



}