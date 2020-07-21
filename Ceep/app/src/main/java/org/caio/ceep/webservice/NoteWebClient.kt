package org.caio.ceep.webservice

import android.content.Context
import android.util.Log
import android.widget.Toast
import org.caio.ceep.model.Note
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NoteWebClient(_context: Context) {

    val context = _context

    fun list(callbackResponse: CallbackResponse<List<Note>>) {
        val listingCall = ConectionInitializer().noteService().list()
        listingCall.enqueue(object: Callback<List<Note>?> {
            override fun onFailure(call: Call<List<Note>?>, t: Throwable) {
                Toast.makeText(context,
                    "Não foi possível listar suas notas",
                    Toast.LENGTH_LONG).show()
                Log.e("onFailure Error", t?.message)
            }

            override fun onResponse(call: Call<List<Note>?>, response: Response<List<Note>?>) {
                response?.body()?.let {
                    val notes: List<Note> = it
                    callbackResponse.success(notes)
                }
            }
        })
    }

    fun insert(note: Note, callbackResponse: CallbackResponse<Note>) {
        val creationCall =  ConectionInitializer().noteService().insert(note)
        creationCall.enqueue(object: Callback<Note?> {
            override fun onFailure(call: Call<Note?>, t: Throwable) {
                Toast.makeText(context,
                    "Não foi possível listar suas notas",
                    Toast.LENGTH_LONG).show()
                Log.e("onFailure Error", t?.message)
            }

            override fun onResponse(call: Call<Note?>, response: Response<Note?>) {
                Log.d("Created note", response?.body()?.title)
                callbackResponse.success(note)
            }
        })
    }

}