package com.example.mvvmcoffee.data.dao

interface DAO<T> {
    fun save(t: T): Unit;
    fun update(t: T): Unit;
    fun delete(t: T): Unit;
    fun findAll(): Array<T>;
    fun findById(id: Int): T;
}