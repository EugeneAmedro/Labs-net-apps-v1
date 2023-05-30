package ua.kpi.its.lab.rest.dto

class CarRequest {
    var brand: String? = null
        private set
    var manufacturer: String? = null
        private set
    var model: String? = null
        private set

    constructor()
    constructor(brand: String?, manufacturer: String?, model: String?) {
        this.brand = brand
        this.manufacturer = manufacturer
        this.model = model
    }
}


class CarResponse {
    var id: Long? = null
        private set
    var brand: String? = null
        private set
    var manufacturer: String? = null
        private set
    var model: String? = null
        private set

    constructor()
    constructor(id: Long?, brand: String?, manufacturer: String?, model: String?) {
        this.id = id
        this.brand = brand
        this.manufacturer = manufacturer
        this.model = model
    }
}


class BatteryRequest {
    var model: String? = null
        private set
    var manufacturer: String? = null
        private set
    var type: Double? = null
        private set

    constructor()
    constructor(model: String?, manufacturer: String?, type: Double?) {
        this.model = model
        this.manufacturer = manufacturer
        this.type = type
    }
}


class BatteryResponse {
    var id: Long? = null
        private set
    var model: String? = null
        private set
    var manufacturer: String? = null
        private set
    var type: Double? = null
        private set

    constructor()
    constructor(id: Long?, model: String?, manufacturer: String?, type: Double?) {
        this.id = id
        this.model = model
        this.manufacturer = manufacturer
        this.type = type
    }
}