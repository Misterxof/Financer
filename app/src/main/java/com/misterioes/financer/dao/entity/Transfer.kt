package com.misterioes.financer.dao.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Transfer(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var amount: Int,
    var description: String,
    var currency: String,
    var isBill: Boolean,
    var date: Date
)