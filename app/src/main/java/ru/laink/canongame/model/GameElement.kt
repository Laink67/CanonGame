package ru.laink.canongame.model

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import ru.laink.canongame.CannonView

open class GameElement(
    private var view: CannonView,
    color: Int,
    private var soundId: Int,
    x: Int,
    y: Int,
    width: Int,
    length: Int,
    private var velocityY: Float
) {
    private val paint = Paint()
    private lateinit var shape: Rect // Ограничичваюший прямоугольник GameElement

    init {
        paint.color = color
        shape = Rect(x, y, x + width, y + length)
    }

    // Воспроизведение звукового эффекта
    fun playSound() {
        view.playSound(soundId)
    }

    // Прорисовка GameElement на Canvas
    fun draw(canvas: Canvas) {
        canvas.drawRect(shape, paint)
    }

    // Обновление позиции GameElement и проверка столкновений со стенами
    fun update(interval: Double) {
        shape.offset(0, (velocityY * interval).toInt())

        // Проверка столкновения с верхней или нижней частью экрана для отталкивания
        if (shape.top < 0 && velocityY < 0 || shape.bottom > view.getScreenHeight())
            velocityY *= -1 // Изменение скорости на противоположную
    }
}