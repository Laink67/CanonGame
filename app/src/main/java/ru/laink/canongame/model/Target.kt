package ru.laink.canongame.model

import ru.laink.canongame.CannonView

// Мишень
class Target(
    view: CannonView,
    color: Int,
    soundId: Int,
    x: Int,
    y: Int,
    width: Int,
    length: Int,
    velocityY: Float,
    hitReward: Int
) : GameElement(view, color, soundId, x, y, width, length, velocityY) {
    var hitReward = 0

    init {
        this.hitReward = hitReward
    }

}