package com.example.hello

import android.util.Log
import kotlin.math.max

class kotlin1 {
    //变量
    fun fun1() {
        val a = 10 //自己进行类型推导
        val b: Int = 5//声明类型
        Log.e("a=", a.toString())
        Log.e("b=", b.toString())


    }

    //函数
    fun largerNumber(param1: Int, param2: Int): Int {
        return max(param1, param2)
    }

    //当函数只有一行代码时可以不写函数体，直接写等号连接
    fun largerNumber2(param1: Int, param2: Int): Int = max(param1, param2)

    //因为kotlin的类型推导机制，等号右侧的值的类型已经确定了，所以在左侧就不需要返回值类型了
    fun largerNumber3(param1: Int, param2: Int) = max(param1, param2)

    //程序的逻辑控制
    //1.if
    //基础用法
    fun largerNumber4(param1: Int, param2: Int): Int {
        var value = 0;
        if (param1 > param2) {
            value = param1
        } else {
            value = param2
        }
        return value
    }

    //特色用法
    fun largerNumber5(param1: Int, param2: Int): Int {
        val value = if (param1 > param2) {
            param1
        } else {
            param2
        }
        return value
    }

    //进一步精简可以获得
    fun largerNumber6(param1: Int, param2: Int): Int {
        return if (param1 > param2) {
            param1
        } else {
            param2
        }
    }

    //再进一步结合前边的语法糖可以得到
    fun largerNumber7(param1: Int, param2: Int) = if (param1 > param2) {
        param1
    } else {
        param2
    }


    //2.when(类比switch)
    //if写法
    fun getScore1(name: String) = if (name == "tom") {
        70
    } else if (name == "jack") {
        80
    } else if (name == "lily") {
        90
    } else {
        0
    }

    //when写法
    fun getScore2(name: String) = when (name) {
        "tom" -> 70
        "jack" -> 80
        "Lily" -> 90
        else -> 0
    }

    //when的类型匹配
    fun checkNumber(num: Number) {
        when (num) {
            is Int, is Short, is Long -> Log.e("检查结果", "合法")
            else -> Log.e("检查结果", "不合法")
        }
    }

    //when的另一种写法,这种写法可以解决不是精确匹配时带参数的when不能实现的问题，更加灵活
    fun getScore3(name: String) = when {
        name.startsWith("tom") -> 80
        else -> 90
    }

    //循环语句
    //while循环与java一致
    fun getSingle(param1: Int): Int {
        var count = 0
        var number = 0
        while (number <= param1) {
            if (number % 2 == 1) {
                count++

            }
            number++
        }
        return count
    }

    //kotlin的区间
    fun rangeTest() {
        //..表示左闭右闭区间
        val range = 0..10
        for (i in 0..10) {
            Log.e("i", i.toString())
        }
        //until表示左闭右开区间
        for (i in 0 until 10 step 2) {
            Log.e("i", i.toString())
        }
        //downTo降序左闭右闭区间
        for (i in 10 downTo 0 step 2) {
            Log.e("i", i.toString())
        }
    }


    //类和对象
    fun createPerson() {
        val p = Person("男")
        p.name = "zs"
        p.age = 20
        p.printInfo()
    }
    //类的继承 与java不同，kotlin的类默认是不可继承的，相当于默认使用final修饰，想要继承需要使用open进行修饰
}