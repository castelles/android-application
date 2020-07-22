package org.caio.ceep.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.note_item.view.*
import org.caio.ceep.model.Note
import org.caio.ceep.R

class NoteListAdapter(
    private val notes: List<Note>,
    private val context: Context,
    private val onItemClickListener: (note: Note, position: Int) -> Unit
) :
    RecyclerView.Adapter<NoteListAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(note: Note) {
            val title = itemView.noteItemTitle
            val description = itemView.noteItemDescription
            title.text = note.title
            description.text = note.description
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.note_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return notes.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val note = notes[position]
        holder?.let {
            it.bindView(note)
            it.itemView.setOnClickListener {
                onItemClickListener(note, position)
            }
        }
    }
}

