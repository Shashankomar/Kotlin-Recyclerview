package com.example.kotlinquoteslist

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class MainDataModel(
    @Expose
    @SerializedName("albumId")
    val albumid: Int,
    @Expose
    @SerializedName("id")
    val id: Int,
    @Expose
    @SerializedName("title")
    val title: String,
    @Expose
    @SerializedName("url")
    val url: String,
    @Expose
    @SerializedName("thumbnailUrl")
    val thumbnailurl: String
)

