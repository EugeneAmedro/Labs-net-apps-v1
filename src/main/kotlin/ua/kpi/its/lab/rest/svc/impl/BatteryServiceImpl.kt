package ua.kpi.its.lab.rest.svc.impl

import org.springframework.stereotype.Service
import ua.kpi.its.lab.rest.dto.BatteryRequest
import ua.kpi.its.lab.rest.dto.BatteryResponse
import ua.kpi.its.lab.rest.entity.Battery
import ua.kpi.its.lab.rest.repository.BatteryRepository
import ua.kpi.its.lab.rest.svc.BatteryService
@Service
class BatteryServiceImpl(private val batteryRepository: BatteryRepository) : BatteryService {
    override fun createBattery(batteryRequest: BatteryRequest): BatteryResponse {
        val battery = Battery(model = batteryRequest.model, manufacturer = batteryRequest.manufacturer)
        val newBattery = batteryRepository.save(battery)
        return BatteryResponse.fromEntity(newBattery)
    }

    override fun getBatteryById(id: Long): BatteryResponse {
        val battery = batteryRepository.findById(id).orElseThrow()
        return BatteryResponse.fromEntity(battery)
    }

    override fun updateBatteryById(id: Long, batteryRequest: BatteryRequest): BatteryResponse {
        val battery = batteryRepository.findById(id).orElseThrow()
        battery.model = batteryRequest.model
        battery.manufacturer = batteryRequest.manufacturer
        val updatedBattery = batteryRepository.save(battery)
        return BatteryResponse.fromEntity(updatedBattery)
    }

    override fun deleteBatteryById(id: Long): Boolean {
        batteryRepository.deleteById(id)
        return true
    }
}