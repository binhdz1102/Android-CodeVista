package com.binhdz.androidcodevista.feature_note.domain.usecases

import com.binhdz.androidcodevista.feature_note.domain.usecases.AddNote
import com.binhdz.androidcodevista.feature_note.domain.usecases.DeleteNote
import com.binhdz.androidcodevista.feature_note.domain.usecases.GetNote
import com.binhdz.androidcodevista.feature_note.domain.usecases.GetNotes

data class NoteUseCases(
    val getNotes: GetNotes,
    val deleteNote: DeleteNote,
    val addNote: AddNote,
    val getIndividualNote : GetNote
)
