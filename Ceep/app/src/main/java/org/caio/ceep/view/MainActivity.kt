package org.caio.ceep.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import org.caio.ceep.model.Note
import org.caio.ceep.view.adapter.NoteListAdapter
import org.caio.ceep.R
import org.caio.ceep.view.dialog.NoteFormDialog
import org.caio.ceep.webservice.NoteWebClient


class MainActivity : AppCompatActivity() {

    private var recyclerVew: RecyclerView? = null
    private val notes: MutableList<Note> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        components()
    }

    private fun components() {

        addNoteBtt.setOnClickListener {
            NoteFormDialog(this, window.decorView as ViewGroup).add {
                this.notes.add(it)
                recyclerConfig()
            }
        }

        NoteWebClient(this).list({
            this.notes.addAll(it)
            recyclerConfig()
        }, {
            Toast.makeText(this, "Falha ao buscar notas", Toast.LENGTH_LONG).show()
        })
    }

    private fun recyclerConfig() {
        recyclerVew = listNotesRecycler
        recyclerVew?.let {
            recyclerVew!!.adapter =
                NoteListAdapter(notes, this) { note, position ->
                    NoteFormDialog(this, window.decorView as ViewGroup).alter(note) {
                        notes[position] = it
                        recyclerConfig()
                    }
                }

            val layoutManager = StaggeredGridLayoutManager(
                2,
                StaggeredGridLayoutManager.VERTICAL
            )
            recyclerVew!!.layoutManager = layoutManager
        }
    }
}