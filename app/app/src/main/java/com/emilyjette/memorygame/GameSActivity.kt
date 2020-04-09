@file:Suppress("DEPRECATION")

package com.emilyjette.memorygame

import android.content.res.ColorStateList
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.ImageButton
import kotlinx.android.synthetic.main.activity_game_s.*
import java.lang.Thread.sleep

class GameSActivity : AppCompatActivity() {
    var oldRedcolor:ColorStateList?=null
    var oldBluecolor:ColorStateList?=null
    var oldGreencolor:ColorStateList?=null
    var oldYellowcolor:ColorStateList?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_s)

        oldBluecolor= blueButton.backgroundTintList
        oldRedcolor= redButton.backgroundTintList
        oldGreencolor= greenButton.backgroundTintList
        oldYellowcolor= yellowButton.backgroundTintList
        redButton.flash(500,oldRedcolor)
        blueButton.flash(1000,oldBluecolor)
        greenButton.flash(1500,oldGreencolor)
        yellowButton.flash(2000,oldYellowcolor)
        redButton.flash(3500,oldRedcolor)
    }

    fun ImageButton.flash(time:Long,oldColor:ColorStateList?){
        Handler(Looper.getMainLooper()).postDelayed({
            this.backgroundTintList = resources.getColorStateList(R.color.flash_list_color)
        }, time)
        Handler(Looper.getMainLooper()).postDelayed({
            this.backgroundTintList = oldColor
        }, time+1000)

    }
}
