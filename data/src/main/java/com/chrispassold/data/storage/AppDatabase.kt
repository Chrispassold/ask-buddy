package com.chrispassold.data.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.chrispassold.data.storage.dao.BankAccountDao
import com.chrispassold.data.storage.dao.CategoryDao
import com.chrispassold.data.storage.dao.TransactionDao
import com.chrispassold.data.storage.entities.BankAccountEntity
import com.chrispassold.data.storage.entities.CategoryEntity
import com.chrispassold.data.storage.entities.TransactionEntity
import com.chrispassold.data.storage.entities.typeconverters.BankAccountTypeConverter
import com.chrispassold.data.storage.entities.typeconverters.BigCentsConverter
import com.chrispassold.data.storage.entities.typeconverters.BigDecimalConverter
import com.chrispassold.data.storage.entities.typeconverters.IconTintConverter
import com.chrispassold.data.storage.entities.typeconverters.IconTypeConverter
import com.chrispassold.data.storage.entities.typeconverters.InstantConverter
import com.chrispassold.data.storage.entities.typeconverters.TransactionTypeConverter

@Database(
    entities = [BankAccountEntity::class, CategoryEntity::class, TransactionEntity::class],
    version = 1,
    exportSchema = false,
)
@TypeConverters(
    BigDecimalConverter::class,
    BigCentsConverter::class,
    InstantConverter::class,
    TransactionTypeConverter::class,
    BankAccountTypeConverter::class,
    IconTintConverter::class,
    IconTypeConverter::class,
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun bankAccountDao(): BankAccountDao
    abstract fun categoryDao(): CategoryDao
    abstract fun transactionDao(): TransactionDao
}