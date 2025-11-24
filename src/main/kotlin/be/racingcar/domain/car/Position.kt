package be.racingcar.domain.car

class Position(initialPosition: Int) {

    var position: Int = initialPosition
        private set

    fun move(step: Int): Int {
        position += step
        return position
    }

}
