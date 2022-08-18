package com.javalopment.kotlinlab

fun applyFuncToAString(s: String, myFunction: (String) -> String) = myFunction(s)

fun exploringLambdas() {
    val str = "hello world"
    val result = applyFuncToAString(str) { s -> s[0].toUpperCase() + s.substring(1) }

    //if a single parametered lambda, then you can use it for that single parameter
    val result2 = applyFuncToAString(str) { it[0].toUpperCase() + it.substring(1) }

    val result3 = applyFuncToAString(str, ::toSentenceCase)

    println(result)
    println(result2)
    println(result3)
}

fun exploreLambdasOnCollections(){

    //map --> returns a transformed one-to-one mapping
    val list = listOf<String>("red", "green", "blue")
    val result = list.map { it.toSentenceCase() }
    println(result)

    val result2 = list.map(::toSentenceCase)
    println(result2)

    val colorsStartsWithB: List<String> = list.filter { it.startsWith("b") }
    println("colors starting with b --> $colorsStartsWithB")

    //flatMap returns a flattened list, not one-to-one as in map
    val colorsStartsWithB2 = list.flatMap {
        if(it.startsWith("b")) listOf(it+1, it+2) else listOf(it)
    }
    println("colors starting with b --> $colorsStartsWithB2")

    //another flatMap example
    val listOfGroups: List<List<String>> = listOf<List<String>>(
        listOf<String>("Galatasaray", "Bursa Spor"),
        listOf<String>("Barcelona", "Real Madrid", "Real Sociedad")
    );

    listOfGroups
        .flatMap { it }
        .filter { it.startsWith("B") }
        .forEach { println(it) }

    //reduce --> for each value of the list, assign the operation result to the resultVar
    val resultVar = list.reduce {resultVar, value -> "$resultVar, $value"}
    println(resultVar)

    //another reduce example to sum the numbers in a collection
    val numbers = listOf<Int>(1, 2, 3, 4)
    val sumOfNumbers = numbers.reduce {result, value -> result + value}
    println(sumOfNumbers)

    //fold --> reduce with a starting value
    val sumOfNumbersOver10 = numbers.fold(10) {result, value -> result + value}
    println(sumOfNumbersOver10)
}

fun exploringMapWithLambdas(){

    val myMap = mapOf(1 to "one", 2 to "two", 3 to "three")
    myMap.filter { (k, v) -> v.startsWith("t") }
        .forEach { (k, v) -> println("$k: $v") }

    //without destructuring
    myMap.filter { it.value.startsWith("t") }
        .forEach { println("${it.key}: ${it.value}") }
}

fun main(args: Array<String>) {

    exploringLambdas()
    exploreLambdasOnCollections()
    exploringMapWithLambdas()
}