package com.example.mvvmcoffee.data.dao

interface DAO<T> {
    fun save(entity: T): Unit;
    fun update(entity: T): Unit;
    fun delete(id: Int): Unit;
    fun findAll(): Array<T>;
    fun findById(id: Int): T;
}