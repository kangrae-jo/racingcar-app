package be.racingcar.dto

import be.racingcar.domain.car.dto.CarDto
import be.racingcar.domain.car.dto.WinnerDto

data class RaceResult(
    val rounds: List<RaceRoundSnapshot>,
    val winners: List<WinnerDto>,
    val events: List<RaceTurnEvent>,
)

data class RaceRoundSnapshot(
    val round: Int,
    val cars: List<CarDto>,
)

data class RaceTurnEvent(
    val round: Int,
    val carName: String,
    val diceValue: Int,
    val fromPosition: Int,
    val toPosition: Int,
)
