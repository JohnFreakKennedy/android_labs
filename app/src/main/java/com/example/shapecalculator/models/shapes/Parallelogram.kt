package com.example.shapecalculator.models.shapes

import com.example.shapecalculator.models.Shape
// import com.example.shapecalculator.screens.INVALID_INPUT

class Parallelogram: Shape() {

    private lateinit var parallelogram: Parallelogram

    override fun area() = baseLength * height

    override fun perimeter() = 2 * (baseLength + sideLength)

    override fun calculateArea() {
        parallelogram = Parallelogram()
        while (true) {
            try {
                println("Type in the BaseLength of the Parallelogram")
                val arg1 = readln().toDouble()
                parallelogram.baseLength = arg1
                println("BaseLength: $arg1")

                println("Type in the Height of the Parallelogram")
                val arg2 = readln().toDouble()
                parallelogram.height = arg2
                println("Height: $arg2")

                println("Area of parallelogram: ${parallelogram.area()}")
                break
            } catch (e: NumberFormatException) {
              //  println(INVALID_INPUT)
            }
        }
    }

    override fun calculatePerimeter() {
        parallelogram = Parallelogram()
        while (true) {
            try {
                println("Type in the BaseLength of the Parallelogram")
                val arg1 = readln().toDouble()
                parallelogram.baseLength = arg1
                println("BaseLength: $arg1")

                println("Type in the SideLength of the Parallelogram")
                val arg2 = readln().toDouble()
                parallelogram.sideLength = arg2
                println("SideLength: $arg2")

                println("Perimeter of Parallelogram: ${parallelogram.perimeter()}")
                break
            } catch (e: NumberFormatException) {
                // println(INVALID_INPUT)
            }
        }
    }

}