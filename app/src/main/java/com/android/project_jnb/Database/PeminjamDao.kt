package com.android.project_jnb.Database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PeminjamDao {
    @Query("SELECT * FROM peminjam")
    fun getAll(): List<Peminjam>

    @Query("SELECT * FROM peminjam WHERE kode IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<Peminjam>

    @Query("SELECT * FROM customer WHERE nama LIKE :nama AND " +
            "petugas LIKE :petugas LIMIT 1")
    fun findByName(nama: String, petugasperpus: String): Peminjam

    @Insert
    fun insertAll(vararg peminjam: Peminjam)

    @Delete
    fun delete(peminjam: Peminjam)
}