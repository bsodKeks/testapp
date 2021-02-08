package com.als.myapplication.domain

import kotlin.math.abs

class TextHelper {
    companion object{
        /**
         * Возвращает текст для количества объектов
         *
         * @param count количество объеков
         * @param form1 текст для одного объекта(кровать)
         * @param form2 текст для двух объектов(кровати)
         * @param form5 текст для 5 объектов(кроватей)
         */
        fun getSuffiks(count: Int, form1: String, form2: String, form5: String): String {
            val y = abs(count) % 100
            val yy = y % 10
            if (y in 11..19)
                return "$count $form5 "
            if (yy in 2..4)
                return "$count $form2 "
            if (yy == 1)
                return "$count $form1 "
            return "$count $form5 "
        }
    }
}