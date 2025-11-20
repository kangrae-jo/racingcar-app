package be.racingcar.view

import be.racingcar.util.Console

object InputView {

    fun readCarNames(): String {
        OutputView.printCarNamePrompt()
        return Console.readLine()
    }

    fun readTotalRound(): String {
        OutputView.printRoundPrompt()
        return Console.readLine()
    }

}
