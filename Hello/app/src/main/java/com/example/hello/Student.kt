package com.example.hello

import android.util.Log

//类后边接上（）就是主构造方法，主构造方法中声明变量就相当于在类里声明了属性
//继承其他类时必须调用父类的主构造函数
//这里gender没加var是因为他已经是父类的属性了，再加声明就相当于在子类又声明了属性，重复了
class Student(var grade: String, gender: String) : Person(gender) {
    init {
        Log.e("年级", grade)
    }
    //一个函数只能由一个主构造函数，但是可以有多个次构造函数，次构造函数必须直接或者间接调用主构造函数


    //这个函数调用了主构造函数，属于直接调用
    constructor(name: String, age: Int) : this("", "男") {
    }

    //这个函数调用了第一个次构造函数属于间接调用
    constructor() : this("", 0) {
    }


    //特殊情况
    //这里没有主构造函数，但是有次构造函数，父类的构造函数是无论如何都必须调用的，所以在次构造函数中执行super
    class Student : Person {
        constructor(name: String, age: Int) : super(name) {
        }
    }
}