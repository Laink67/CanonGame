package ru.laink.canongame

import android.media.AudioManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

// Создаёт и управляет CannonView
class MainActivityFragment : Fragment() {

    private lateinit var cannonView: CannonView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        val view = inflater.inflate(R.layout.fragment_main, container, false)
        cannonView = view.findViewById(R.id.cannonView)

        return view
    }

    // Настройка управления громкостью при создании активности
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activity?.volumeControlStream = AudioManager.STREAM_MUSIC
    }


    // Пауза MainActivity завершает игру
    override fun onPause() {
        super.onPause()
        cannonView.stopGame()
    }

    // Остановка MainActivity освобождает ресурсы
    override fun onDestroy() {
        super.onDestroy()
        cannonView.releaseResources()
    }
}