package com.misterioes.financer.dao.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.misterioes.financer.dao.entity.Transfer

@Dao
interface TransferDao {
    @Query("SELECT * FROM transfer")
    fun getAllTransfers(): LiveData<List<Transfer>>

    @Query("SELECT * FROM transfer WHERE id=(:id)")
    fun getTransferById(id: Int): LiveData<Transfer?>

    @Insert
    suspend fun addTransfer(transfer: Transfer)

    @Delete
    suspend fun deleteTransfer(transfer: Transfer)
}