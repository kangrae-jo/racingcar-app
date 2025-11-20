package be.racingcar.controller

import be.racingcar.application.RaceService
import be.racingcar.application.dto.RaceRequest
import jakarta.validation.Valid
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping

@Controller
class RaceController(
    private val raceService: RaceService,
) {

    @GetMapping("/")
    fun showForm(model: Model): String {
        if (!model.containsAttribute("request")) {
            model.addAttribute("request", RaceRequest())
        }
        return "race"
    }

    @PostMapping("/race")
    fun runRace(
        @Valid @ModelAttribute("request") request: RaceRequest,
        bindingResult: BindingResult,
        model: Model,
    ): String {
        if (bindingResult.hasErrors()) {
            model.addAttribute("result", null)
            return "race"
        }
        return try {
            val result = raceService.runRace(request)
            model.addAttribute("result", result)
            model.addAttribute("errorMessage", null)
            "race"
        } catch (exception: IllegalArgumentException) {
            model.addAttribute("result", null)
            model.addAttribute("errorMessage", exception.message ?: "유효하지 않은 입력입니다.")
            "race"
        }
    }

}
