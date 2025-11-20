package be.racingcar.domain.car

import be.racingcar.domain.random.Dice

class Car(name: String) {

    private val carName = Name(name)
    private val position = Position(INIT_POSITION)

    fun attemptToMove(dice: Dice) {
        if (dice.canMove(THRESHOLD)) {
            position.move(MOVE_AMOUNT)
        }
    }

    fun getPosition(): Int = position.position

    fun getName(): String = carName.name

    companion object {
        private const val INIT_POSITION = 0
        private const val MOVE_AMOUNT = 1
        private const val THRESHOLD = 4
    }

}
