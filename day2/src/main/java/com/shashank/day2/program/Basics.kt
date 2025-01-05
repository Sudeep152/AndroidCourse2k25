package com.shashank.day2.program

fun main() {

    /*  1. // Outputs
        println("Hello world")
        println("One")
        println("Tow")*/


    /* 2.Variables*/


//    var a = 5 // mutable
//    val b = 5 // immutable
//    a = 6
//    b = 5
//    print(a)


    // 3. DataType
    /*
    * Int , Double , Float , Boolean , Char ,String
    * */
    /*    var name = "Shashank"
        var price = 12.00
        var priceInFloat = 12.9f
        var isTrue = true
        var type = 'A'
        var age = 26
        */

    //4. Operators
    // 1. arithmetic + - * / %
    /*    var a = 3
        var b = 4
        println(a+b)
        println(a-b)
        println(a%b)
        println(a*b)*/

    //2. Comparison > < >= <= == !=
/*    println("Enter number")
    val age: Int = readln().toInt()
    if (age == 12) {
        println("Age is 12")
    } else {
        println("Age is not 12")

    }*/
    //3. Logical
/*    val a  = readln()
    var b = 2
    println(a==b && a>b)*/


    // Control Flow

    // IF ELSE
 /*   println("Enter You Age")
    val age = readln().toInt()

    if (age > 18){
        println("You are eligible for vote")
    }
    else if (age == 18){
        println("Please go for registration")
    }
    else{
        println("You are not eligible for vote")
    }*/

    //Switch  (when)
/*
    println("Please enter any number 1 to 5")
    val number = readln().toInt()

    when(number){
        1 -> println("One")
        2 -> println("Two")
        3 -> println("Three")
        4 -> println("Four")
        5 -> println("Five")
        else -> println("Invalid Number")
    }
*/
    
    // LOOPS
    
   /* for (index in 1..10){
        println("Hello $index")
    }
    var i =1
    while (i<=5){
        println("Hello")
        i++
    }*/

/*
    var j = 1
    do {
        println(1)
        j++
    }while (j<=5)

*/

   val value =  5+4.9f
    println(value)



}

fun add(a:Int ,b:Int): Int {
    return a+b
}

fun calculate(a: Int, b: Int, operator: Char): Int {
 return 0
}
