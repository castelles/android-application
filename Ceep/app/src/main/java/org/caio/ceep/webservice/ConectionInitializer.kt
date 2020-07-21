package org.caio.ceep.webservice

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ConectionInitializer {

    private val retrofit = Retrofit.Builder()
        .baseUrl("http://172.17.0.1:8080/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun noteService() = retrofit.create(NoteService::class.java)
}