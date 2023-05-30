package com.example

import java.time.LocalDate

data class Car(
    val brand: String,
    val model: String,
    val manufacturer: String,
    val releaseDate: LocalDate,
    val maxSpeed: Int,
    val price: Int,
    val withABS: Boolean,
    val battery: Battery,
) : Comparable<Car> {
    override fun compareTo(other: Car): Int {
        return brand.compareTo(other.brand)
    }
}