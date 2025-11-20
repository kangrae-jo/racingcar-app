package be.racingcar.domain.car.dto

data class CarMoveResult(
    val name: String,
    val fromPosition: Int,
    val toPosition: Int,
    val diceValue: Int,
)
