package be.racingcar.dto

import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank

data class RaceRequest(
    @field:NotBlank(message = "자동차 이름을 입력하세요.")
    var carNames: String = "",

    @field:Min(value = 1, message = "라운드는 1 이상이어야 합니다.")
    @field:Max(value = 1000, message = "라운드는 1000 이하만 가능합니다.")
    var totalRound: Int = 1,
)
