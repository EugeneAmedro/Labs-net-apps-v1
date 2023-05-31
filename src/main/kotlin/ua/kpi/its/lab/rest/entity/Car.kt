package ua.kpi.its.lab.rest.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "car")
data class Car(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long,
    val brand: String,
    val model: String,
    val manufacturer: String,
    val releaseDate: LocalDate,
    val maxSpeed: Int,
    val price: Int,
    val withABS: Boolean,
    @OneToOne(mappedBy = "car", cascade = [CascadeType.ALL], orphanRemoval = true)
    val battery: Battery,
) : Comparable<Car> {
    override fun compareTo(car: Car): Int {
        return brand.compareTo(car.brand)
    }
}