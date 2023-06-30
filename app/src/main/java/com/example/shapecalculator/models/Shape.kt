package com.example.shapecalculator.models

abstract class Shape:Measurable {

    var length = 0.0
    var breadth = 0.0
    var height = 0.0
    var sideLength = 0.0
    var sideLength1 = 0.0
    var sideLength2 = 0.0
    var topLength = 0.0
    var baseLength = 0.0
    var radius = 0.0

    override fun measureShape(number: Int, shape: Shape) {
        when (number) {
            1 -> shape.calculateArea()
            2 -> shape.calculatePerimeter()
        }
    }

}