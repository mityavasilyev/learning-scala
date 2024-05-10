package com.rockthejvm

object ObjectOrientation extends App {

  // class and instance of it
  class Animal {
    val age: Int = 0

    def eat(): Unit = println("I'm eating")
  }

  val anAnimal = new Animal

  // inheritance
  class Dog(name: String) extends Animal {
  }

  val aDog = new Dog("Hachi")
  // constructor arguments are not fields. Duh...
  //  println(aDog.name) // will result in error

  class BetterDog(val name: String) extends Animal // val before arg turns it into field

  val anotherDog = new BetterDog("Lassie")
  println(anotherDog.name)

  val aDeclaredAnimal: Animal = new Dog("Hachi")
  aDeclaredAnimal.eat() // the most derived method will be called

  // abstract class
  abstract class WalkingAnimal {
    val hasLegs = true // all methods and fields are public by default

    def walk(): Unit
  }

  // "interface" or scala's trait
  trait Carnivore {
    def eat(animal: Animal): Unit
  }

  trait Philosopher {
    def ?!(thought: String): Unit // Name can be almost anything
  }

  // Same as Java: single class extension and multiple trait inheritance
  class Crocodile extends Animal with Carnivore with Philosopher {
    override def eat(animal: Animal): Unit = println(s"Eating ${animal.getClass.getSimpleName}")

    override def ?!(thought: String): Unit = println(s"I am thinking of: $thought")
  }

  val aCroc = new Crocodile
  aCroc.eat(aDog)
  aCroc eat aDog // only available for methods with 1 arg. Kinda same as :: in Java
  aCroc ?! "What does the fox say?"

  // operators in Scala are actually methods
  val basicMath = 1 + 2
  val anotherBasicMath = 1.+(2)

  // anonymous classes
  val dinosour = new Carnivore {
    override def eat(animal: Animal): Unit = println(s"Eating ${animal.getClass.getSimpleName} like a real dino!")
  }
  dinosour eat aCroc

  object MySingleton { // the only instance of MySingleton type
    val myOwnValue = 69

    def myOwnMethod(): Unit = println("I'm cool yeah right!")

    def apply(x: Int): Int = x + 1
  }

  MySingleton.myOwnMethod()
  MySingleton.apply(65)
  MySingleton(65) // will call apply() under the hood

  object Animal { // Is a COMPANION object to class Animal
    // companions can access each other's private members (fields/methods_
    // singleton Animal and instance of Animal are two different things)

    val canLiveIndefinitely = false
  }

  val animalCanLiveForever = Animal.canLiveIndefinitely // Kinda like static in Java


  // CASE classes are data structures with some boilerplate code
  // generates:
  // - sensible equals and hashcode
  // - serialization
  // - companion with apply
  // - pattern matching
  case class Person(name: String, age: Int)

  val bob = Person("Bob", 69) // no need in "new" since generated apply is a fabric method


  // exceptions
  try {
    // code that can throw
    val x: String = null
    x.length
  } catch {
    case e: Exception => "I caught an exception"
  } finally {
    // execute some code no matter what
  }


  // Generics
  abstract class MyList[T] { // covariant
    def head: T
    def tail: MyList[T]
  }

  val aList: List[Int] = List(1, 2, 3, 4)
  val first= aList.head // Infers int type
  val rest = aList.tail
  val aStringList = List("Hello", "World")
  val firstString = aStringList.head   // Infers string type

  // NOTES:
  // 1) In scala it is better to operate with IMMUTABLE values (new instances is a go)
  // 2) Scala is the closest to a object oriented language

}
