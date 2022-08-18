package com.javalopment.kotlinlab

/**
 * In Kotlin, all exceptions are unchecked, so the compiler does not force to catch them.
 */

fun basic(){
    try {
        println(7/0)
    } catch (e: ArithmeticException) {
        println("error got --> ${e.message}")
    }
}

@Throws (InterruptedException::class) //this is for Java developers who will call this method from Java.
fun divide(a: Int, b: Int): Double {
    Thread.sleep(100)
    if (b == 0) throw Exception("cannot be divided by zero")
    return a.toDouble() / b
}

/**
 *  In Kotlin, just like the if statement, the try statement is an expression.
 */
fun tryExpression(){

    var result = try {
        divide(5, 0)
    } catch(e: Exception) {
        println(e.message)
        0 //if any exception occurs, result will be 0
    }

    println(result)
}

fun main(args: Array<String>) {
    basic()
    tryExpression()
}