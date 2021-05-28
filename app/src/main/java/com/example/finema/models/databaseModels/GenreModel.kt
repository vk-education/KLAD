package com.example.finema.models.databaseModels

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable


@Entity(tableName = "genre_list")
data class GenreModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo
    val name: String = "",
    @ColumnInfo (typeAffinity = ColumnInfo.BLOB)
    var image: ByteArray? = null,

    val idFirebase: String = ""

) : Serializable
