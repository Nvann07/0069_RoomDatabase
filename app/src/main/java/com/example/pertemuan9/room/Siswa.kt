package com.example.pertemuan9.room

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "tblSiswa")
class Siswa {
    @PrimaryKey(autoGenerate = true)
    val id : int = 0,
    val name : String,

}