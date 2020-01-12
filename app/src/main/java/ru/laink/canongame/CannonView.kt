package ru.laink.canongame

import android.content.Context
import android.util.AttributeSet
import android.view.SurfaceView


class CannonView(context: Context?, attrs: AttributeSet?) : SurfaceView(context, attrs) {

    var screenWidth: Int = 0
    var screenHeight: Int = 0

    companion object {
        const val CANNONBALL_RADIUS_PERCENT = 3.0 / 80
        const val CANNON_SOUND_ID = 1
        const val CANNONBALL_SPEED_PERCENT = 3.0 / 2
    }


    fun stopGame() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun releaseResources() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun playSound(soundId: Int) {

    }


}