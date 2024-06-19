package com.example.mvvmcoffee.data.database

import android.util.Log
import com.example.mvvmcoffee.data.dto.IngredientDTO
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

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

    override suspend fun findAll(): Array<IngredientDTO> {
        TODO("Not yet implemented")
    }

    override suspend fun findById(id: String): Result<IngredientDTO> {
        TODO("Not yet implemented")
    }
}