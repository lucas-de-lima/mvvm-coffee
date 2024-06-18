package com.example.mvvmcoffee.data.dto

data class ProductDTO(
    private val id: Long,
    private val name: String,
    private val description: String,
    private val category: String,
    private val ingredientIds: List<Long>, // Lista de IDs dos ingredientes
    private val price: Double
) {
}