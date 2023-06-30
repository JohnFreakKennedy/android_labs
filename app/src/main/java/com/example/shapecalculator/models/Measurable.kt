package com.example.shapecalculator.models

interface Measurable {

    fun area(): Double
    fun perimeter(): Double

    fun calculateArea()
    fun calculatePerimeter()
    fun measureShape(number: Int, shape: Shape)
}

fun measureShape(number: Int, shape: Shape) {
    when (number) {
        1 -> shape.calculateArea()
        2 -> shape.calculatePerimeter()
    }
}

enum class ShapeList{
    Triangle,
    Circle,
    Square,
    Rectangle,
    Parallelogram,
    Trapezium
}