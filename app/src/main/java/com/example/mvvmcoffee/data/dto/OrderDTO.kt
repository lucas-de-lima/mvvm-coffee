package com.example.mvvmcoffee.data.dto

import com.example.mvvmcoffee.enums.OrderStatusEnum
import com.example.mvvmcoffee.enums.PaymentStatusEnum
import java.util.Date

data class OrderDTO(
    private var _id: String? = null,
    private var _customerName: String? = null,
    private var _orderItems: List<OrderItemDTO>? = null,
    private var _totalAmount: Double? = null,
    private var _paymentStatus: PaymentStatusEnum? = null,
    private var _specialInstructions: String? = null,
    private var _orderDate: Date? = null,
    private var _orderStatus: OrderStatusEnum? = null
) {
    var id: String?
        get() = _id
        set(value) {
            _id = value
        }

    var customerName: String?
        get() = _customerName
        set(value) {
            _customerName = value
        }

    var orderItems: List<OrderItemDTO>?
        get() = _orderItems
        set(value) {
            _orderItems = value
        }

    var totalAmount: Double?
        get() = _totalAmount
        set(value) {
            _totalAmount = value
        }

    var paymentStatus: PaymentStatusEnum?
        get() = _paymentStatus
        set(value) {
            _paymentStatus = value
        }

    var specialInstructions: String?
        get() = _specialInstructions
        set(value) {
            _specialInstructions = value
        }

    var orderDate: Date?
        get() = _orderDate
        set(value) {
            _orderDate = value
        }

    var orderStatus: OrderStatusEnum?
        get() = _orderStatus
        set(value) {
            _orderStatus = value
        }
}