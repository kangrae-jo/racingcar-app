package be.racingcar.domain.round

class Round(totalRound: String) {

    private val totalRound: Int
    private var currentRound: Int = 0

    init {
        val parsedRound = totalRound.toIntOrNull()
            ?: throw IllegalArgumentException("[ERROR] 라운드는 숫자만 입력 가능합니다.")
        validateTotalRound(parsedRound)
        this.totalRound = parsedRound
    }

    fun canNext(): Boolean = totalRound > currentRound

    fun proceed(): Int {
        if (!canNext()) {
            throw IllegalArgumentException("[ERROR] 진행할 라운드가 없습니다.")
        }
        currentRound += 1
        return currentRound
    }

    private fun validateTotalRound(round: Int) {
        if (round < MIN_ROUND || round > MAX_ROUND) {
            throw IllegalArgumentException("[ERROR] 라운드는 ${MIN_ROUND} 이상 ${MAX_ROUND} 이하만 가능합니다.")
        }
    }

    companion object {
        private const val MIN_ROUND = 1
        private const val MAX_ROUND = 1000
    }

}
