package com.example.mvvmcoffee.data.database

import android.content.ContentValues.TAG
import android.util.Log
import com.example.mvvmcoffee.data.dto.OrderDTO
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

class OrderDAOImpl : OrderDAO {
    private val db = Firebase.firestore

    override fun save(order: OrderDTO) {
        db.collection("orders")
            .add(order)
            .addOnSuccessListener { documentReference ->
                Log.d(TAG,"Document added with ID: ${documentReference.id}")
            }
            .addOnFailureListener { e ->
                Log.w(TAG,"Error adding document: $e")
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