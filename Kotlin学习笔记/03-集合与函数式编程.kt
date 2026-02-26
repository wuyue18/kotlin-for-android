package com.example.hello

import android.util.Log

/**
 * Kotlin集合与函数式编程学习笔记
 * 包含：List、Set、Map集合操作，Lambda表达式，函数式API等
 */

class CollectionsAndFunctionalProgramming {
    
    // ========== List集合 ==========
    
    fun listOperations() {
        // ========== 创建List ==========
        
        // 传统Java方式
        val list1 = ArrayList<String>()
        list1.add("apple")
        list1.add("banana")
        list1.add("orange")
        
        // Kotlin方式 - listOf创建不可变集合
        val list2 = listOf<String>("apple", "banana", "orange")
        
        // mutableListOf创建可变集合
        val list3 = mutableListOf<String>("apple", "banana", "orange")
        list3.add("Watermelon")
        
        // ========== 遍历List ==========
        Log.e("=== List遍历 ===", "")
        
        // for-in遍历
        for (fruit in list2) {
            Log.e("水果", fruit)
        }
        
        // forEach遍历
        list2.forEach { fruit ->
            Log.e("forEach", fruit)
        }
        
        // 带索引遍历
        list2.forEachIndexed { index, fruit ->
            Log.e("带索引遍历", "$index: $fruit")
        }
        
        // ========== List操作 ==========
        
        // 获取元素
        val first = list2.first()
        val last = list2.last()
        val elementAt = list2.elementAt(1)
        
        Log.e("List元素", "第一个：$first，最后一个：$last，第二个：$elementAt")
        
        // 查找
        val hasApple = list2.contains("apple")
        val findResult = list2.find { it.startsWith("a") }
        
        Log.e("List查找", "包含apple：$hasApple，查找结果：$findResult")
        
        // 过滤
        val filteredList = list2.filter { it.length > 5 }
        Log.e("List过滤", "长度大于5的水果：$filteredList")
        
        // 映射转换
        val upperList = list2.map { it.uppercase() }
        val lengthList = list2.map { it.length }
        
        Log.e("List映射", "大写：$upperList")
        Log.e("List映射", "长度：$lengthList")
        
        // 排序
        val sortedList = list3.sorted()
        val sortedByLength = list3.sortedBy { it.length }
        
        Log.e("List排序", "字母排序：$sortedList")
        Log.e("List排序", "按长度排序：$sortedByLength")
    }
    
    // ========== Set集合 ==========
    
    fun setOperations() {
        // Set的使用方法与List类似，只是不允许重复元素
        
        // 不可变Set
        val set1 = setOf<String>("apple", "banana", "orange", "apple") // apple重复，只会保留一个
        Log.e("Set", "自动去重：$set1")
        
        // 可变Set
        val set2 = mutableSetOf<String>("apple", "banana")
        set2.add("orange")
        set2.add("apple") // 重复添加无效
        
        Log.e("Set操作", "最终Set：$set2")
        
        // Set特有操作
        val union = set1.union(set2) // 并集
        val intersection = set1.intersect(set2) // 交集
        
        Log.e("Set运算", "并集：$union")
        Log.e("Set运算", "交集：$intersection")
    }
    
    // ========== Map集合 ==========
    
    fun mapOperations() {
        // ========== 创建Map ==========
        
        // 传统Java方式
        val map1 = HashMap<String, Int>()
        map1.put("apple", 1) // Kotlin不推荐这种写法
        map1["banana"] = 2 // 推荐使用数组语法
        
        // Kotlin方式
        val map2 = mapOf<String, Int>("apple" to 1, "banana" to 2, "orange" to 3)
        val map3 = mutableMapOf<String, Int>("apple" to 1, "banana" to 2)
        map3["Watermelon"] = 3
        
        // ========== Map遍历 ==========
        Log.e("=== Map遍历 ===", "")
        
        // 遍历键值对
        for ((fruit, number) in map3) {
            Log.e("Map遍历", "$fruit: $number")
        }
        
        // forEach遍历
        map3.forEach { (fruit, number) ->
            Log.e("Map forEach", "$fruit = $number")
        }
        
        // ========== Map操作 ==========
        
        // 获取值
        val appleCount = map1["apple"]
        val bananaCount = map1.getOrDefault("banana", 0)
        val orangeCount = map1.getOrElse("orange") { 0 }
        
        Log.e("Map取值", "apple: $appleCount, banana: $bananaCount, orange: $orangeCount")
        
        // 检查键或值
        val hasApple = map1.containsKey("apple")
        val hasValue1 = map1.containsValue(1)
        
        Log.e("Map检查", "包含apple键：$hasApple，包含值1：$hasValue1")
        
        // 过滤
        val filteredMap = map3.filter { (fruit, number) -> fruit.startsWith("a") }
        Log.e("Map过滤", "以a开头的水果：$filteredMap")
        
        // 映射转换
        val fruitNames = map3.keys
        val fruitNumbers = map3.values
        val upperKeyMap = map3.mapKeys { it.key.uppercase() }
        val doubledValueMap = map3.mapValues { it.value * 2 }
        
        Log.e("Map映射", "水果名：$fruitNames")
        Log.e("Map映射", "数量：$fruitNumbers")
        Log.e("Map映射", "大写键：$upperKeyMap")
        Log.e("Map映射", "双倍值：$doubledValueMap")
    }
    
