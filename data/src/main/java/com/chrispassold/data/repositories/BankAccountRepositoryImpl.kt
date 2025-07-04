package com.chrispassold.data.repositories

import com.chrispassold.data.repositories.datasources.bankaccount.BankAccountLocalDataSource
import com.chrispassold.domain.models.BankAccount
import com.chrispassold.domain.repositories.BankAccountRepository
import javax.inject.Inject

class BankAccountRepositoryImpl @Inject constructor(
    private val bankAccountLocalDataSource: BankAccountLocalDataSource,
) : BankAccountRepository {
    override suspend fun insert(bankAccount: BankAccount) {
        bankAccountLocalDataSource.insert(bankAccount)
    }

    override suspend fun update(bankAccount: BankAccount) {
        bankAccountLocalDataSource.update(bankAccount)
    }

    override suspend fun delete(id: String) {
        bankAccountLocalDataSource.delete(id)
    }

    override suspend fun getAll(): List<BankAccount> {
        return bankAccountLocalDataSource.getAll()
    }

    override suspend fun get(id: String): BankAccount? {
        return bankAccountLocalDataSource.get(id)
    }
}