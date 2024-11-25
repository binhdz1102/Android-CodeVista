package com.binhdz.androidcodevista.feature_note.data.repository

import com.binhdz.androidcodevista.feature_note.data.data_source.NoteDao
import com.binhdz.androidcodevista.feature_note.domain.model.InvalidNoteException
import com.binhdz.androidcodevista.feature_note.domain.model.Note
import com.binhdz.androidcodevista.feature_note.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow

class NoteRepositoryImpl(
    private val dao: NoteDao
) : NoteRepository {
    override fun getNotes(): Flow<List<Note>> {
        return dao.getNotes()
    }

    override suspend fun getNoteById(id: Int): Note? {
        return dao.getNoteById(id)
    }

//    override suspend fun insertNote(note: Note) {
//        dao.insertNote(note)
//    }

    override suspend fun insertNote(note: Note) {
        if (note.title.isBlank()) {
            throw InvalidNoteException("The title of the note can't be empty.")
        }
        if (note.content.isBlank()) {
            throw InvalidNoteException("The content of the note can't be empty.")
        }
        dao.insertNote(note)
    }

    override suspend fun deleteNote(note: Note) {
        dao.deleteNote(note)
    }
}
