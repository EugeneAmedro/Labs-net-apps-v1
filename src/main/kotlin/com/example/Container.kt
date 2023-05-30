package com.example

interface Container<T> {
    fun add(car: T)
    fun remove(index: Int)
    fun update(index: Int, car: T)
    fun get(index: Int): T
    fun getAll(): List<T>
}

class CarContainer : Container<Car> {
    private val cars: MutableList<Car> = mutableListOf()
    override fun add(car: Car) {
        cars.add(car)
    }

    override fun remove(index: Int) {
        cars.removeAt(index)
    }

    override fun update(index: Int, car: Car) {
        cars[index] = car
    }

    override fun get(index: Int): Car {
        return cars[index]
    }

    override fun getAll(): List<Car> {
        return cars
    }
}