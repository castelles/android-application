package org.caio.ceep.webservice

import org.caio.ceep.model.Note

interface NoteResponse<T> {

    fun success(response: T)
}