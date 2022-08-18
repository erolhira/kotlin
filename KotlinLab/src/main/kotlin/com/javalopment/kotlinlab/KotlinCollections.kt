package com.javalopment.kotlinlab

/**
 * Array class
 * functions: get, set
 * property: size
 *
 * create an array with arrayOf() function
 */
fun arrays(){

    var array: Array<Any> = arrayOf(1, "one", true)
    array[0] = "10"
    array[1] = "ten"
    println("size: ${array.size}, array[0]: ${array[0]}, array[1]: ${array.get(1)}")

    var arrayInt = arrayOf<Int>(1, 2, 3)
    arrayInt[1] = 10

    var arrayInt2 = intArrayOf(1, 2, 3)
    arrayInt2[1] = 4
    arrayInt2.set(0, 10)

    var array3 = arrayOfNulls<Any>(3) //empty array of size 3
    array3[1] = 1

    var anotherEmptyArray = Array<String>(3, { "" })
    anotherEmptyArray[2] = "second element"
}

/**
 * kotlin.collection.[List, Map, Set] are immutable and provides --> size() and get() functions
 * create --> listOf(), mapOf(), setOf()
 *
 * kotlin.collection.[MutableList, MutableMap, MutableMap] provides --> size(), get(), set(), add()
 * create --> mutableListOf(), mutableMapOf(), mutableSetOf()
 */
fun lists() {

    val list1: List<Int> = listOf<Int>(10, 20)
    list1.forEach { println(it) }

    val list2: MutableList<Int> = mutableListOf<Int>(10, 20)
    list2.add(30)

    val emptyList = mutableListOf<String>()
    emptyList.add("Red")

    println(list1[1]) //just as in array, you can access elements of a list with square brackets.
}

fun maps() {

    val colors = mapOf("red" to "ff0000", "blue" to "00ff00")
    colors.forEach { key, value -> println("$key: $value")}

    for ((key, value) in colors) {
        println("$key: $value")
    }
}

fun main(args: Array<String>) {
    //arrays()
    //lists()
    maps()
}