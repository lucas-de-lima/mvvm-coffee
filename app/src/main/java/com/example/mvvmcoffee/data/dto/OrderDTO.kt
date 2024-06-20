package com.example.mvvmcoffee.data.dto

import com.example.mvvmcoffee.enums.OrderStatusEnum
import com.example.mvvmcoffee.enums.PaymentStatusEnum
import java.util.Date

data class OrderDTO(
    var id: String? = null,
    var customerName: String? = null,
    var orderItems: List<OrderItemDTO>? = null,
    var totalAmount: Double? = null,
    var paymentStatus: PaymentStatusEnum? = null,
    var specialInstructions: String? = null,
    var orderDate: Date? = null,
    var orderStatus: OrderStatusEnum? = null
) {
}