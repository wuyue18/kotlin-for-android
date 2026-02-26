package com.example.hello

import android.util.Log

/**
 * Kotlin面向对象编程学习笔记
 * 包含：类、继承、接口、构造函数等概念
 */

// ========== 接口定义 ==========

interface Study {
    fun readBook()
    fun doHomeWork()
}

// ========== 基类定义 ==========

// open关键字表示这个类可以被继承
// Kotlin中类默认是final的，不能被继承
open class Person(val gender: String) {
    // 属性
    var name = ""
    var age = 0
    
    // 方法
    fun printInfo() {
        Log.e("$name 的年龄是", age.toString())
    }
    
    // open方法可以被子类重写
    open fun greet() {
        Log.e("问候", "大家好，我是$name")
    }
}

// ========== 继承与构造函数 ==========

class Student(var grade: String, gender: String) : Person(gender), Study {
    
    // 初始化块 - 在主构造函数之后执行
    init {
        Log.e("学生初始化", "年级：$grade，性别：$gender")
    }
    
    // ========== 次构造函数 ==========
    // 一个类只能有一个主构造函数，但可以有多个次构造函数
    // 次构造函数必须直接或间接调用主构造函数
    
    // 次构造函数1 - 直接调用主构造函数
    constructor(name: String, age: Int) : this("", "男") {
        this.name = name
        this.age = age
        Log.e("次构造函数1", "name=$name, age=$age")
    }
    
    // 次构造函数2 - 间接调用主构造函数（通过次构造函数1）
    constructor() : this("", 0) {
        Log.e("次构造函数2", "无参数构造")
    }
    
    // ========== 重写接口方法 ==========
    override fun readBook() {
        Log.e("学习", "$name 正在读书")
    }
    
    override fun doHomeWork() {
        Log.e("学习", "$name 正在做作业")
    }
    
    // ========== 重写父类方法 ==========
    override fun greet() {
        Log.e("问候", "我是学生$name，在$grade年级学习")
    }
}

// ========== 特殊情况：没有主构造函数 ==========
class StudentNoPrimary : Person {
    // 当没有主构造函数时，次构造函数必须直接调用父类构造函数
    constructor(name: String, age: Int) : super("男") {
        this.name = name
        this.age = age
    }
}

// ========== 数据类 ==========

// data关键字自动生成equals(), hashCode(), toString(), copy()等方法
data class Cellphone(val brand: String, val price: Double) {
    fun showInfo() {
        Log.e("手机信息", "品牌：$brand，价格：$price")
    }
}

// ========== 数据类使用示例 ==========
fun dataClassExample() {
    val phone1 = Cellphone("iPhone", 8999.0)
    val phone2 = Cellphone("iPhone", 8999.0)
    val phone3 = phone1.copy(price = 7999.0) // 复制并修改属性
    
    Log.e("数据类", phone1.toString()) // 自动生成好看的toString
    Log.e("比较", "phone1 == phone2: ${phone1 == phone2}") // true，因为data类重写了equals
    Log.e("复制", phone3.toString())
}

// ========== 密封类（可选进阶内容） ==========

// sealed类限制子类的继承层次
sealed class Result {
    data class Success(val data: String) : Result()
    data class Error(val message: String) : Result()
    object Loading : Result()
}

fun handleResult(result: Result) {
    when (result) {
        is Result.Success -> Log.e("结果", "成功：${result.data}")
        is Result.Error -> Log.e("结果", "错误：${result.message}")
        is Result.Loading -> Log.e("结果", "加载中...")
        // 不需要else分支，因为编译器知道所有可能的情况
    }
}

// ========== 类的扩展 ==========

// 扩展函数 - 为现有类添加新方法
fun String.isEmail(): Boolean {
    return this.contains("@") && this.contains(".")
}

// 扩展属性
val String.firstChar: Char
    get() = this[0]

fun extensionExample() {
    val email = "test@example.com"
    Log.e("扩展函数", "是否为邮箱：${email.isEmail()}")
    Log.e("扩展属性", "首字符：${email.firstChar}")
}

// ========== 伴生对象 ==========

class CompanionExample {
    companion object {
        const val TAG = "CompanionExample"
        private var instanceCount = 0
        
        fun createInstance(): CompanionExample {
            instanceCount++
            Log.e(TAG, "创建了第 $instanceCount 个实例")
            return CompanionExample()
        }
    }
    
    fun showInfo() {
        Log.e(TAG, "这是一个伴生对象示例")
    }
}

// ========== 使用示例 ==========

fun oopExamples() {
    // 基本继承
    val student = Student("高三", "女")
    student.name = "小明"
    student.age = 18
    student.printInfo()
    student.greet()
    student.readBook()
    student.doHomeWork()
    
    // 次构造函数
    val student2 = Student("小红", 17)
    student2.printInfo()
    
    // 数据类
    dataClassExample()
    
    // 扩展函数
    extensionExample()
    
    // 伴生对象
    val instance = CompanionExample.createInstance()
    instance.showInfo()
}
