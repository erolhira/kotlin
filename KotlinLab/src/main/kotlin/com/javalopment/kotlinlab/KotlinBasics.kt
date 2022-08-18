//package com.javalopment.kotlinlab
import java.lang.Exception
import java.math.BigDecimal
import kotlin.math.roundToInt

/**
 * A Kotlin property or function should not necessarily be a member of a class.
 * Top-level properties and functions can be accessed globally in the package.
 * Top-level properties and functions in other packages can be imported.
 *
 * val --> Assign-once(read-only) variable
 * var --> Mutable variable
 *
 * Types can be inferred.
 * Top-level and class level properties must have an initial value.
 *
 * Null means that the property is not initialized.
 * Kotlin divides properties into nullable and non-nullable.
 * If null can be assigned to a property, the property should be marked with ? symbol as a nullable property.
 *
 * In Kotlin everything is an object.
 * Data Types: Int, Double, Float, Long, Short, Byte, Char, Boolean, String, Any, Unit, Nothing
 * Kotlin is a strongly typed language. By this we mean that every variable has a type.
 *
 * In Kotlin a variable is not a field but a property --> has getter and setter functions.
 * Kotlin automatically imports the package kotlin.io, just as Java does for java.lang.
 *
 * In Kotlin, new keyword is not used to instantiate an object, just call the constructor as a function.
 */

var text = "Hello World"
val age: Int = 10
val nullableData: String? = null

fun helloWorld(){
    println(text)
}

/**
 * Escaped Strings --> Double Quotes --> ""
 * Raw Strings --> Triple Quotes --> """ --> enter, tab ..etc is shown as typed.
 * Strings may contain template expressions starting with $.
 */
fun strings(){
    val name = "Erol";
    var data1: String = "Length of the name is ${name.length}"
    println(data1)

    var rawString = """
        Test
            Me
        Here: $data1
    """.trimIndent()
    println(rawString)
}

//is in Kotlin == instanceof in Java
fun numerics(){
    val myDouble = 21.4
    println("is myDouble is Double --> ${myDouble is Double}")
    println("myDouble is ${myDouble::class.qualifiedName}")
    println("myDouble in Java is ${myDouble.javaClass}")

    val myInt: Int = myDouble.roundToInt()
    println("myInt is ${myInt::class.qualifiedName}")

    val myFloat = 21.4f
    val result = myFloat + myInt
    println("result is ${result}")

    val bd = BigDecimal(17);
}

/**
 * Every Kotlin class has Any as a superclass.
 * Any is just like Object in Java.
 */
fun anyType(){
    var dataAny: Any = 10
    dataAny = "Test"
}

/**
 * Unit type can be a return type when there is no return statement;
 * close to void in Java, but not the same; void means no return; but Unit is an object not a keyword.
 */
fun unitAsReturnType(): Unit{
    //no return is needed
}

/**
 *  if we set a variable to null and we don't assign that variable an explicit type,
 *  then this variable is given a special object type, nothing.
 *
 *  recommended that you might use it as an example for a function that is never going to return.
 */
fun exploringNothing(){
    var address = null
}

/**
 * Nothing type is used when we want to show explicitly there is no value.
 */
fun noReturn(): Nothing {
    throw Exception()
}

/**
 * We can check type by is operator.
 * smart casting: The operator <is> checks type and casts automatically when needed.
 */
fun typeCheckAndCasting(){

    var obj: Any = "Test Me"

    if(obj is String) {
        //is operator smartly casts the obj into the String type here.
        println(obj.length)
    }

    if(obj !is String) {
        println(obj)
    }

    //explicit casting without type check
    val myString = obj as String
    println(myString)
}

/**
 * Kotlin does not support implicit conversions for numbers.
 * For type casting, we explicitly use toXX() functions.
 */
fun typeCastingOnNumbers(){

    var a1: Int = 10
    //var a2: Double = a1 //error
    var a2: Double = a1.toDouble()
    //or:
    a2 = a1 as Double
}

fun conditions(){

    val a = 10
    val name = if(a > 5) "Erol" else "Merol"

    if(true){
        println(name)
    }

    when(a){
        1 -> println("is one")
        10, 20 -> println("10 or 20")
        30 -> {
            val result = "val is 30"
            println(result)
        }
        is Int -> println("int")
        else -> println("else..")
    }
}

