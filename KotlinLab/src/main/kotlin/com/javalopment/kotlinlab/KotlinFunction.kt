package com.javalopment.kotlinlab

/**
 * Functions that are not defined within a class are called top-level functions.
 */

/**
 * Single Expression Function
 * If a function has only one expression, curly braces can be inferred.
 * Single expression function's return type can be omitted too.
 */
fun singleExp(a: Int, b: Int) = a + b

/**
 * Function Overloading in Kotlin is just as in Java
 */

/**
 * Default Argument, Named Argument
 */
fun sayHello(name: String = "Erol", id: Int){
    println("Hello: ${name}, your id is: ${id}")
}

/**
 * method that takes a lambda, Function interface in this example.
 */
fun methodTakesALambda(input: String, action: (String) -> Int){
    action(input) //directly calling rather than calling Function.apply on Java
}

/**
 *  functions without a return type are returning void or in Kotlin terminology, Unit.
 *  And Unit can be ignored as a return type.
 *
 *  This Unit isn't quite the same as void because it is an object.
 */
fun main(args: Array<String>): Unit {
    sayHello(id=12423)
    sayHello(id=12423, name="Test Name")
    sayHello("Mahmut", 412431)
    var id = null
    var name = null
    println("Hello: ${name}, your id is: ${id}")
}