package com.javalopment.kotlinlab

/**
 *  In Kotlin, the file name and the class name don't have to be a one to one mapping.
 *  Classes are public by default.
 *  The fields in a class are public by default,
 *  so we don't call a get a set method to address a variable.
 *
 *  In Java, there's no way for Java coders to be able to access top-level Kotlin functions.
 */

//primary constructor//
class KotlinClass { }
//class KotlinClass() { } //same as above
//class KotlinClass constructor() { }

class KotlinClass2
    (name: String = "defaultName", val id: Int) //primary constructor
{
    val age: Int = 12;
    var hello: String
    init {
        //if we wanted to run some code for our primary constructor.
        //so, init block is the body of the primary constructor.
        hello = "Hello " + name
    }

    /**
     * parameters of secondary constructor cannot be daclared with var or val
     * secondary constructors must call the primary constructor
     */
    constructor(name: String): this(name, 4234) //{ } curly braces can be omitted if no code in body is needed.

    fun some(){
        println(hello)
        //println(name) name can not be accessed
        println("id: " + id) //val makes a variable class level
    }
}

class KotlinClass3

class KotlinClass4()

class KotlinClass5(val age: Int)

class KotlinToOverrideGetterSetter(val name: String, val age: Int) {
    var approved: Boolean? = false
        set(value) {
            if (age > 20) {
                field = false
            } else {
                field = value
            }
        }
        get() = field ?: false

    val nextAge
        get() = age + 1
}

/**
 * Superclasses have to be declared with open keyword; because:
 * classes in Kotlin are final by default.
 *
 * Overridable functions are also declared with open keyword.
 * : is used instead of extends keyword in Java
 *
 * So:
 * open means --> overridable
 */
interface ShapeInterface {
    var iData: String
    fun stats()
    fun style(): String = "Dotted" //default implementation
}

abstract class BaseShape: ShapeInterface {
    abstract val absData: String
    abstract fun print(text: String)

    override fun toString(): String = super.toString()
}

/**
 * if we are extending a class, we must call its constructor,
 * passing in any parameters that the class we are extending need.
 */
open class Shape(open var x: Int = 10, var height: Int): BaseShape() {
    override var iData: String = "iData"
    override val absData: String = "abs value"
    open fun draw(){
        println("$x in Shape")
    }

    override fun print(text: String) {
        println(text)
    }

    override fun stats() {
    }
}

open class Rect: Shape(height = 10){

    var y: Int = 0
    override var x: Int = 20
    override fun draw() {
        super.draw()
        println("$x in Rect, height: $height")
    }

    //static function --> companion object
    companion object {
        /**
         *  @JvmStatic lets Java direct calling as --> Rect.getInstance(y)
         *  if @JvmStatic not used then it would be called as --> Rect.Companion.getInstance(y)
         */
        @JvmStatic
        fun getInstance(y: Int): Rect {
            val rect = Rect()
            rect.y = y
            return rect
        }
    }
}

//data class has default implementation for --> toString, hashCode, equals
data class Customer(val name: String, val age: Int)

class MyCustomException(message: String): Throwable(message)

/**
 * Adding Functions To Existing Classes:
 * In the entirety of the package that we are working in;
 * strings now have an additional function called toSentenceCase.
 */
fun String.toSentenceCase(): String {
    return this[0].toUpperCase() + this.substring(1)
}

fun main(args: Array<String>) {

    var user = KotlinClass2("Erol")
    user.some()
    println(user.hello) //The fields in a class are public by default.
    //user.name //cannot access constructor-defined fields, they are private by default
    //user.id //can access constructor-defined val fields, but read-only as you know.

    var shape = Rect.getInstance(30)
    shape.height = 30
    shape.draw()


    var setterOverride = KotlinToOverrideGetterSetter("Erol", 38)
    setterOverride.approved = true
    println(setterOverride.approved) //prints false, since of overriden setter
    println(setterOverride.nextAge)

    //exploring data class
    var customer = Customer("Erol", 38)
    println(customer)
    customer = customer.copy(name="Merol")
    println(customer)

    //destructuring
    val (name, age) = customer
    println("name: $name -- age: $age")
}