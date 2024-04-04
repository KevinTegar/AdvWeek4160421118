package com.example.advweek4160421118.model

import com.google.gson.annotations.SerializedName

data class Car(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("manufacturer")
    val manufacturer: Manufacturer,
    @SerializedName("year")
    val year: Int,
    @SerializedName("color")
    val color: String,
    @SerializedName("images")
    val images: List<String>
)

data class Manufacturer(
    @SerializedName("name")
    val name: String,
    @SerializedName("country")
    val country: String
)
