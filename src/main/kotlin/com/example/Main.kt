package com.example

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import java.time.LocalDate

@SpringBootApplication
class Main

fun main() {
    val carContainer =
        AnnotationConfigApplicationContext(AppConfig::class.java).getBean(Container::class.java) as CarContainer

    carContainer.add(
        Car(
            "Jetour",
            "x70",
            "China",
            LocalDate.of(2021, 3, 11),
            180,
            20500,
            true,
            Battery("CB1533-17", "Chery", LocalDate.of(2021, 1, 1), "Gel", 65, 50, false),
        ),
    )

    carContainer.add(
        Car(
            "Geely",
            "MK",
            "China",
            LocalDate.of(2012, 3, 22),
            180,
            36000,
            true,
            Battery("S4005", "Bosh", LocalDate.of(2011, 10, 8), "Gel", 42, 50, false),
        ),
    )
}
