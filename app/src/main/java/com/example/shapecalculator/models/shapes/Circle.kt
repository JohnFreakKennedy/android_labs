package com.example.shapecalculator.models.shapes

import com.example.shapecalculator.models.Shape
// import com.example.shapecalculator.screens.INVALID_INPUT
// TODO: UNCOMMENT/REWRITE INVALID INPUT RESULT
class Circle: Shape() {

    private lateinit var circle: Circle

    override fun area() = Math.PI * radius * radius

    override fun perimeter() = 2 * Math.PI * radius

    override fun calculateArea() {
        circle = Circle()
        while (true) {
            try {
                getRadiusOfCircle()
                println("Area of circle: ${circle.area()}")
                // How to show 2 decimal places
                // println("Floor area: %.2f".format(floorArea()))
                break
            } catch (e: NumberFormatException) {
               // println(INVALID_INPUT)
            }
        }
    }

    override fun calculatePerimeter() {
        circle = Circle()
        while (true) {
            try {
                getRadiusOfCircle()
                println("Perimeter of circle: ${circle.perimeter()}")
                break
            } catch (e: NumberFormatException) {
                // println(INVALID_INPUT)
            }
        }
    }

    private fun getRadiusOfCircle() {
        println("Type in the radius of the Circle")
        val arg = readln().toDouble()
        circle.radius = arg
        println("Radius: $arg")
    }

}