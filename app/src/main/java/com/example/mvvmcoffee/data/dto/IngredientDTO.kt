package com.example.mvvmcoffee.data.dto

data class IngredientDTO(
    private val id: Long? = null,
    private val name: String? = null,
    private val quantity: Int? = null, // Quantidade em estoque
    private val unit: String? = null // Unidade de medida, como "grams", "ml", etc.
) {
}