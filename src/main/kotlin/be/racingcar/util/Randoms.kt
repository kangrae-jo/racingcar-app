package be.racingcar.util

import java.util.Collections
import java.util.concurrent.ThreadLocalRandom

object Randoms {

    private val defaultRandom = ThreadLocalRandom.current()

    fun pickNumberInRange(startInclusive: Int, endInclusive: Int): Int {
        validateRange(startInclusive, endInclusive)
        return startInclusive + defaultRandom.nextInt(endInclusive - startInclusive + 1)
    }

    private fun validateRange(startInclusive: Int, endInclusive: Int) {
        if (startInclusive > endInclusive) {
            throw IllegalArgumentException("startInclusive cannot be greater than endInclusive.")
        }
        if (endInclusive == Int.MAX_VALUE) {
            throw IllegalArgumentException("endInclusive cannot be greater than Integer.MAX_VALUE.")
        }
        if (endInclusive - startInclusive >= Int.MAX_VALUE) {
            throw IllegalArgumentException("the input range is too large.")
        }
    }

}
