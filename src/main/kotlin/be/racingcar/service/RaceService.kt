package be.racingcar.service

import be.racingcar.dto.RaceRequest
import be.racingcar.dto.RaceResult
import be.racingcar.dto.RaceRoundSnapshot
import be.racingcar.domain.car.Cars
import be.racingcar.domain.random.Dice
import be.racingcar.domain.round.Round
import org.springframework.stereotype.Service

@Service
class RaceService {

    fun runRace(request: RaceRequest): RaceResult {
        val cars = Cars(request.carNames)
        val round = Round(request.totalRound.toString())
        val dice = Dice()

        val rounds = mutableListOf<RaceRoundSnapshot>()
        while (round.canNext()) {
            cars.moveAll(dice)
            val currentRound = round.proceed()
            rounds.add(RaceRoundSnapshot(currentRound, cars.toCarDtos()))
        }

        return RaceResult(rounds.toList(), cars.toWinnerDtos())
    }

}
