package org.caio.ceep

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var recyclerVew : RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        components()
    }

    private fun components() {
        recyclerVew = listNotesRecycler
        recyclerVew?.let {
            recyclerVew!!.adapter = NoteListAdapter(notes(), this)

            val layoutManager = StaggeredGridLayoutManager(2,
                StaggeredGridLayoutManager.VERTICAL)
            recyclerVew!!.layoutManager = layoutManager
        }
    }

    private fun notes(): List<Note> {
        return listOf(Note("Leitura", "Livro de Kotlin com Android"),
        Note("Pesquisa", "The clean code bible\n scasdas"),
        Note("Transire", "Instituto de Tecnologia e BioTecnologia do Amazonas"))
    }
}