package com.example.mvvmcoffee.data.database

interface DAO<T> {
    fun save(entity: T): Unit;
    fun update(entity: T): Unit;
    fun delete(id: Int): Unit;
    suspend fun findAll(): Array<T>;
    suspend fun findById(id: Int): T;
}