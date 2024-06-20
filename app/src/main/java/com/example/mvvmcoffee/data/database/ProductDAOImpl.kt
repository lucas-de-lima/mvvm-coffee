package com.example.mvvmcoffee.data.database

import android.util.Log
import com.example.mvvmcoffee.data.database.dao.ProductDAO
import com.example.mvvmcoffee.data.dto.ProductDTO
import com.google.firebase.Firebase
import com.google.firebase.firestore.SetOptions
import com.google.firebase.firestore.firestore
import kotlinx.coroutines.tasks.await

class ProductDAOImpl : ProductDAO {
    private val db = Firebase.firestore

    override fun save(entity: ProductDTO) {
        db.collection("products")
            .document(entity.id)
            .set(entity)
            .addOnSuccessListener {
                Log.d("ProductDAOImpl", "DocumentSnapshot added with ID: ${entity.id}")
            }
            .addOnFailureListener { e ->
                Log.w("ProductDAOImpl", "Error adding document", e)
            }
    }

    override fun update(entity: ProductDTO) {
        db.collection("products")
            .document(entity.id)
            .set(entity, SetOptions.merge())
            .addOnSuccessListener {
                Log.d("ProductDAOImpl", "DocumentSnapshot updated with ID: ${entity.id}")
            }
            .addOnFailureListener { e ->
                Log.w("ProductDAOImpl", "Error updating document", e)
            }
    }

    override fun delete(id: String) {
        db.collection("products")
            .document(id)
            .delete()
    }

    override suspend fun findAll(): Result<List<ProductDTO>> {
        return try {
            val productResults = db.collection("products")
                .get()
                .await()
                .map { document ->
                    document.toObject(ProductDTO::class.java)
                    return Result.failure(NoSuchElementException("Order with id ${document.id} not found"))
                }
            Result.success(productResults)
        } catch (e: Exception) {
            Log.w("ProductDAOImpl", "Error getting documents", e)
            Result.failure(e)
        }
    }

    override suspend fun findById(id: String): Result<ProductDTO> {
        return try {
            val product = db.collection("products")
                .document(id)
                .get()
                .await()
                .toObject(ProductDTO::class.java)
                ?: return Result.failure(NoSuchElementException("Order with id $id not found"))
            Result.success(product)
        } catch (e: Exception) {
            Log.w("ProductDAOImpl", "Error getting document", e)
            Result.failure(e)
        }
    }
}