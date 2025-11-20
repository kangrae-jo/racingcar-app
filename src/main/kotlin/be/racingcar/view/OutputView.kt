package be.racingcar.view

import be.racingcar.domain.car.dto.CarDto
import be.racingcar.domain.car.dto.WinnerDto

object OutputView {

    fun printCarNamePrompt() {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    }

    fun printRoundPrompt() {
        println("시도할 횟수는 몇 회인가요?")
    }

    fun printCarsPositionPrompt() {
        println("\n실행결과")
    }

    fun printCarsPosition(carDtos: List<CarDto>) {
        carDtos.forEach { carDto ->
            println("${carDto.name} : " + "-".repeat(carDto.position))
        }
        println()
    }

    fun printWinners(winnerDtos: List<WinnerDto>) {
        val winnerNames = winnerDtos.joinToString(", ") { it.name }
        println("최종 우승자 : $winnerNames")
    }

}
