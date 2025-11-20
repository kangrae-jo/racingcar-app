package be.racingcar.view

import camp.nextstep.edu.missionutils.Console

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
