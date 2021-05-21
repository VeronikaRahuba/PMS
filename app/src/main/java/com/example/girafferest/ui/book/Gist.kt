package com.example.girafferest.ui.book

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Gist(var error: String, var total: String, var page: String, var books: List<Book>)
