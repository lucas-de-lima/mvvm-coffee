package com.example.mvvmcoffee.data.dto

data class OrderItemDTO(
    private val productId: Long, // Referência ao ID do produto
    private val quantity: Int,
    private val amount: Double
) {
}