package ua.kpi.its.lab.rest.svc

import ua.kpi.its.lab.rest.dto.CarRequest
import ua.kpi.its.lab.rest.dto.CarResponse

interface CarService {
    fun createCar(carRequest: CarRequest): CarResponse
    fun getCarById(id: Long): CarResponse
    fun updateCarById(id: Long, carRequest: CarRequest): CarResponse
    fun deleteCarById(id: Long): Boolean
}