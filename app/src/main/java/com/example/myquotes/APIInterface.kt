package com.example.myquotes

import android.util.Log
import com.example.retrofitlearning.ArrayAuthor
import com.example.retrofitlearning.QuoteDataClass
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.converter.gson.GsonConverterFactory

//"https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=ed7a59a05941410c8c131d0d09cbba83"
//https://api.quotable.io/quotes/random?maxLength=50&limit=50
const val Baseurl="https://api.quotable.io"
const val apiKey="ed7a59a05941410c8c131d0d09cbba83"

interface Interface{
    @GET("/quotes/random?maxLength=70&minLength=50")  //which endpoint is called
    fun getHeadlines(@Query("limit") limit:Int) :Call<ArrayList<QuoteDataClass>>

    @GET("/authors?sortBy=dateModified&order=asc")
    fun GetAuthourName(@Query("limit") limit :Int) :Call<ArrayAuthor>



    //https://newsapi.org/v2/top-headlines?apiKey=$apiKey&country=in&page=1
    //https://api.quotable.io/authors?sortBy=name&order=asc&limit=200
    //https://api.quotable.io/quotes/random?limit=3
    //https://api.quotable.io/authors?sortBy=name&order=asc







}
object APIInterface{
    val QuoteInstance :Interface
    init{
        Log.d("yaha aya kuch"," ")
        val retrofit=Retrofit.Builder()
            .baseUrl(Baseurl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        QuoteInstance=retrofit.create(Interface::class.java)


    }
}