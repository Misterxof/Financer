package com.misterioes.financer.dao

import androidx.room.TypeConverter
import java.util.*

class DaoTypeConverters {
    @TypeConverter
    fun fromDate(date: Date?): Long? {
        return date?.time
    }

    @TypeConverter
    fun toDate(millisSinceEpoch: Long?): Date?
    {
        return millisSinceEpoch?.let {
            Date(it)
        }
    }
}