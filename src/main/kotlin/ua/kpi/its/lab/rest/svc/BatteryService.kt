package ua.kpi.its.lab.rest.svc

import ua.kpi.its.lab.rest.dto.BatteryRequest
import ua.kpi.its.lab.rest.dto.BatteryResponse
interface BatteryService {
    fun createBattery(req: BatteryRequest): BatteryResponse
    fun getBatteryById(id: Long): BatteryResponse
    fun updateBatteryById(id: Long, req: BatteryRequest): BatteryResponse
    fun deleteBatteryById(id: Long): Boolean
}