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
        setup() //step 1
        for(count in 1 ..8){
            greenButton.flash(10  00L*count,oldGreencolor)
        }


//        redButton.flash(500,oldRedcolor)
//        blueButton.flash(1500,oldBluecolor)
//        greenButton.flash(2500,oldGreencolor)
//        yellowButton.flash(3500,oldYellowcolor)
//        redButton.flash(4500,oldRedcolor)
//        greenButton.flash(5500,oldGreencolor)
//        blueButton.flash(6500,oldBluecolor)
//        yellowButton.flash(7500,oldYellowcolor)




    }
    fun setup(){
        oldBluecolor= blueButton.backgroundTintList
        oldRedcolor= redButton.backgroundTintList
        oldGreencolor= greenButton.backgroundTintList
        oldYellowcolor= yellowButton.backgroundTintList
    }
    fun ImageButton.flash(time:Long,oldColor:ColorStateList?){
        Handler(Looper.getMainLooper()).postDelayed({
            this.backgroundTintList = resources.getColorStateList(R.color.flash_list_color)
        }, time)
        Handler(Looper.getMainLooper()).postDelayed({
            this.backgroundTintList = oldColor
        }, time+500)

    }
}
