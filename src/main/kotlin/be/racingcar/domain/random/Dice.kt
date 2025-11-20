package be.racingcar.domain.random

import be.racingcar.util.Randoms

class Dice {

    private var number: Int = 0

    fun reroll() {
        number = Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE)
    }

    fun canMove(threshold: Int): Boolean = number >= threshold

    companion object {
        private const val START_INCLUSIVE = 0
        private const val END_INCLUSIVE = 9
    }

}
