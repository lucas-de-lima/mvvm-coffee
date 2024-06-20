package com.example.mvvmcoffee.data.dto

data class OrderItemDTO(
     var productId: String, // Referência ao ID do produto
     var quantity: Int,
     var amount: Double
) {
}