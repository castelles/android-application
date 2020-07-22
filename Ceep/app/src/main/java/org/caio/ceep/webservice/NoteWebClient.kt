package org.caio.ceep.webservice

import android.content.Context
import android.util.Log
import android.widget.Toast
import org.caio.ceep.model.Note
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NoteWebClient(private val context: Context) {

    fun list(success: (notes: List<Note>) -> Unit,
            failure: (throwable: Throwable) -> Unit) {
        val listingCall = ConectionInitializer().noteService().list()
        listingCall.enqueue(callback( { response ->
            Log.e("Listing Response", "listagem executada!")
            response?.body()?.let {
                success(it)
            }
        }, { throwable ->
            throwable?.let {
                failure(it)
            }
        }))
    }

    fun insert(note: Note, success: (notes: Note) -> Unit,
            failure: (throwable: Throwable) -> Unit) {
        val creationCall = ConectionInitializer().noteService().insert(note)
        creationCall.enqueue(callback( { response ->
            Log.e("Created note", response?.body()?.title)
            response?.body()?.let {
                success(it)
            }
        }, {throwable ->
            throwable?.let {
                failure(it)
            }
        }))
    }

    fun alter(note: Note, success: (alteredNote: Note) -> Unit,
              failure: (throwable: Throwable) -> Unit) {
        val alterCall = ConectionInitializer().noteService().alter(note, note.id)
        alterCall.enqueue(callback({response ->
            Log.e("Altering a note", "done.")
            response?.body()?.let {
                success(it)
            }
        }, {throwable ->
            throwable?.let {
                failure(it)
            }
        }))
    }

}