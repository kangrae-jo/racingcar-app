package be.racingcar.api

data class ApiErrorResponse(
    val message: String,
    val errors: Map<String, String> = emptyMap(),
)
