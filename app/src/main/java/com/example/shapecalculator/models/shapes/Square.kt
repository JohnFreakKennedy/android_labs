package com.example.shapecalculator.models.shapes

import com.example.shapecalculator.models.Shape
// import com.example.shapecalculator.screens.INVALID_INPUT
// TODO: UNCOMMENT/REWRITE INVALID INPUT RESULT

class Square: Shape() {

private lateinit var square: Square

override fun area() = sideLength * sideLength

override fun perimeter() = 4 * sideLength

override fun calculateArea() {
    square = Square()
    while (true) {
        try {
            getSideLength()
            println("Area of Square is: ${square.area()}")
            break
        } catch (e: NumberFormatException) {
            // println(INVALID_INPUT)
        }
    }
}

override fun calculatePerimeter() {
    square = Square()
    while (true) {
        try {
            getSideLength()
            println("Perimeter of Square: ${square.perimeter()}")
            break
        } catch (e: NumberFormatException) {
            // println(INVALID_INPUT)
        }
    }
}

private fun getSideLength() {
    println("Type in the SideLength of the Square")
    val arg = readln().toDouble()
    square.sideLength = arg
    println("SideLength: $arg")
}

}