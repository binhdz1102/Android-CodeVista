package com.binhdz.androidcodevista

import com.binhdz.androidcodevista.feature_note.domain.model.Note
import com.binhdz.androidcodevista.feature_note.domain.repository.NoteRepository
import com.binhdz.androidcodevista.feature_note.domain.usecases.DeleteNote
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.*

class DeleteNoteTest {

    private lateinit var deleteNote: DeleteNote
    private lateinit var repository: NoteRepository

    @Before
    fun setUp() {
        repository = mock(NoteRepository::class.java)
        deleteNote = DeleteNote(repository)
    }

    @Test
    fun `deleting note calls repository`() = runBlocking {
        val note = Note(
            title = "Sample Title",
            content = "Sample Content",
            timestamp = System.currentTimeMillis(),
            color = 0xFF0000
        )

        deleteNote(note)

        verify(repository).deleteNote(note)
    }

    @Test
    fun `deleting non-existing note does not call repository delete`() = runBlocking {
        val nonExistingNote = Note(
            title = "Non-existing",
            content = "This note does not exist",
            timestamp = System.currentTimeMillis(),
            color = 0xFF0000,
            id = 999 // Assume 999 does not exist
        )

        deleteNote(nonExistingNote)

        verify(repository, never()).deleteNote(nonExistingNote)
    }

}
