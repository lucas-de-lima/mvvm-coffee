package com.example.mvvmcoffee.data.database

import android.util.Log
import com.example.mvvmcoffee.data.database.dao.IngredientDAO
import com.example.mvvmcoffee.data.dto.IngredientDTO
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import kotlinx.coroutines.tasks.await

class IngredientDAOImpl : IngredientDAO {
    private val db = Firebase.firestore

    override fun save(entity: IngredientDTO) {
        db.collection("ingredients")
            .document(entity.id!!)
            .set(entity)
            .addOnSuccessListener { documentReference ->
                Log.d("IngredientDAOImpl", "Document added with ID: ${entity.id}")
            }
            .addOnFailureListener { e ->
                Log.w("IngredientDAOImpl", "Error adding document: $e")
            }
    }

    override fun update(entity: IngredientDTO) {
        db.collection("ingredients")
            .document(entity.id!!)
            .set(entity)
            .addOnSuccessListener { documentReference ->
                Log.d("IngredientDAOImpl", "Document updated with ID: ${entity.id}")
            }
            .addOnFailureListener { e ->
                Log.w("IngredientDAOImpl", "Error updating document: $e")
            }
    }

    override fun delete(id: String) {
        db.collection("ingredients")
            .document(id)
            .delete()
    }

    override suspend fun findAll(): Result<List<IngredientDTO>> {
        return try {
            val ingredientsResult = db.collection("ingredients")
                .get()
                .await().documents
                .map { document ->
                    document.toObject(IngredientDTO::class.java)
                        ?: return Result.failure(NoSuchElementException("Order with id ${document.id} not found"))
                }
            Result.success(ingredientsResult)
        } catch (e: Exception) {
            Log.w("IngredientDAOImpl", "Error getting documents", e)
            Result.failure(e)
        }
    }

    override suspend fun findById(id: String): Result<IngredientDTO> {
        return try {
            val ingredientDTO = db.collection("ingredients")
                .document(id)
                .get()
                .await()
                .toObject(IngredientDTO::class.java)
                ?: return Result.failure(NoSuchElementException("Order with id $id not found"))
            Result.success(ingredientDTO)
        } catch (e: Exception) {
            Log.w("IngredientDAOImpl", "Error getting document", e)
            Result.failure(e)
        }
    }
}