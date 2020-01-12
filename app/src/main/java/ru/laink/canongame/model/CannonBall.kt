package ru.laink.canongame.model

import ru.laink.canongame.CannonView

class CannonBall(
    view: CannonView,
    color: Int,
    soundId: Int,
    x: Int,
    y: Int,
    radius: Int,
    velocityX: Float,
    velocityY: Float
) : GameElement(view, color, soundId, x, y, 2 * radius, 2 * radius, velocityY) {
    private var velocityX = 0f
    private var onScreen = false

    init {
        this.velocityX = velocityX
        onScreen = true
    }
}