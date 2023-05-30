package ua.kpi.its.lab.rest.svc.impl

import org.springframework.stereotype.Service
import ua.kpi.its.lab.rest.dto.CarRequest
import ua.kpi.its.lab.rest.dto.CarResponse
import ua.kpi.its.lab.rest.entity.Car
import ua.kpi.its.lab.rest.repository.CarRepository
import ua.kpi.its.lab.rest.svc.CarService

@Service
class CarServiceImpl(private val carRepository: CarRepository) : CarService {
    override fun createCar(carRequest: CarRequest): CarResponse {
        val car = Car(brand = carRequest.brand, manufacturer = carRequest.manufacturer)
        return CarResponse.fromEntity(carRepository.save(car))
    }

    override fun getCarById(id: Long): CarResponse {
        val car = carRepository.findById(id).orElseThrow()
        return CarResponse.fromEntity(car)
    }

    override fun updateCarById(id: Long, carRequest: CarRequest): CarResponse {
        val car = carRepository.findById(id).orElseThrow()
        car.brand = carRequest.brand
        car.manufacturer = carRequest.manufacturer
        val updCar = carRepository.save(car)
        return CarResponse.fromEntity(updCar)
    }

    override fun deleteCarById(id: Long): Boolean {
        carRepository.deleteById(id)
        return true
    }
}