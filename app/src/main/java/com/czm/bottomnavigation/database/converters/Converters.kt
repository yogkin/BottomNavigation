
package com.czm.bottomnavigation.database.converters

import androidx.room.TypeConverter
import java.math.BigDecimal
import java.util.*

/**
 * 数据库类型转换器
 *
 * @author Bakumon https://bakumon.me
 */
object Converters {
    @JvmStatic
    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return if (value == null) null else Date(value)
    }

    @JvmStatic
    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time
    }

    @JvmStatic
    @TypeConverter
    fun stringToBig(intDecimal: Long): BigDecimal {
        return BigDecimal(intDecimal)
    }

    @JvmStatic
    @TypeConverter
    fun bigToString(bigDecimal: BigDecimal): Long {
        return bigDecimal.toLong()
    }
}
