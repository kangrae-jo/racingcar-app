package be.racingcar.api

import be.racingcar.application.RaceService
import be.racingcar.application.dto.RaceRequest
import be.racingcar.application.dto.RaceResult
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/race")
class RaceRestController(
    private val raceService: RaceService,
) {

    @PostMapping
    fun runRace(@Valid @RequestBody request: RaceRequest): RaceResult {
        return raceService.runRace(request)
    }
}
