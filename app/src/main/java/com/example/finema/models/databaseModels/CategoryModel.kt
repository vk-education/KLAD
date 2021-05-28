package com.example.finema.models.databaseModels

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

data class CategoryModel(
    @PrimaryKey
    val id: String = "0",
    @ColumnInfo
    val name: String = "",
    @ColumnInfo
    val description: String = "",
    @ColumnInfo
    val link: String = "",
)
