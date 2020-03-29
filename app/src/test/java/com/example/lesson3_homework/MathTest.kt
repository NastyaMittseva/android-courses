package com.example.lesson3_homework

import org.junit.Assert
import org.junit.Test

class MathTest {
    @Test
    fun addition_isCorrect() {
        Assert.assertEquals(4, 2 + 2)
    }

    @Test
    fun divideTest() {
        var i = 4
        i /= 2
        Assert.assertEquals(2, i)
    }
}