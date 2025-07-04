package com.chrispassold.domain.usecases.category

import com.chrispassold.core.resultWithContext
import com.chrispassold.domain.models.Category
import com.chrispassold.domain.models.IconTint
import com.chrispassold.domain.models.IconType
import com.chrispassold.domain.models.TransactionType
import com.chrispassold.domain.repositories.CategoryRepository
import com.chrispassold.domain.repositories.UserRepository
import java.util.UUID
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers

class CreateCategoryUseCase @Inject constructor(
    private val categoryRepository: CategoryRepository,
    private val userRepository: UserRepository,
) {

    data class Params(
        val name: String,
        val image: IconType?,
        val color: IconTint?,
        val type: TransactionType,
        val subCategories: List<SubCategory> = emptyList(),
    ) {
        data class SubCategory(
            val name: String,
        )
    }

    suspend fun invoke(params: Params): Result<Unit> = resultWithContext(Dispatchers.IO) {
        require(params.name.isNotBlank()) { "Name cannot be empty" }
        val user = userRepository.getCurrentUser() ?: error("User not logged in")
        val insertedId = UUID.randomUUID().toString()
        val category = Category(
            id = insertedId,
            name = params.name,
            image = params.image ?: IconType.Generic,
            color = params.color ?: IconTint.DEFAULT,
            type = params.type,
            userId = user.id,
            parentCategoryId = null,
        )
        categoryRepository.insert(category)
        params.subCategories.forEach { subCategory ->
            categoryRepository.insert(
                category.copy(
                    id = UUID.randomUUID().toString(),
                    name = subCategory.name,
                    parentCategoryId = insertedId,
                )
            )
        }
    }

}
