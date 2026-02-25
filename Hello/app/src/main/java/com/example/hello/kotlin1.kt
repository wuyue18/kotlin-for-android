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


    //集合
    //list
    fun listMethod(){
        //常规方案
        val  list1 = ArrayList<String>()
        list1.add("apple")
        list1.add("banana")
        list1.add("orange")
        //kotlin方式
        //listof 创建的集合是不可变的
        val list2 = listOf<String>("apple","banana","orange")
        //mutableListOf创建的集合是可变的
        val list3 = mutableListOf<String>("apple","banana","orange")
        list3.add("Watermelon")

        for (fruit in list2){
            Log.e("fruit",fruit)
        }
    }
    //set的方法都是和list一样的只是把list替换成map
    fun mapMethod(){
        val map1 = HashMap<String, Int>()
        map1.put("apple",1)//kotlin不建议这种写法
        map1["apple"] = 1
        //同样可以这样取数
        val apple = map1["apple"]
        //map同样有mapOf和mutableMapOf()
        val  map2 = mapOf<String, Int>("apple" to 1,"banana" to 2)
        val  map3 = mutableMapOf<String, Int>("apple" to 1,"banana" to 2)
        map3["Watermelon"] = 3
        //map同样可以使用for in遍历
        for ((fruit,number) in map3){
            Log.e(fruit,number.toString())
        }


    }
    //集合的函数式api与Lambda表达式
    fun lambdaMethod(){
        //标准结构：{参数名1: 参数类型, 参数名2: 参数类型 -> 函数体}
    }


}