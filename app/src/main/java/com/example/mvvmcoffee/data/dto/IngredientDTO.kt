package com.example.mvvmcoffee.data.dto

data class IngredientDTO(
    var id: String? = null,
    var name: String? = null,
    var quantity: Int? = null, // Quantidade em estoque
    var unit: String? = null // Unidade de medida, como "grams", "ml", etc.
) {
}