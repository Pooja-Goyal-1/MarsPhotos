package com.example.android.marsphotos.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL =
    "https://android-kotlin-fun-mars-server.appspot.com" // main server from where data will be extracted.

//Creating Moshi Object
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()


//Creating retrofit object.
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

// MarsApiService defines how Retrofit talks to the web server using HTTP requests.
interface MarsApiService {
    @GET("photos")  // photos here is the end point that gets appended to base url.
    suspend fun getPhotos(): List<MarsPhoto>
}

//singleton objects - which have only one instance. The call to create() function on a Retrofit object is expensive and the app needs only one instance of Retrofit API service.
object MarsApi {
    val retrofitService : MarsApiService by lazy {
        retrofit.create(MarsApiService::class.java) }
}







