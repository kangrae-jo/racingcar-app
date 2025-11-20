package be.racingcar.domain.car

class Name(name: String) {

    val name: String

    init {
        val trimmed = name.trim()
        validateNameLength(trimmed)
        this.name = trimmed
    }

    private fun validateNameLength(name: String) {
        if (name.isEmpty() || name.length > LENGTH_LIMIT) {
            throw IllegalArgumentException("[ERROR] 자동차 이름은 1자 이상 ${LENGTH_LIMIT}자 이하입니다.")
        }
    }

    companion object {
        private const val LENGTH_LIMIT = 5
    }

}
