package org.caio.ceep.webservice

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ConectionInitializer {

    private val client = OkHttpClient.Builder().
        connectTimeout(3500, TimeUnit.SECONDS).
        build()

    private val retrofit = Retrofit.Builder()
        .baseUrl("http://172.17.0.1:8080/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    fun noteService() = retrofit.create(NoteService::class.java)
}