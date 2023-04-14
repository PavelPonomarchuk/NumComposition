package ru.ponomarchukpn.numcomposition.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
enum class Level: Parcelable {

    EASY, NORMAL, HARD
}
