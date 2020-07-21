package org.caio.ceep.webservice

import org.caio.ceep.model.Note

interface CallbackResponse<T> {

    fun success(response: T)
}