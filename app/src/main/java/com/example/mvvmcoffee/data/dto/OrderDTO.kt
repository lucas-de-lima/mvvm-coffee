package com.example.mvvmcoffee.data.dto

import com.example.mvvmcoffee.enums.OrderStatusEnum
import com.example.mvvmcoffee.enums.PaymentStatusEnum
import java.util.Date

data class OrderDTO(
    private val id: Int,
    private val customerName: String,
    private val orderItems: List<OrderItemDTO>,
    private val totalAmount: Double,
    private val paymentStatus: PaymentStatusEnum,
    private val specialInstructions: String,
    private val orderDate: Date,
    private val orderStatus: OrderStatusEnum
) {
    val getId: Int
        get() = id

    val getCustomerName: String
        get() = customerName

    val getOrderItems: List<OrderItemDTO>
        get() = orderItems

    val getTotalAmount: Double
        get() = totalAmount

    val getPaymentStatus: PaymentStatusEnum
        get() = paymentStatus

    val getSpecialInstructions: String
        get() = specialInstructions

    val getOrderDate: Date
        get() = orderDate

    val getOrderStatus: OrderStatusEnum
        get() = orderStatus

}