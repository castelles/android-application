package org.caio.ceep.view

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.form_note.view.*
import org.caio.ceep.model.Note
import org.caio.ceep.view.adapter.NoteListAdapter
import org.caio.ceep.R
import org.caio.ceep.webservice.CallbackResponse
import org.caio.ceep.webservice.NoteWebClient


class MainActivity : AppCompatActivity() {

    private var recyclerVew : RecyclerView? = null
    private val notes: MutableList<Note> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        components()
    }

    private fun components() {

        addNoteBtt.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                callCreateNoteForm()
            }
        })

        NoteWebClient(applicationContext).list(object: CallbackResponse<List<Note>> {
            override fun success(notes: List<Note>) {
                this@MainActivity.notes.addAll(notes)
                recyclerConfig()
            }
        })
    }

    private fun recyclerConfig() {
        recyclerVew = listNotesRecycler
        recyclerVew?.let {
            recyclerVew!!.adapter =
                NoteListAdapter(notes, this)

            val layoutManager = StaggeredGridLayoutManager(2,
                StaggeredGridLayoutManager.VERTICAL)
            recyclerVew!!.layoutManager = layoutManager
        }
    }

    private fun callCreateNoteForm() {
        val createdView = LayoutInflater.from(this).
                inflate(R.layout.form_note, window.decorView as ViewGroup, false)
        AlertDialog.Builder(this).
                setTitle("Add Note").
                setView(createdView).
                setPositiveButton("Save", object : DialogInterface.OnClickListener{
                    override fun onClick(dialog: DialogInterface?, which: Int) {
                        val title = createdView.form_note_title.text.toString()
                        val description = createdView.form_note_description.text.toString()
                        NoteWebClient(this@MainActivity).
                            insert(Note(title, description), object: CallbackResponse<Note> {
                                override fun success(response: Note) {
                                    this@MainActivity.notes.add(response)
                                    recyclerConfig()
                                }
                            })
                    }
                }).
                show()
    }
}