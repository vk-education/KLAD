package com.example.finema.models.databaseModels

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "top_list", indices = [Index("id")])
data class TopModel(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    @ColumnInfo
    val title: String = "",
    @ColumnInfo(typeAffinity = ColumnInfo.BLOB)
    var image: ByteArray? = null,
    @ColumnInfo
    val about: String = "",
    @ColumnInfo
    val genres: String? = "",
    @ColumnInfo
    val rating: String = "",
    @ColumnInfo
    val companies: String? = "",

    ) : Serializable