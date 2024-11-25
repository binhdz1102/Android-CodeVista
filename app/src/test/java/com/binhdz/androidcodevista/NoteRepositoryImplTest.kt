package com.binhdz.androidcodevista

import com.binhdz.androidcodevista.feature_note.data.data_source.NoteDao
import com.binhdz.androidcodevista.feature_note.data.repository.NoteRepositoryImpl
import com.binhdz.androidcodevista.feature_note.domain.model.Note
import com.binhdz.androidcodevista.feature_note.domain.model.InvalidNoteException
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations
import kotlin.test.assertFailsWith

class NoteRepositoryImplTest {

    private lateinit var repository: NoteRepositoryImpl

    @Mock
    private lateinit var noteDao: NoteDao

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        repository = NoteRepositoryImpl(noteDao)
    }

    @Test
    fun `getNotes returns flow of note list`(): Unit = runBlocking {
        // Arrange
        val mockNotes = listOf(
            Note("Title 1", "Content 1", 123456789L, 0xFF0000, 1),
            Note("Title 2", "Content 2", 123456799L, 0x00FF00, 2)
        )
        `when`(noteDao.getNotes()).thenReturn(flowOf(mockNotes))

        // Act
        val result = repository.getNotes()

        // Assert
        result.collect { notes ->
            assertEquals(mockNotes, notes)
        }
        verify(noteDao).getNotes()
    }

    @Test
    fun `getNoteById returns note with given id`(): Unit  = runBlocking {
        // Arrange
        val noteId = 1
        val mockNote = Note("Title 1", "Content 1", 123456789L, 0xFF0000, noteId)
        `when`(noteDao.getNoteById(noteId)).thenReturn(mockNote)

        // Act
        val result = repository.getNoteById(noteId)

        // Assert
        assertEquals(mockNote, result)
        verify(noteDao).getNoteById(noteId)
    }

    @Test
    fun `insertNote calls insertNote on DAO`() = runBlocking {
        // Arrange
        val note = Note("New Title", "New Content", 123456799L, 0x00FF00)

        // Act
        repository.insertNote(note)

        // Assert
        verify(noteDao).insertNote(note)
    }

    @Test
    fun `deleteNote calls deleteNote on DAO`() = runBlocking {
        // Arrange
        val note = Note("Delete Title", "Delete Content", 123456789L, 0xFF0000)

        // Act
        repository.deleteNote(note)

        // Assert
        verify(noteDao).deleteNote(note)
    }

    @Test
    fun `insertNote throws InvalidNoteException when title is blank`() = runBlocking {
        // Arrange
        val invalidNote = Note("", "Content", 123456789L, 0xFF0000)

        // Act & Assert
        val exception = assertFailsWith<InvalidNoteException> {
            repository.insertNote(invalidNote)
        }
        assertEquals("The title of the note can't be empty.", exception.message)
    }

    @Test
    fun `insertNote throws InvalidNoteException when content is blank`() = runBlocking {
        // Arrange
        val invalidNote = Note("Title", "", 123456789L, 0xFF0000)

        // Act & Assert
        val exception = assertFailsWith<InvalidNoteException> {
            repository.insertNote(invalidNote)
        }
        assertEquals("The content of the note can't be empty.", exception.message)
    }
}
