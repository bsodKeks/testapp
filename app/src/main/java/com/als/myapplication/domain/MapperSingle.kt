package com.als.myapplication.domain

interface MapperSingle<From, To> {
    fun map(from: From): To
}