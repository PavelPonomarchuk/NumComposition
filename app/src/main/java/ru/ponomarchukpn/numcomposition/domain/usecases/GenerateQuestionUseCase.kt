package ru.ponomarchukpn.numcomposition.domain.usecases

import ru.ponomarchukpn.numcomposition.domain.entity.Question
import ru.ponomarchukpn.numcomposition.domain.repository.GameRepository

class GenerateQuestionUseCase(
    private val repository: GameRepository
) {

    operator fun invoke(maxSumValue: Int): Question {
        return repository.generateQuestion(maxSumValue, COUNT_OF_OPTIONS)
    }

    private companion object {

        private const val COUNT_OF_OPTIONS = 6
    }
}
