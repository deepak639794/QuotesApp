package com.example.myquotes

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentTransaction
import com.example.retrofitlearning.QuoteDataClass
import com.example.retrofitlearning.pair
import kotlinx.coroutines.delay
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RandomQuotesList(var inter :LoadingFragment) : Fragment() {

    var page=0
    var arrListQuoteList= arrayListOf<ArrayList<pair>>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_random_quotes_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadApi(0,view)
        var nextBtn :Button= view.findViewById(R.id.NextButton)
        var preBtn :Button = view.findViewById(R.id.PrevBtn)
        var backBtn :ImageView=view.findViewById(R.id.BackButton)
        backBtn.setOnClickListener {
            inter.loadFragment(AuthorListFragment(inter),1)
        }
        nextBtn.setOnClickListener {
            //page++
            if(page+1==arrListQuoteList.size)
                loadApi(1,view)
            else
                loadfrag(QuoteList(arrListQuoteList[++page]),1)
            Log.d("!!!","page $page and arraysize-> ${arrListQuoteList.size}")

        }

        preBtn.setOnClickListener {
            if(page>0) {
                page--
                Log.d("is there any error?","$page")
                loadfrag(QuoteList(arrListQuoteList[page]), 1)
               // loadApi(1)
            }
        }








    }
    fun loadfrag(fragment :Fragment, flag: Int){
        var fragmentManager = childFragmentManager
        var fragmentTransaction: FragmentTransaction =fragmentManager.beginTransaction()
        if(flag==0)
            fragmentTransaction.add(R.id.ContainerRandomQuotes,fragment)
        else
            fragmentTransaction.replace(R.id.ContainerRandomQuotes,fragment)
        fragmentTransaction.commit()
    }
    fun loadApi(flag:Int,view:View){
        var arr = arrayListOf<pair>()
        var quotelist =APIInterface.QuoteInstance.getHeadlines(20)
        quotelist.enqueue(object : Callback<ArrayList<QuoteDataClass>>{
            override fun onResponse(
                call: Call<ArrayList<QuoteDataClass>>,
                response: Response<ArrayList<QuoteDataClass>>
            ) {
                var mylist=response.body()

                if (mylist != null) {
                    for(i in mylist){
                        var quote:String= i.content
                        var author =i.author
                        arr.add(pair(quote,author))

                    }
                    arrListQuoteList.add(arr)
                    loadfrag(QuoteList(arrListQuoteList[page]),flag)
                    var text1: TextView =view.findViewById(R.id.textveiw)
                    text1.text=""
                }
            }

            override fun onFailure(call: Call<ArrayList<QuoteDataClass>>, t: Throwable) {
                Log.d("here is the failure","jfjf",t)
            }

        })



    }




}