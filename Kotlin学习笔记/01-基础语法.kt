package com.example.hello

import android.util.Log
import kotlin.math.max

/**
 * Kotlin基础语法学习笔记
 * 包含：变量、函数、条件语句、循环等基础概念
 */

class BasicSyntax {
    
    // ========== 变量声明 ==========
    fun variableDeclaration() {
        // val - 不可变变量（类似final）
        val a = 10 // 类型推导
        val b: Int = 5 // 显式声明类型
        
        // var - 可变变量
        var c = 20
        c = 30 // 可以重新赋值
        
        Log.e("变量示例", "a=$a, b=$b, c=$c")
    }
    
    // ========== 函数定义 ==========
    
    // 标准函数定义
    fun largerNumber(param1: Int, param2: Int): Int {
        return max(param1, param2)
    }
    
    // 单行函数 - 可以省略函数体
    fun largerNumber2(param1: Int, param2: Int): Int = max(param1, param2)
    
    // 类型推导 - 返回类型可以省略
    fun largerNumber3(param1: Int, param2: Int) = max(param1, param2)
    
    // ========== 条件语句 ==========
    
    // if语句 - 传统写法
    fun largerNumber4(param1: Int, param2: Int): Int {
        var value = 0
        if (param1 > param2) {
            value = param1
        } else {
            value = param2
        }
        return value
    }
    
    // if语句 - 表达式写法
    fun largerNumber5(param1: Int, param2: Int): Int {
        val value = if (param1 > param2) {
            param1
        } else {
            param2
        }
        return value
    }
    
    // if表达式 - 直接返回
    fun largerNumber6(param1: Int, param2: Int): Int {
        return if (param1 > param2) param1 else param2
    }
    
    // if表达式 + 类型推导
    fun largerNumber7(param1: Int, param2: Int) = if (param1 > param2) param1 else param2
    
    // ========== when语句（类似switch） ==========
    
    // if链式写法
    fun getScore1(name: String) = if (name == "tom") {
        70
    } else if (name == "jack") {
        80
    } else if (name == "lily") {
        90
    } else {
        0
    }
    
    // when标准写法
    fun getScore2(name: String) = when (name) {
        "tom" -> 70
        "jack" -> 80
        "lily" -> 90
        else -> 0
    }
    
    // when类型匹配
    fun checkNumber(num: Number) {
        when (num) {
            is Int, is Short, is Long -> Log.e("检查结果", "合法整数")
            is Float, is Double -> Log.e("检查结果", "合法浮点数")
            else -> Log.e("检查结果", "不合法数字")
        }
    }
    
    // when无参数写法 - 更灵活的条件判断
    fun getScore3(name: String) = when {
        name.startsWith("tom") -> 80
        name.startsWith("jack") -> 85
        else -> 90
    }
    
    // ========== 循环语句 ==========
    
    // while循环 - 与Java一致
    fun countOddNumbers(max: Int): Int {
        var count = 0
        var number = 0
        while (number <= max) {
            if (number % 2 == 1) {
                count++
            }
            number++
        }
        return count
    }
    
    // ========== Kotlin区间 ==========
    
    fun rangeTest() {
        // .. 表示左闭右闭区间 [0, 10]
        val range = 0..10
        for (i in 0..10) {
            Log.e("闭区间", "i=$i")
        }
        
        // until 表示左闭右开区间 [0, 10)
        for (i in 0 until 10) {
            Log.e("开区间", "i=$i")
        }
        
        // step 步长
        for (i in 0 until 10 step 2) {
            Log.e("步长2", "i=$i")
        }
        
        // downTo 降序左闭右闭区间
        for (i in 10 downTo 0 step 2) {
            Log.e("降序", "i=$i")
        }
    }
    
    // ========== 字符串模板 ==========
    
    fun stringTemplate() {
        val name = "张三"
        val age = 25
        // $变量名
        Log.e("字符串模板", "姓名：$name，年龄：$age")
        // ${表达式}
        Log.e("表达式", "明年年龄：${age + 1}")
    }
}
