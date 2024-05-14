package com.rockthejvm

object FunctionalProgramming extends App {

  class Person(name: String) {
    def apply(age: Int) = println(s"I am $age years old")
  }

  val bob = new Person("Bob")
  bob.apply(43)
  bob(43) // Invoking var as a method

  /*
  Functional programming:
  - compose functions
  - pass functions as args
  - return functions as result

  Scala introduced FunctionX
  where X is a number of args for function.
  Max number of X is 22
   */

  val simpleIncrementer = new Function1[Int, Int] {
    override def apply(arg: Int): Int = arg + 1
  }
  println(simpleIncrementer(23))
  // All scala functions are instances of this FunctionX

  val stringConcatenator = new Function2[String, String, String] {
    override def apply(arg1: String, arg2: String): String = arg1 + arg2
  }

  println(stringConcatenator("Hello ", "Scala"))


  // syntax sugar
  /*
  val doubler: Function1[Int, Int] = (x: Int) => 2 * x

  Under the hood:
  val doubler = new Function1[Int, Int] {
    override def apply(x: Int): Int = 2 * x
  }
   */
  val doubler: Int => Int = (x: Int) => 2 * x



  // Higher order functions: Take functions as args, or return functions as results
  val aMappedList = List(1, 2, 3)
    .map(x => x + 1) // HOF (higher order function)
  println(aMappedList)

  val aFlatMappedList = List(1, 2, 3)
    .flatMap(x => List(x, 2 * x))
  println(aFlatMappedList)  // List(1, 2, 2, 4, 3, 6)

  val aFilteredList = List(1, 2, 3, 4, 5)
    .filter(x => x % 2 == 0)
  println(aFilteredList)

  val anotherFilteredList = List(1, 2, 3, 4, 5)
    .filter(_ % 2 == 0)
  println(anotherFilteredList)

  // all the pairs between 1,2,3 and a,b,c
  val allPairs = List(1, 2, 3)
    .flatMap(x => List('a', 'b', 'c').map(y => s"$x:$y"))
  println(allPairs)

  // for-comprehension
  val allPairsFor = for {
    number <- List(1, 2, 3)
    char <- List('a', 'b', 'c')
  } yield s"$number:$char"
  println(allPairsFor)
  // to the compiler, for and map/flatmap chains are the same


  // collections
  val aList = List(1, 2, 3)
  val first = aList.head // first element
  val rest = aList.tail // all elements except the first
  val isEmpty = aList.isEmpty
  val aPrependedList = 42 :: aList  // result: List(42, 1, 2, 3)
  val anExtendedList = 42 +: 43 +: aList :+ 44 // result: List(42, 43, 1, 2, 3, 44)

  // sequences - any element can be accessed by an index. Basically an array
  val aSequence: Seq[Int] = Seq(1, 2, 3)
  val accessedElement = aSequence(1)  // An element at index 1

  // vectors - ultra fast sequences when it comes to accessing elements
  val aVector = Vector(1, 2, 3)

  // sets - no duplicates
  val aSet = Set(1, 2, 3, 4, 1, 2, 3)  // Set(1, 2, 3, 4)
  val setHas5 = aSet.contains(5)

  // ranges - useful for iteration
  val aRange: Seq[Int] = 1 to 1000
  val twoByTwo = aRange.map(x => x * 2).toList

  // tuple
  val aTuple = ("Bon Jovi", 1988)

  // maps
  val aMap = Map(
    "Daniel" -> 789,
    "Jess" -> 555
  )


}
