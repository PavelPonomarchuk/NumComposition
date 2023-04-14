package ru.ponomarchukpn.numcomposition.data

import ru.ponomarchukpn.numcomposition.domain.entity.GameSettings
import ru.ponomarchukpn.numcomposition.domain.entity.Level
import ru.ponomarchukpn.numcomposition.domain.entity.Question
import ru.ponomarchukpn.numcomposition.domain.repository.GameRepository
import kotlin.math.max
import kotlin.math.min
import kotlin.random.Random

object GameRepositoryImpl: GameRepository {

    private const val MIN_SUM_VALUE = 2
    private const val MIN_ANSWER_VALUE = 1

    override fun generateQuestion(maxSumValue: Int, countOfOptions: Int): Question {
        val sum = Random.nextInt(MIN_SUM_VALUE, maxSumValue + 1)
        val visibleNumber = Random.nextInt(MIN_ANSWER_VALUE, sum)
        val options = HashSet<Int>()
        val rightAnswer = sum - visibleNumber
        val from = max(rightAnswer - countOfOptions, MIN_ANSWER_VALUE)
        val to = min(maxSumValue, rightAnswer + countOfOptions)

        options.add(rightAnswer)
        while (options.size < countOfOptions) {
            options.add(Random.nextInt(from, to))
        }
        return Question(sum, visibleNumber, options.toList().shuffled())
    }

    override fun getGameSettings(level: Level): GameSettings {
        return when(level) {
            Level.EASY -> {
                GameSettings(
                    10,
                    10,
                    50,
                    120
                )
            }
            Level.NORMAL -> {
                GameSettings(
                    10,
                    10,
                    70,
                    60
                )
            }
            Level.HARD -> {
                GameSettings(
                    20,
                    15,
                    90,
                    60
                )
            }
        }
    }
}
