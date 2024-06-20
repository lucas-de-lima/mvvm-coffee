package com.example.mvvmcoffee.data.database


import android.content.ContentValues.TAG
import android.util.Log
import com.example.mvvmcoffee.data.dto.OrderDTO
import com.example.mvvmcoffee.data.dto.UserDTO
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import kotlinx.coroutines.tasks.await

class UserDAOImpl : UserDAO {
    private val db = Firebase.firestore

    override fun save(entity: UserDTO) {
        val user = hashMapOf(
            "id" to entity.getId,
            "name" to entity.getName
        )

        db.collection("users")
            .add(user)
            .addOnSuccessListener { documentReference ->
                Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
            }
            .addOnFailureListener { e ->
                Log.w(TAG, "Error adding document", e)
            }
    }

    override fun update(entity: UserDTO) {
        TODO("Not yet implemented")
    }

    override fun delete(id: String) {
        TODO("Not yet implemented")
    }

    override suspend fun findAll(): Result<List<UserDTO>> {
        val usersList = mutableListOf<UserDTO>()
//        return try {
//            val result = db.collection("users").get().await()
//            for (document in result) {
//                val id = document.data["id"]?.toString()?.toIntOrNull() ?: 0
//                val name = document.data["name"]?.toString() ?: ""
//                val user = UserDTO(id, name)
//                usersList.add(user)
//            }
//            usersList.toTypedArray()
//        } catch (e: Exception) {
//            e.printStackTrace()
//            emptyArray()
//        }
        TODO("Not yet implemented")
    }

    override suspend fun findById(id: String): Result<UserDTO> {
        TODO("Not yet implemented")
    }
}