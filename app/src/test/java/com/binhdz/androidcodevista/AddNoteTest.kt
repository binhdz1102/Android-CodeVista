package com.binhdz.androidcodevista

import com.binhdz.androidcodevista.feature_note.domain.model.InvalidNoteException
import com.binhdz.androidcodevista.feature_note.domain.model.Note
import com.binhdz.androidcodevista.feature_note.domain.repository.NoteRepository
import com.binhdz.androidcodevista.feature_note.domain.usecases.AddNote
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.*

class AddNoteTest {

    private lateinit var addNote: AddNote
    private lateinit var repository: NoteRepository

    @Before
    fun setUp() {
        repository = mock(NoteRepository::class.java)
        addNote = AddNote(repository)
    }

    @Test(expected = InvalidNoteException::class)
    fun `adding note with empty title throws exception`() = runBlocking {
        val note = Note(
            title = "",
            content = "Sample Content",
            timestamp = System.currentTimeMillis(),
            color = 0xFF0000
        )
        addNote(note)
    }

    @Test
    fun `adding valid note calls repository`() = runBlocking {
        val note = Note(
            title = "Valid Title",
            content = "Sample Content",
            timestamp = System.currentTimeMillis(),
            color = 0xFF0000
        )

        addNote(note)

        verify(repository).insertNote(note)
    }

    @Test(expected = InvalidNoteException::class)
    fun `adding note with empty title and content throws exception`() = runBlocking {
        val note = Note(
            title = "",
            content = "",
            timestamp = System.currentTimeMillis(),
            color = 0xFF0000
        )
        addNote(note)
    }

}
