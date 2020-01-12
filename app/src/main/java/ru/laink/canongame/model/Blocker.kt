package ru.laink.canongame.model

import ru.laink.canongame.CannonView

class Blocker(
    view: CannonView,
    color: Int,
    soundId: Int,
    x: Int,
    y: Int,
    width: Int,
    length: Int,
    velocityY: Float,
    missPenalty: Int
) : GameElement(view, color, soundId, x, y, width, length, velocityY) {
    var missPenalty: Int = 0

    init {
        this.missPenalty = missPenalty
    }
}