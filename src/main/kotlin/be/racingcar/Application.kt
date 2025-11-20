package be.racingcar

import be.racingcar.controller.RaceController
import be.racingcar.domain.car.Cars
import be.racingcar.domain.random.Dice
import be.racingcar.domain.round.Round
import be.racingcar.util.Console
import be.racingcar.view.InputView

fun main() {

    val names = InputView.readCarNames()
    val cars = Cars(names)

    val totalRound = InputView.readTotalRound()
    val round = Round(totalRound)
    Console.close()

    val controller = RaceController(Dice(), cars, round)
    controller.startRace()
    controller.endRace()

}
