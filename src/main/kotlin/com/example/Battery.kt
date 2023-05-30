package com.example

import java.time.LocalDate

data class Battery(
    val model: String,
    val manufacturer: String,
    val releaseDate: LocalDate,
    val type: String,
    val capacity: Int,
    val chargeTime: Int,
    val fastCharge: Boolean
) : Comparable<Battery> {
    override fun compareTo(other: Battery): Int {
        return model.compareTo(other.model)
    }
}