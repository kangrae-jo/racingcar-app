package be.racingcar.api

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice(assignableTypes = [RaceRestController::class])
class ApiExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleValidation(exception: MethodArgumentNotValidException): ResponseEntity<ApiErrorResponse> {
        val errors = exception
            .bindingResult
            .fieldErrors
            .associate { error ->
                error.field to (error.defaultMessage ?: "유효하지 않은 값입니다.")
            }
        val response = ApiErrorResponse(
            message = "입력 값을 확인해주세요.",
            errors = errors,
        )
        return ResponseEntity.badRequest().body(response)
    }

    @ExceptionHandler(IllegalArgumentException::class)
    fun handleIllegalArgument(exception: IllegalArgumentException): ResponseEntity<ApiErrorResponse> {
        val response = ApiErrorResponse(
            message = exception.message ?: "잘못된 요청입니다.",
        )
        return ResponseEntity.badRequest().body(response)
    }

}
