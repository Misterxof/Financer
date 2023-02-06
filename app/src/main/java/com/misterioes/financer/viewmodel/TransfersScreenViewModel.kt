package com.misterioes.financer.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.*
import com.misterioes.financer.dao.entity.Transfer
import com.misterioes.financer.repository.TransferRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TransfersScreenViewModel @Inject constructor(private val transferRepository: TransferRepository) : ViewModel(){
    var transfersList:LiveData<List<Transfer>> = transferRepository.getAllTransfers()

    fun addTransfer(transfer: Transfer) {
        viewModelScope.launch {
            transferRepository.addTransfer(transfer)
        }
    }

    fun deleteTransfer(transfer: Transfer){
        viewModelScope.launch {
            transferRepository.deleteTransfer(transfer)
        }
    }
}