fun loops(){

    var sum = 0
    for(i in 1..10){ //10 is included
        sum += i
    }
    println("sum is: $sum")

    sum = 0
    for(i in 1 until 10){ //10 is not included
        sum += i
    }
    println("sum is: $sum")

    sum = 0
    for(i in 2..10 step 2){ //2 step increment
        sum += i
    }
    println("sum is: $sum")

    sum = 0
    for(i in 10 downTo 1){ //decrement; 1 is included
        sum += i
    }
    println("sum is: $sum")

    //you can also set range to a variable
    val range = 0..9
    for(i in range) {
        println(i)
    }

    (0..9).forEach { println(it) }
}

fun loopsWithIndices(){

    val list = listOf<String>("Hello", "Erol", "Hira")

    for(i in list){
        println(i)
    }

    for(i in list.indices){
        println(list.get(i))
    }

    for((index, value) in list.withIndex()){
        println("index: $index, value: $value")
    }
}

data class Person(val name: String, val age: Int)
fun loopsWithCollections(){

    val list = listOf(
        Person("Erol", 20),
        Person("Merol", 30))

    //destructuring
    for ((name, age) in list) {
        println("name: $name -- age: $age")
    }

}

/**
 * Marking a property with the lateinit modifier allows us to initialize the property after creating an object.
 * Only var properties can use lateinit
 * lateinit can be used on only properties in the class body and Top-Level, not on constructor's properties.
 * lateinit can be used on the properties that donot have custom getter or setter.
 * nullable properties cannot use lateinit
 * Property's data type shouldnot be one of the primary data types.
 */
lateinit var lateInitData: String
class User { lateinit var name: String }
fun lateInit(){
    lateInitData = "Hello late init"
    println(lateInitData)

    val user = User()
    user.name = "Erol";
}

/**
 * If we use lazy keyword, we do not need to initialize the property until it is used.
 */
fun lazyInit(){

    val lazyData: String by lazy {
        println("initializing lazyData")
        "i am lazy data"
    }

    println(lazyData)
}

/**
 * In Kotlin; by default, variables cannot contain a null value.
 */
fun exploringNull(){

    //val myString: String = null //explicitly typed variable can not contain null BUT:

    val myNullableString = null //this is possible
    val myNullableString2: String? = null //this is possible also by using null-safe operator ?
}

fun nullSafety(){
    var data: String? = "one"
    var length: Int? = data?.length //return null if data is null
    length = data?.length ?: -1 //return -1 if data?.length is null --> elvis operator
    length = data!!.length //throw exception if data is null --> non-null asserted operator (you should not use)
}

fun nullSafeCasting(){
    var strData: String = "one"
    val intData: Int? = strData as? Int //return null if the cast is not successful
}

/**
 * BEST PRACTISE WITH NULLABLE VARIABLES:
 *  Whenever creating variables, think about could this variable be null or not?
 *  And if it can't be null, don't make it nullable.
 */

/**
 * In Kotlin, == does object equality, rather than reference equality as in Java.
 * Kotlin(==) means --> Java(.equals)
 * Kotlin(===) means --> Java(referans equality)
 */
fun objectEquality(){ }

//let function
fun exploringLet() {

    var hello = "Hello World"
    val uppercaseHello = hello.toUpperCase()

    //alternative:
    //it --> means the original object in kotlin lambdas
    val upprcaseHelloAlternative = hello.let { it.toUpperCase() }
    //this is shorthand way of doing this:
    val upprcaseHelloAlternative2 = hello.let { x -> x.toUpperCase() }

}

class TestClassForLet {

    var color: String? = "Green"

    fun getLastLetter(s: String) = s.takeLast(1)

    fun getLastLetterOfColor(): String {
        //return if(color == null) "" else getLastLetter(color)
        //return getLastLetter(color!!) ?: ""
        return color?.let { getLastLetter(it) } ?: ""
    }
}

fun main(args: Array<String>) {
    //helloWorld()
    //strings()
    //println(unitAsReturnType())
    //conditions()
    //loops()
    //loopsWithIndices()
    loopsWithCollections()
    //lateInit()
    //lazyInit()
    //numerics()
}