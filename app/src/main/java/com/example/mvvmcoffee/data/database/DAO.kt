package com.example.mvvmcoffee.data.database

interface DAO<T> {
    fun save(entity: T): Unit;
    fun update(entity: T): Unit;
    fun delete(id: String): Unit;
    suspend fun findAll(): Result<List<T>>;
    suspend fun findById(id: String): Result<T>;
}