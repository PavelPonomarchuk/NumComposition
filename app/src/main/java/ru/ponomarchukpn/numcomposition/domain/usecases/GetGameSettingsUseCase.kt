package ru.ponomarchukpn.numcomposition.domain.usecases

import ru.ponomarchukpn.numcomposition.domain.entity.GameSettings
import ru.ponomarchukpn.numcomposition.domain.entity.Level
import ru.ponomarchukpn.numcomposition.domain.repository.GameRepository

class GetGameSettingsUseCase(
    private val repository: GameRepository
) {

    operator fun invoke(level: Level): GameSettings {
        return repository.getGameSettings(level)
    }
}
