package ru.laink.canongame.model

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Point
import ru.laink.canongame.CannonView
import kotlin.math.cos
import kotlin.math.sin

// Пушка
class Cannon(
    private var cannonView: CannonView,
    baseRadius: Int,
    barrelLength: Int,
    barrelWidth: Int
) {
    private var baseRadius = 0 // Радиус основания
    private var barrelLength = 0 // Длина ствола
    private val barrelEnd = Point() // Конечная точка ствола
    private var barrelAngle = 0.0 // Угол наклона ствола
    lateinit var cannonBall: CannonBall
    private val paint = Paint()

    init {
        this.baseRadius = baseRadius
        this.barrelLength = barrelLength
        paint.strokeWidth = barrelWidth.toFloat()
        paint.color = Color.BLACK
        align(Math.PI / 2)
    }

    // Нацеливание пушки под углом
    private fun align(barrelAngle: Double) {
        this.barrelAngle = barrelAngle
        // Координаты по центру слева (вычисляется с помощью прямоугольного треугольника)
        barrelEnd.x = (barrelLength * sin(barrelAngle)).toInt()
        barrelEnd.y = (-barrelLength * cos(barrelAngle)).toInt() + cannonView.screenHeight / 2
    }

    // Создаёт ядро и стреляет им в направлении пушки
    private fun fireCannonBall() {
        // Вычисление горизонтальной составляющей скорости ядра
        val velocityX =
            (CannonView.CANNONBALL_SPEED_PERCENT * sin(barrelAngle) * cannonView.screenWidth).toFloat()

        // Вычисление вертикальной составляющей скорости ядра
        val velocityY =
            (-CannonView.CANNONBALL_SPEED_PERCENT * cos(barrelAngle) * cannonView.screenWidth).toFloat()

        // Вычисление радиуса ядра
        val radius = (cannonView.screenHeight * CannonView.CANNONBALL_RADIUS_PERCENT).toInt()

        // Построение ядра
        cannonBall = CannonBall(
            cannonView,
            Color.BLACK,
            CannonView.CANNON_SOUND_ID,
            -radius,
            cannonView.screenHeight / 2 - radius,
            radius,
            velocityX,
            velocityY
        )

        cannonBall.playSound()
    }

    // Отрисовка пушки на экране
    private fun draw(canvas: Canvas) {
        // Рисование ствола
        canvas.drawLine(
            0f, (cannonView.screenHeight / 2).toFloat(),
            barrelEnd.x.toFloat(), barrelEnd.y.toFloat(), paint
        )

        // Отрисовка основания
        canvas.drawCircle(0f, (cannonView.screenHeight / 2).toFloat(), baseRadius.toFloat(), paint)
    }
}