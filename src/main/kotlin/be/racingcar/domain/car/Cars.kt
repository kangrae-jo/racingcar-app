package be.racingcar.domain.car

import be.racingcar.domain.car.dto.CarDto
import be.racingcar.domain.car.dto.CarMoveResult
import be.racingcar.domain.car.dto.WinnerDto
import be.racingcar.domain.random.Dice

class Cars(names: String) {

    private val cars: List<Car>

    init {
        val splitNames = names.split(",").toList()
        validateUniqueNames(splitNames)
        cars = splitNames.map(::Car)
    }

    fun moveAll(dice: Dice): List<CarMoveResult> {
        return cars.map { car ->
            val before = car.getPosition()
            val roll = dice.reroll()
            car.attemptToMove(dice)
            CarMoveResult(
                name = car.getName(),
                fromPosition = before,
                toPosition = car.getPosition(),
                diceValue = roll,
            )
        }
    }

    fun toCarDtos(): List<CarDto> = cars.map(CarDto::from)

    fun toWinnerDtos(): List<WinnerDto> {
        val maxPosition = cars.maxOfOrNull(Car::getPosition) ?: 0
        return cars
            .filter { it.getPosition() == maxPosition }
            .map(WinnerDto::from)
    }

    private fun validateUniqueNames(splitNames: List<String>) {
        if (splitNames.toSet().size != splitNames.size) {
            throw IllegalArgumentException("[ERROR] 자동차 이름은 중복될 수 없습니다.")
        }
    }

}
