package com.rockthejvm

object Basics extends App{

  // defining value
  val meaningOfLife: Int = 42

  // all basic types in scala:
  val aString: String = "hello"
  val anInt: Int = 42
  val aDouble: Double = 3.14
  val aFloat: Float = 3.14f
  val aShort: Short = 4613
  val aLong: Long = 123456789
  val aByte: Byte = 127
  val aChar: Char = 'a'
  val aBoolean: Boolean = false

  // String operations
  val aComposedString = "i" + " am" + " learning" + " scala"
  val interpolatedString = s"The meaning of life is $meaningOfLife"

  // Expressions - structures that can be reduced to values. No more instructions, only values
  val anExpression = 2 + 3

  // if expressions
  val ifExpression = if (meaningOfLife > 43) 56 else 7

  val chainedIfExpression = if (meaningOfLife > 43) 56
  else if (meaningOfLife < 0) -2
  else 0

  // code blocks
  val aCodeBlock = {
    //definitions
    val aLocalValue = 67

    // Value of the block is the value of the last expression
    aLocalValue + 3
  }

  // defining a fuinction
  def aFunction(x: Int, y: String): String = {
    y + " " + x
  }

  // recursive functions
  def factorial(n: Int): Int =
    if (n <= 0) 1
    else n * factorial(n - 1)

  // example: factorial of 5
  println(s"factorial of 5 is ${factorial(5)}")
  // Note to self. Apparently in scala it is cursed to use loops and iterations.
  // Only RECURSIONS are allowed

  // Unit return types
  // UNIT - no meaningful value (void)
  // for example - println() does not return anything but it does something
  // function that returns Unit almost always has "side effects"
  println("This function has no return")

  def printlnWrapper(x: String): Unit = println(x)
  val bruh = printlnWrapper("See? Real shit bruv")
  println(bruh.getClass)



}
