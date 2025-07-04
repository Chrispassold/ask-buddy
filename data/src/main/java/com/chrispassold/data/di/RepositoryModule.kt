package com.chrispassold.data.di

import com.chrispassold.data.repositories.BankAccountRepositoryImpl
import com.chrispassold.data.repositories.CategoryRepositoryImpl
import com.chrispassold.data.repositories.TransactionRepositoryImpl
import com.chrispassold.data.repositories.UserRepositoryImpl
import com.chrispassold.domain.repositories.BankAccountRepository
import com.chrispassold.domain.repositories.CategoryRepository
import com.chrispassold.domain.repositories.TransactionRepository
import com.chrispassold.domain.repositories.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindUserRepository(
        userRepositoryImpl: UserRepositoryImpl,
    ): UserRepository

    @Binds
    abstract fun bindBankAccountRepository(
        bankAccountRepositoryImpl: BankAccountRepositoryImpl,
    ): BankAccountRepository

    @Binds
    abstract fun bindCategoryRepository(
        categoryRepositoryImpl: CategoryRepositoryImpl,
    ): CategoryRepository

    @Binds
    abstract fun bindTransactionRepository(
        transactionRepositoryImpl: TransactionRepositoryImpl,
    ): TransactionRepository

}