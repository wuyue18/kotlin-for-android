package com.example.hello

import android.util.Log

/**
 * Kotlin高级概念学习笔记
 * 包含：单例模式、空安全、扩展函数、高阶函数、协程基础等
 */

// ========== 单例模式 ==========

// object关键字会自动实现单例模式
object Singleton {
    private var instanceCount = 0
    
    fun singletonTest() {
        instanceCount++
        Log.e("单例测试", "这是第 $instanceCount 次调用")
    }
    
    // 单例对象可以有属性和方法
    val version = "1.0.0"
    
    fun getVersion(): String {
        return "Singleton version: $version"
    }
}

// 单例使用示例
fun singletonExample() {
    // 调用方式类似静态方法
    Singleton.singletonTest()
    Singleton.singletonTest()
    Log.e("版本信息", Singleton.getVersion())
}

// ========== 空安全 ==========

class NullSafetyExamples {
    
    fun nullSafetyBasics() {
        Log.e("=== 空安全基础 ===", "")
        
        // 可空类型声明
        val name: String? = "Kotlin"
        val nullName: String? = null
        
        // 安全调用操作符 ?.
        val length = name?.length
        Log.e("安全调用", "长度：$length")
        
        // 如果name为null，整个表达式返回null
        val result = nullName?.length
        Log.e("安全调用null", "结果：$result")
        
        // Elvis操作符 ?:
        val safeLength = name?.length ?: 0
        val safeNullLength = nullName?.length ?: 0
        Log.e("Elvis操作符", "安全长度：$safeLength, $safeNullLength")
        
        // 非空断言 !!
        try {
            val assertLength = name!!.length
            Log.e("非空断言", "断言长度：$assertLength")
            
            // 这会抛出NullPointerException
            val nullAssertLength = nullName!!.length
        } catch (e: NullPointerException) {
            Log.e("非空断言", "捕获异常：${e.message}")
        }
    }
    
    fun safeCasts() {
        Log.e("=== 安全类型转换 ===", "")
        
        val anyValue: Any = "Hello Kotlin"
        
        // 安全转换 as?
        val stringResult = anyValue as? String
        val intResult = anyValue as? Int
        
        Log.e("安全转换", "转String：$stringResult")
        Log.e("安全转换", "转Int：$intResult")
        
        // 使用Elvis操作符处理转换失败
        val length = (anyValue as? String)?.length ?: 0
        Log.e("转换+Elvis", "长度：$length")
    }
    
    fun let函数() {
        Log.e("=== let函数 ===", "")
        
        val name: String? = "Android"
        val nullName: String? = null
        
        // let函数只在不为null时执行
        name?.let { safeName ->
            Log.e("let函数", "处理非空值：$safeName，长度：${safeName.length}")
        }
        
        nullName?.let { safeName ->
            Log.e("let函数", "这里不会执行：$safeName")
        }
        
        // let也可以用于变量作用域控制
        val result = "Hello".let { greeting ->
            "$greeting World!"
        }
        Log.e("let作用域", result)
    }
    
    fun also函数() {
        Log.e("=== also函数 ===", "")
        
        val person = "Kotlin".also { name ->
            Log.e("also函数", "处理对象：$name")
        }
        
        Log.e("also结果", "原对象：$person")
        // also返回原对象，let返回lambda结果
    }
    
    fun run函数() {
        Log.e("=== run函数 ===", "")
        
        // run结合了let和also的特点
        val result = "Android".run { 
            Log.e("run函数", "处理：$this")
            this.length
        }
        
        Log.e("run结果", "返回值：$result")
    }
    
    fun apply函数() {
        Log.e("=== apply函数 ===", "")
        
        val stringBuilder = StringBuilder().apply {
            append("Hello")
            append(" ")
            append("Kotlin")
        }
        
        Log.e("apply结果", stringBuilder.toString())
        // apply返回配置后的对象本身
    }
}

// ========== 高阶函数 ==========

class HigherOrderFunctions {
    
    // 接受函数作为参数的高阶函数
    fun calculate(a: Int, b: Int, operation: (Int, Int) -> Int): Int {
        return operation(a, b)
    }
    
    // 返回函数的高阶函数
    fun createMultiplier(factor: Int): (Int) -> Int {
        return { number -> number * factor }
    }
    
    fun higherOrderExamples() {
        Log.e("=== 高阶函数示例 ===", "")
        
        // 使用lambda作为参数
        val sum = calculate(5, 3) { a, b -> a + b }
        val product = calculate(5, 3) { a, b -> a * b }
        val max = calculate(5, 3) { a, b -> if (a > b) a else b }
        
        Log.e("高阶函数", "和：$sum，积：$product，最大值：$max")
        
        // 使用函数引用
        val sum2 = calculate(5, 3, ::add)
        Log.e("函数引用", "和：$sum2")
        
        // 返回函数的使用
        val double = createMultiplier(2)
        val triple = createMultiplier(3)
        
        Log.e("返回函数", "翻倍：${double(10)}，三倍：${triple(10)}")
    }
    
    // 辅助函数
    private fun add(a: Int, b: Int): Int = a + b
}

// ========== 内联函数 ==========

