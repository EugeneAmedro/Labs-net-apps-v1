package ua.kpi.its.lab.rest.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import ua.kpi.its.lab.rest.dto.BatteryRequest
import ua.kpi.its.lab.rest.dto.BatteryResponse
import ua.kpi.its.lab.rest.svc.impl.BatteryServiceImpl

@RestController
@RequestMapping("/battery")
class BatteryController(private val serviceImpl: BatteryServiceImpl) {
    @GetMapping("/{id}")
    fun getBatteryById(@PathVariable id: Long): ResponseEntity<BatteryResponse> {
        val response = serviceImpl.getBatteryById(id)
        return ResponseEntity(response, HttpStatus.OK)
    }

    @PostMapping
    fun createBattery(@RequestBody req: BatteryRequest): ResponseEntity<BatteryResponse> {
        val response = serviceImpl.createBattery(req)
        return ResponseEntity(response, HttpStatus.CREATED)
    }

    @PutMapping("/{id}")
    fun updateBatteryById(@PathVariable id: Long, @RequestBody req: BatteryRequest): ResponseEntity<BatteryResponse> {
        val response = serviceImpl.updateBatteryById(id, req)
        return ResponseEntity(response, HttpStatus.OK)
    }

    @DeleteMapping("/{id}")
    fun deleteBatteryById(@PathVariable id: Long): ResponseEntity<Void> {
        serviceImpl.deleteBatteryById(id)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }
}