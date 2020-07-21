package org.caio.ceep.webservice

import android.content.Context
import org.caio.ceep.model.Note
import retrofit2.Call

class RequestController(context: Context) {

    lateinit private var listingCall : Call<List<Note>>


}