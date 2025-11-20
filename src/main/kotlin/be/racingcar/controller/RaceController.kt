package be.racingcar.controller

import be.racingcar.domain.car.Cars
import be.racingcar.domain.random.Dice
import be.racingcar.domain.round.Round
import be.racingcar.view.OutputView

class RaceController(
    private val dice: Dice,
    private val cars: Cars,
    private val round: Round,
) {

    fun startRace() {
        OutputView.printCarsPositionPrompt()
        while (round.canNext()) {
            cars.moveAll(dice)
            OutputView.printCarsPosition(cars.toCarDtos())
            round.proceed()
        }
    }

    fun endRace() {
        OutputView.printWinners(cars.toWinnerDtos())
    }

}
