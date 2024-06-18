package com.example.mvvmcoffee.data.dto

data class IngredientDTO(
    private val id: Long,
    private val name: String,
    private val quantity: Int, // Quantidade em estoque
    private val unit: String // Unidade de medida, como "grams", "ml", etc.
) {
}