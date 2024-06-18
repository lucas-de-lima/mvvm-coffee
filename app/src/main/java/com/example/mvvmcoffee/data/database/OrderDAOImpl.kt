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
        TODO("Not yet implemented")
    }

    override fun delete(id: Int) {
        TODO("Not yet implemented")
    }

    override suspend fun findAll(): Array<OrderDTO> {
        TODO("Not yet implemented")
    }

    override suspend fun findById(id: Int): OrderDTO {
        TODO("Not yet implemented")
    }
}