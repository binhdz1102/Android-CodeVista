package com.binhdz.androidcodevista

//import com.binhdz.androidcodevista.feature_note.domain.model.Note
//import com.binhdz.androidcodevista.feature_note.domain.repository.NoteRepository
//import com.binhdz.androidcodevista.feature_note.domain.usecases.GetNotes
//import kotlinx.coroutines.flow.flowOf
//import kotlinx.coroutines.flow.toList
//import kotlinx.coroutines.runBlocking
//import org.junit.Before
//import org.junit.Test
//import org.mockito.Mockito.*
//import kotlin.test.assertEquals
//
//class GetNotesTest {
//
//    private lateinit var getNotes: GetNotes
//    private lateinit var repository: NoteRepository
//
//    @Before
//    fun setUp() {
//        repository = mock(NoteRepository::class.java)
//        getNotes = GetNotes(repository)
//    }
//
//    @Test
//    fun `getting notes returns list of notes`() = runBlocking {
//        val expectedNotes = listOf(
//            Note(
//                title = "Note 1",
//                content = "Content 1",
//                timestamp = System.currentTimeMillis(),
//                color = 0xFF0000
//            ),
//            Note(
//                title = "Note 2",
//                content = "Content 2",
//                timestamp = System.currentTimeMillis(),
//                color = 0x00FF00
//            )
//        )
//        `when`(repository.getNotes()).thenReturn(flowOf(expectedNotes))
//
//        val result = getNotes().toList()
//
//        assertEquals(expectedNotes, result)
//    }
//
//    @Test
//    fun `getting notes returns empty list`() = runBlocking {
//        `when`(repository.getNotes()).thenReturn(flowOf(emptyList()))
//
//        val result = getNotes().toList()
//
//        assertEquals(emptyList<Note>(), result)
//    }
//
//
//    @Test
//    fun `getting notes with repository error throws exception`() = runBlocking {
//        `when`(repository.getNotes()).thenThrow(RuntimeException("Database error"))
//
//        try {
//            getNotes().toList()
//            fail("Exception was expected but not thrown")
//        } catch (e: Exception) {
//            assertEquals("Database error", e.message)
//        }
//    }
//
//}
