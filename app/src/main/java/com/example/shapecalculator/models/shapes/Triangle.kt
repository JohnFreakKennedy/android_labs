package com.example.shapecalculator.models.shapes

import com.example.shapecalculator.models.Shape
// import com.example.shapecalculator.screens.INVALID_INPUT
// TODO: UNCOMMENT/REWRITE INVALID INPUT RESULT
class Triangle:Shape() {

    private lateinit var triangle: Triangle

    override fun area() = 0.5 * (baseLength * height)

    override fun perimeter() = sideLength1 + sideLength2 + baseLength

    override fun calculateArea() {
        triangle = Triangle()
        while (true) {
            try {
                println("Type in the BaseLength of the Triangle")
                val arg1 = readln().toDouble()
                triangle.baseLength = arg1
                println("BaseLength: $arg1")

                println("Type in the Height of the Triangle")
                val arg2 = readln().toDouble()
                triangle.height = arg2
                println("Height: $arg2")

                println("Area of Triangle: ${triangle.area()}")
                break
            } catch (e: NumberFormatException) {
                // println(INVALID_INPUT)
            }
        }
    }

    override fun calculatePerimeter() {
        triangle = Triangle()
        while (true) {
            try {
                println("Type in the SideLength-1 of the Triangle")
                val arg1 = readln().toDouble()
                triangle.sideLength1 = arg1
                println("SideLength-1: $arg1")

                println("Type in the SideLength-2 of the Triangle")
                val arg2 = readln().toDouble()
                triangle.sideLength2 = arg2
                println("SideLength-2: $arg2")

                println("Type in the BaseLength of the Triangle")
                val arg3 = readln().toDouble()
                triangle.baseLength = arg3
                println("BaseLength: $arg3")

                println("Perimeter of Triangle: ${triangle.perimeter()}")
                break
            } catch (e: NumberFormatException) {
               // println(INVALID_INPUT)
            }
        }
    }

}