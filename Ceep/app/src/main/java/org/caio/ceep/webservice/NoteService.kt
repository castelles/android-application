package org.caio.ceep.webservice

import org.caio.ceep.model.Note
import retrofit2.Call
import retrofit2.http.GET

interface NoteService {

    @GET("notes")
    fun list() : Call<List<Note>>
}