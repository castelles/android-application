package org.caio.ceep.webservice

import org.caio.ceep.model.Note

interface NoteResponse {

    fun success(notes: List<Note>)
}