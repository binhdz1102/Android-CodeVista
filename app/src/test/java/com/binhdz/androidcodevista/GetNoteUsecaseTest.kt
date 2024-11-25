package com.binhdz.androidcodevista

//import com.binhdz.androidcodevista.feature_note.domain.model.Note
//import com.binhdz.androidcodevista.feature_note.domain.repository.NoteRepository
//import kotlinx.coroutines.runBlocking
//import org.junit.Before
//import org.junit.Test
//import org.mockito.Mockito.*
//import kotlin.test.assertEquals
//
//class GetNoteUsecaseTest {
//
//    private lateinit var getNoteUsecase: GetNoteUsecase
//    private lateinit var repository: NoteRepository
//
//    @Before
//    fun setUp() {
//        repository = mock(NoteRepository::class.java)
//        getNoteUsecase = GetNoteUsecase(repository)
//    }
//
//    @Test
//    fun `getting note by id returns correct note`() = runBlocking {
//        val noteId = 1
//        val expectedNote = Note(
//            title = "Sample Title",
//            content = "Sample Content",
//            timestamp = System.currentTimeMillis(),
//            color = 0xFF0000,
//            id = noteId
//        )
//        `when`(repository.getNoteById(noteId)).thenReturn(expectedNote)
//
//        val result = getNoteUsecase(noteId)
//
//        assertEquals(expectedNote, result)
//    }
//
//    @Test
//    fun `getting note by invalid id returns null`() = runBlocking {
//        val invalidId = -1
//        `when`(repository.getNoteById(invalidId)).thenReturn(null)
//
//        val result = getNoteUsecase(invalidId)
//
//        assertEquals(null, result)
//    }
//
//}
