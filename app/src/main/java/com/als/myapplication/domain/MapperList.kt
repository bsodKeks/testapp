package com.als.myapplication.domain

interface MapperList<From, To> {
    fun map(from: List<From>): List<To>
}