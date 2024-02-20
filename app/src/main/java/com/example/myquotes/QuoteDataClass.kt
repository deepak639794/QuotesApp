package com.example.retrofitlearning


data class pair(var quote :String,var authour:String)
data class QuoteDataClass (
    var _id: String,
    // The quotation text
    var content: String,
    // The full name of the author
    var author: String,
    // The `slug` of the quote author
    var authorSlug: String,
    // The length of quote (number of characters)
    var length: Int

)
data class AuthorList(var id: String,
    // A brief, one paragraph bio of the author. Source: wiki API
                      var bio: String,
    // A one-line description of the author. Typically it is the person's primary
    // occupation or what they are know for.
                      var description: String,
    // The link to the author's wikipedia page or official website
                      var link: String,
    // The authors full name
                      var name: String,
    // A slug is a URL-friendly ID derived from the authors name. It can be used as
                      var slug: String,
    // The number of quotes by this author
                      var quoteCount: String)


data class ArrayAuthor(
    var count: Int,
    // The total number of results matching this request.
    var totalCount: Int,
    // The current page number
    var page: Int,
    // The total number of pages matching this request
    var totalPages: Int,
    // The 1-based index of the last result included in this response. This shows the
    // current pagination offset.
    var lastItemIndex: Int,
    var results: ArrayList<AuthorList>
// The array of authors

)

