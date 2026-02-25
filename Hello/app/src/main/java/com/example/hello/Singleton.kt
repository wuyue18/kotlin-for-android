package com.example.hello

import android.util.Log

//object表示这是一个单例类，会自动实现单例
object Singleton  {
    fun singleTest()= Log.e("method","singletonTest")
    //调用：Singleton.singletonTest()类似静态方法
}