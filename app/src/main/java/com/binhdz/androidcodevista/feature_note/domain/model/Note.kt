package com.binhdz.androidcodevista.feature_note.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.binhdz.androidcodevista.ui.theme.BabyBlue
import com.binhdz.androidcodevista.ui.theme.LightGreen
import com.binhdz.androidcodevista.ui.theme.RedOrange
import com.binhdz.androidcodevista.ui.theme.RedPink
import com.binhdz.androidcodevista.ui.theme.Violet

@Entity
data class Note(
  val title : String,
  val content: String,
  val timestamp: Long,
  val color: Int,
  @PrimaryKey val id: Int? = null
){
    companion object{
      val noteColors = listOf(RedOrange, LightGreen, Violet, BabyBlue, RedPink)
    }
}

class InvalidNoteException(message:String): Exception(message)
