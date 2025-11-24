package be.racingcar.domain.car.dto

import be.racingcar.domain.car.Car

data class CarDto(val name: String, val position: Int) {

    companion object {
        fun from(car: Car): CarDto = CarDto(car.getName(), car.getPosition())
    }

}
