package com.example.android.marsphotos.network

import com.squareup.moshi.Json

// data class needs to have atleast one property defined.
data class MarsPhoto(
    val id: String,
    @Json(name = "img_src") val imgSrcUrl: String // JSON annotation is used here to use variable names in your data class that differ from the key names in the JSON response,
)