package com.example.myshifoumi.navigation

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
open class GameNavigation : Parcelable

@Parcelize
object PlayerGame : GameNavigation(), Parcelable

@Parcelize
object ComputerGame : GameNavigation(), Parcelable
