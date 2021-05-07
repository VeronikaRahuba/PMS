package com.example.girafferest.ui.book

import com.fasterxml.jackson.annotation.JsonProperty

class Book {

    @JsonProperty("title")
    var title: String? = null

    @JsonProperty("subtitle")
    var subtitle: String? = null

    @JsonProperty("isbn13")
    var isbn13: String? = null

    @JsonProperty("price")
    var price: String? = null

    @JsonProperty("image")
    var image: String? = null
    override fun toString(): String {
        return "Book(title=$title, subtitle=$subtitle, isbn13=$isbn13, price=$price, image=$image)"
    }
}