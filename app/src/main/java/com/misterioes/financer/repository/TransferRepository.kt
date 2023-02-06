package com.misterioes.financer.repository

import androidx.lifecycle.LiveData
import com.misterioes.financer.dao.dao.TransferDao
import com.misterioes.financer.dao.entity.Transfer
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TransferRepository @Inject constructor(private val transferDao: TransferDao) {
    fun getAllTransfers(): LiveData<List<Transfer>> {
        return transferDao.getAllTransfers()
    }

    fun getTransferById(id: Int): LiveData<Transfer?> {
        return transferDao.getTransferById(id)
    }

    suspend fun addTransfer(transfer: Transfer) {
        transferDao.addTransfer(transfer)
    }

    suspend fun deleteTransfer(transfer: Transfer) {
        transferDao.deleteTransfer(transfer)
    }
}