package com.example.mvvmcoffee.data.database

import android.content.ContentValues.TAG
import android.util.Log
import com.example.mvvmcoffee.data.dto.OrderDTO
import com.example.mvvmcoffee.enums.OrderStatusEnum
import com.example.mvvmcoffee.enums.PaymentStatusEnum
import com.google.firebase.Firebase
import com.google.firebase.firestore.SetOptions
import com.google.firebase.firestore.firestore
import kotlinx.coroutines.tasks.await
import java.util.Date


class OrderDAOImpl : OrderDAO {
    private val db = Firebase.firestore

    override fun save(entity: OrderDTO) {
        db.collection("orders")
            .document(entity.getId.toString())
            .set(entity)
            .addOnSuccessListener { documentReference ->
                Log.d(TAG, "Document added with ID: ${entity.getId}")
            }
            .addOnFailureListener { e ->
                Log.w(TAG, "Error adding document: $e")
            }
    }

    override fun update(entity: OrderDTO) {
        db.collection("orders")
            .document(entity.getId.toString())
            .set(entity, SetOptions.merge())
            .addOnSuccessListener { documentReference ->
                Log.d(TAG, "Document updated with ID: ${entity.getId}")
            }
            .addOnFailureListener { e ->
                Log.w(TAG, "Error updating document: $e")
            }
    }

    override fun delete(id: Int) {
        try {
            db.collection("orders")
                .document(id.toString())
                .delete()
        } catch (e: Exception) {
            Log.w(TAG, "Error deleting document", e)
        }
    }

    override suspend fun findAll(): Array<OrderDTO> {
        return try {
            db.collection("orders")
                .get()
                .await()
                .map { document ->
                    document.toObject(OrderDTO::class.java)
                }.toTypedArray()
        } catch (e: Exception) {
            Log.w(TAG, "Error getting documents", e)
            emptyArray()
        }
    }

    override suspend fun findById(id: Int): OrderDTO {
        return try {
            db.collection("orders")
                .document(id.toString())
                .get()
                .await()
                .toObject(OrderDTO::class.java)!!
        } catch (e: Exception) {
            Log.w(TAG, "Error getting document", e)
            OrderDTO(
                id = 0,
                customerName = "",
                orderItems = emptyList(),
                totalAmount = 0.0,
                paymentStatus = PaymentStatusEnum.CANCELED,
                specialInstructions = "",
                orderDate = Date(0),
                orderStatus = OrderStatusEnum.CANCELED
            )
        }
    }
}