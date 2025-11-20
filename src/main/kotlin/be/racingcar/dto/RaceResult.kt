package be.racingcar.dto

import be.racingcar.domain.car.dto.CarDto
import be.racingcar.domain.car.dto.WinnerDto

data class RaceResult(
    val rounds: List<RaceRoundSnapshot>,
    val winners: List<WinnerDto>,
)

data class RaceRoundSnapshot(
    val round: Int,
    val cars: List<CarDto>,
)
