package be.racingcar.service

import be.racingcar.dto.RaceRequest
import be.racingcar.dto.RaceResult
import be.racingcar.dto.RaceRoundSnapshot
import be.racingcar.dto.RaceTurnEvent
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
        val events = mutableListOf<RaceTurnEvent>()
        while (round.canNext()) {
            val moves = cars.moveAll(dice)
            val currentRound = round.proceed()
            rounds.add(RaceRoundSnapshot(currentRound, cars.toCarDtos()))
            moves.forEach { move ->
                events.add(
                    RaceTurnEvent(
                        round = currentRound,
                        carName = move.name,
                        diceValue = move.diceValue,
                        fromPosition = move.fromPosition,
                        toPosition = move.toPosition,
                    ),
                )
            }
        }

        return RaceResult(
            rounds = rounds.toList(),
            winners = cars.toWinnerDtos(),
            events = events.toList(),
        )
    }

}
