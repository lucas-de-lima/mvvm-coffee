package com.example.mvvmcoffee.data.dto

data class ProductDTO(
     var id: String,
     var name: String,
     var description: String,
     var category: String,
     var ingredientIds: List<Long>, // Lista de IDs dos ingredientes
     var price: Double
) {
}