package org.caio.ceep.view.dialog

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.form_note.view.*
import org.caio.ceep.R
import org.caio.ceep.model.Note
import org.caio.ceep.webservice.NoteWebClient

class NoteFormDialog(
    private val context: Context,
    private val viewGroup: ViewGroup
) {

    private val createdView = createView()
    private val titleField = createdView.form_note_title
    private val descriptionField = createdView.form_note_description

    private fun createView(): View {
        return LayoutInflater.from(context).inflate(R.layout.form_note, viewGroup, false)
    }

    fun add(created: (createdNote: Note) -> Unit) {
        AlertDialog.Builder(context).setTitle("Add Note").setView(createdView)
            .setPositiveButton("Save") { _, _ ->
                val title = titleField.text.toString()
                val description = descriptionField.text.toString()
                if (title != "" || description != "") {
                    NoteWebClient(context).insert(Note(title = title, description = description), {
                        created(it)
                    }, {
                        Toast.makeText(context, "Falha ao salvar nota", Toast.LENGTH_LONG).show()
                    })
                } else {
                    Toast.makeText(context, "Preencha os campos corretamente", Toast.LENGTH_LONG)
                        .show()
                }
            }.show()
    }

    fun alter(note: Note, altered: (alteredNote: Note) -> Unit) {
        titleField.setText(note.title)
        descriptionField.setText(note.description)
        AlertDialog.Builder(context)
            .setTitle("Add Note")
            .setView(createdView)
            .setPositiveButton("Save") { _, _ ->
                val title = titleField.text.toString()
                val description = descriptionField.text.toString()
                val alteredNote = note.copy(title = title, description = description)

                NoteWebClient(context).alter(alteredNote, {
                    altered(it)
                }, {
                    Toast.makeText(context, "Falha ao alterar nota", Toast.LENGTH_LONG).show()
                })

            }.show()
    }
}