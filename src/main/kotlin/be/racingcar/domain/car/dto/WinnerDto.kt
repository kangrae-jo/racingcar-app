package be.racingcar.domain.car.dto

import be.racingcar.domain.car.Car

data class WinnerDto(val name: String) {

    companion object {
        fun from(car: Car): WinnerDto = WinnerDto(car.getName())
    }

}