// inline关键字可以减少lambda的开销
inline fun inlineExample(operation: (String) -> Unit) {
    Log.e("内联函数", "开始执行")
    operation("内联测试")
    Log.e("内联函数", "执行结束")
}

// noinline禁止内联某些参数
inline fun mixedInlineExample(noinline operation1: (String) -> Unit, operation2: (Int) -> Unit) {
    operation1("非内联")
    operation2(42)
}

fun inlineFunctionDemo() {
    Log.e("=== 内联函数示例 ===", "")
    
    inlineExample { message ->
        Log.e("lambda执行", message)
    }
    
    mixedInlineExample({ message ->
        Log.e("非内联lambda", message)
    }) { number ->
        Log.e("内联lambda", "数字：$number")
    }
}

// ========== 泛型 ==========

class GenericExamples<T> {
    private val items = mutableListOf<T>()
    
    fun add(item: T) {
        items.add(item)
    }
    
    fun get(index: Int): T = items[index]
    
    fun getAll(): List<T> = items.toList()
    
    // 泛型方法
    fun <R> map(transform: (T) -> R): List<R> {
        return items.map(transform)
    }
}

fun genericExamples() {
    Log.e("=== 泛型示例 ===", "")
    
    val stringContainer = GenericExamples<String>()
    stringContainer.add("Hello")
    stringContainer.add("Kotlin")
    
    val stringList = stringContainer.getAll()
    Log.e("泛型容器", "字符串列表：$stringList")
    
    val lengths = stringContainer.map { it.length }
    Log.e("泛型映射", "长度列表：$lengths")
    
    // 泛型约束
    fun <T : Number> calculateSum(a: T, b: T): Double {
        return a.toDouble() + b.toDouble()
    }
    
    val sum = calculateSum(3.14, 2.86)
    Log.e("泛型约束", "数字和：$sum")
}

// ========== 委托属性 ==========

import kotlin.properties.Delegates

class DelegatedProperties {
    
    // 延迟初始化
    val lazyValue: String by lazy {
        Log.e("lazy", "初始化lazy值")
        "这是延迟初始化的值"
    }
    
    // 可观察属性
    var observableValue: String by Delegates.observable("初始值") { property, oldValue, newValue ->
        Log.e("observable", "$oldValue -> $newValue")
    }
    
    // vetoable属性（可以否决赋值）
    var vetoableValue: Int by Delegates.vetoable(0) { property, oldValue, newValue ->
        Log.e("vetoable", "尝试：$oldValue -> $newValue")
        newValue > oldValue // 只允许增加值
    }
    
    fun delegatedPropertiesDemo() {
        Log.e("=== 委托属性示例 ===", "")
        
        // lazy属性第一次访问时初始化
        Log.e("lazy", "第一次访问：${lazyValue}")
        Log.e("lazy", "第二次访问：${lazyValue}")
        
        // observable属性变化时触发回调
        observableValue = "新值1"
        observableValue = "新值2"
        
        // vetoable属性可以拒绝某些赋值
        vetoableValue = 10  // 允许
        vetoableValue = 5   // 拒绝
        vetoableValue = 15  // 允许
        
        Log.e("vetoable", "最终值：$vetoableValue")
    }
}

// ========== 操作符重载 ==========

data class Point(val x: Int, val y: Int) {
    
    // 重载加法操作符
    operator fun plus(other: Point): Point {
        return Point(x + other.x, y + other.y)
    }
    
    // 重载减法操作符
    operator fun minus(other: Point): Point {
        return Point(x - other.x, y - other.y)
    }
    
    // 重载一元操作符
    operator fun unaryMinus(): Point {
        return Point(-x, -y)
    }
    
    // 重载equals操作符
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Point) return false
        return x == other.x && y == other.y
    }
    
    override fun hashCode(): Int {
        return 31 * x + y
    }
}

fun operatorOverloadingDemo() {
    Log.e("=== 操作符重载示例 ===", "")
    
    val p1 = Point(3, 4)
    val p2 = Point(1, 2)
    
    val sum = p1 + p2  // 使用重载的+操作符
    val diff = p1 - p2 // 使用重载的-操作符
    val neg = -p1      // 使用重载的一元-操作符
    
    Log.e("操作符重载", "p1 + p2 = $sum")
    Log.e("操作符重载", "p1 - p2 = $diff")
    Log.e("操作符重载", "-p1 = $neg")
}

// ========== 综合示例 ==========

fun advancedConceptsDemo() {
    // 单例示例
    singletonExample()
    
    // 空安全示例
    val nullSafety = NullSafetyExamples()
    nullSafety.nullSafetyBasics()
    nullSafety.safeCasts()
    nullSafety.let函数()
    nullSafety.also函数()
    nullSafety.run函数()
    nullSafety.apply函数()
    
    // 高阶函数示例
    val hof = HigherOrderFunctions()
    hof.higherOrderExamples()
    
    // 内联函数示例
    inlineFunctionDemo()
    
    // 泛型示例
    genericExamples()
    
    // 委托属性示例
    val delegated = DelegatedProperties()
    delegated.delegatedPropertiesDemo()
    
    // 操作符重载示例
    operatorOverloadingDemo()
}