    // ========== Lambda表达式 ==========
    
    fun lambdaBasics() {
        Log.e("=== Lambda表达式 ===", "")
        
        // Lambda标准结构：{参数名1: 参数类型, 参数名2: 参数类型 -> 函数体}
        
        // 基本Lambda
        val sum = { a: Int, b: Int -> a + b }
        Log.e("Lambda", "1 + 2 = ${sum(1, 2)}")
        
        // 如果Lambda是函数的最后一个参数，可以移到括号外
        val list = listOf(1, 2, 3, 4, 5)
        val doubled = list.map { number -> number * 2 }
        Log.e("Lambda", "翻倍：$doubled")
        
        // 如果Lambda只有一个参数，可以用it代替
        val squared = list.map { it * it }
        Log.e("Lambda", "平方：$squared")
        
        // 多行Lambda
        val processed = list.map { number ->
            val temp = number * 2
            temp + 1
        }
        Log.e("Lambda", "处理后：$processed")
    }
    
    // ========== 函数式API ==========
    
    fun functionalAPIs() {
        val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        val words = listOf("kotlin", "java", "android", "development")
        
        Log.e("=== 函数式API ===", "")
        
        // filter - 过滤
        val evenNumbers = numbers.filter { it % 2 == 0 }
        Log.e("filter", "偶数：$evenNumbers")
        
        // map - 转换
        val wordLengths = words.map { it.length }
        Log.e("map", "单词长度：$wordLengths")
        
        // flatMap - 扁平化映射
        val sentence = listOf("hello world", "kotlin android")
        val wordsList = sentence.flatMap { it.split(" ") }
        Log.e("flatMap", "单词列表：$wordsList")
        
        // reduce - 归约
        val sum = numbers.reduce { acc, num -> acc + num }
        Log.e("reduce", "总和：$sum")
        
        // fold - 折叠（带初始值）
        val product = numbers.fold(1) { acc, num -> acc * num }
        Log.e("fold", "乘积：$product")
        
        // all - 所有元素都满足条件
        val allPositive = numbers.all { it > 0 }
        Log.e("all", "都是正数：$allPositive")
        
        // any - 至少一个元素满足条件
        val anyEven = numbers.any { it % 2 == 0 }
        Log.e("any", "有偶数：$anyEven")
        
        // none - 没有元素满足条件
        val noneNegative = numbers.none { it < 0 }
        Log.e("none", "没有负数：$noneNegative")
        
        // count - 满足条件的元素个数
        val evenCount = numbers.count { it % 2 == 0 }
        Log.e("count", "偶数个数：$evenCount")
        
        // find - 查找第一个满足条件的元素
        val firstEven = numbers.find { it % 2 == 0 }
        Log.e("find", "第一个偶数：$firstEven")
        
        // first/last - 获取第一个/最后一个元素
        val first = numbers.first { it > 5 }
        val last = numbers.last { it < 10 }
        Log.e("first/last", "第一个大于5的：$first，最后一个小于10的：$last")
        
        // sortedBy/sortedByDescending - 排序
        val sortedByLength = words.sortedBy { it.length }
        val sortedByLengthDesc = words.sortedByDescending { it.length }
        Log.e("sortedBy", "按长度升序：$sortedByLength")
        Log.e("sortedBy", "按长度降序：$sortedByLengthDesc")
        
        // groupBy - 分组
        val groupedByLength = words.groupBy { it.length }
        Log.e("groupBy", "按长度分组：$groupedByLength")
        
        // associate - 转换为Map
        val wordToLength = words.associate { it to it.length }
        Log.e("associate", "单词到长度：$wordToLength")
    }
    
    // ========== 集合操作链式调用 ==========
    
    fun chainedOperations() {
        val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        
        Log.e("=== 链式调用 ===", "")
        
        // 复杂的链式操作示例
        val result = numbers
            .filter { it % 2 == 0 }           // 过滤偶数
            .map { it * it }                  // 平方
            .filter { it > 10 }               // 大于10
            .sorted()                         // 排序
            .take(3)                          // 取前3个
        
        Log.e("链式调用结果", "$result")
        
        // 另一个示例：处理字符串列表
        val text = listOf("Hello", "World", "Kotlin", "Android", "Development")
        
        val processedText = text
            .filter { it.length > 4 }         // 长度大于4
            .map { it.lowercase() }           // 转小写
            .sortedBy { it }                  // 按字母排序
            .joinToString(", ", "[", "]")     // 连接成字符串
        
        Log.e("文本处理", processedText)
    }
    
    // ========== 空安全与集合 ==========
    
    fun nullSafetyWithCollections() {
        Log.e("=== 空安全与集合 ===", "")
        
        // 可空类型集合
        val nullableList: List<String?> = listOf("apple", null, "banana", null)
        
        // 处理可空元素
        val nonNullList = nullableList.filterNotNull()
        Log.e("过滤null", "$nonNullList")
        
        // mapNotNull - 过滤掉null并转换
        val lengths = nullableList.mapNotNull { it?.length }
        Log.e("长度列表", "$lengths")
        
        // 安全调用操作
        val safeGet = nullableList.getOrNull(10) // 安全获取，越界返回null
        Log.e("安全获取", "索引10的元素：$safeGet")
    }
}
