package com.example.hello

import android.R
import android.util.Log

open class Person(val gender: String) {
    var name = ""
    var age = 0
    fun printInfo() {
        Log.e(name + "的年龄是", age.toString())
    }
}