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
    fun  largerNumber2(param1: Int,param2: Int): Int = max(param1,param2)

    //因为kotlin的类型推导机制，等号右侧的值的类型已经确定了，所以在左侧就不需要返回值类型了
    fun largerNumber3(param1: Int,param2: Int) = max(param1,param2)

    //程序的逻辑控制
    //1.if


}