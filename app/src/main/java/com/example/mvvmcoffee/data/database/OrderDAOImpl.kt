package com.example.mvvmcoffee.data.database

import android.content.ContentValues.TAG
import android.util.Log
import com.example.mvvmcoffee.data.dto.OrderDTO
import com.google.firebase.Firebase
import com.google.firebase.firestore.SetOptions
import com.google.firebase.firestore.firestore
import kotlinx.coroutines.tasks.await


class OrderDAOImpl : OrderDAO {
    private val db = Firebase.firestore

    override fun save(entity: OrderDTO) {
        db.collection("orders")
            .document(entity.id!!)
            .set(entity)
            .addOnSuccessListener { documentReference ->
                Log.d(TAG, "Document added with ID: ${entity.id}")
            }
            .addOnFailureListener { e ->
                Log.w(TAG, "Error adding document: $e")
            }
    }

    override fun update(entity: OrderDTO) {
        db.collection("orders")
            .document(entity.id!!)
            .set(entity, SetOptions.merge())
            .addOnSuccessListener { documentReference ->
                Log.d(TAG, "Document updated with ID: ${entity.id}")
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

    override suspend fun findById(id: String): Result<OrderDTO> {
        return try {
            val orderDTO = db.collection("orders")
                .document(id)
                .get()
                .await()
                .toObject(OrderDTO::class.java)
                ?: return Result.failure(NoSuchElementException("Order with id $id not found"))
            Result.success(orderDTO)
        } catch (e: Exception) {
            Log.w(TAG, "Error getting document", e)
            Result.failure(e)
        }
    }
}