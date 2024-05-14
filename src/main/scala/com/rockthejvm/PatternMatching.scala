package com.rockthejvm

object PatternMatching extends App {

  // switch statements and pattern matching
  val anInteger = 1
  val order = anInteger match {
    case 1 => "first"
    case 2 => "second"
    case _ => "unknown"
  }
  // Pattern matching in scala is also an expression, meaning that it can be reduced to a value
  println(order)


  // kinda like instance of in java + extra features
  // this thing is called deconstruction
  case class Person(name: String, age: Int)
  val bob = Person("Bob", 25)
  val greeting = bob match {
    case Person(n, a) => s"Hi, my name is $n and I am $a years old"
  }
  println(greeting)

  // deconstructing tuples
  val aTuple = ("Bob", "A Guy")
  val tupleMatch = aTuple match {
    case (name, job) => s"$name is a $job" // will match if tuple has 2 elements
    case _ => "I don't know wtf is this"
  }
  println(tupleMatch)


  // btw pattern matching will try all cases in sequence
  val aList = List(1, 2, 3)
  val listDescription = aList match {
    case List(_, 2, _) => "List with 1 as the first element"
    case _ => "Unknown list"  // If no match is found -> Scala will crush with an MatchError
  }
  println(listDescription)


  // shadowing variables
  val a = 100
  val b = 200
  val myList = List(10, 2, 20)

  myList match {
    case List(a, 2, b) => println(s"a: $a, b: $b")  // scala will shadow a and b previous values,
                                                    // they will be 10 and 20
    case _ => println("No match")
  }
  println(s"a: $a b:$b")
}
