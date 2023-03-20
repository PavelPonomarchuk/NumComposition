package ru.ponomarchukpn.numcomposition.domain.repository

import ru.ponomarchukpn.numcomposition.domain.entity.GameSettings
import ru.ponomarchukpn.numcomposition.domain.entity.Level
import ru.ponomarchukpn.numcomposition.domain.entity.Question

interface GameRepository {

    fun generateQuestion(
        maxSumValue: Int,
        countOfOptions: Int
    ): Question

    fun getGameSettings(level: Level): GameSettings
}
