@file:Suppress("DEPRECATION")

package com.emilyjette.memorygame

import android.content.Intent
import android.content.res.ColorStateList
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.ImageButton
import kotlinx.android.synthetic.main.activity_game_s.*


class GameSActivity : AppCompatActivity() {

    var game:Game=Game()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_s)
        setup() //step 1
        startAgain()

    }
    
    fun onClick(view:View){
        game.click(view.id)
    }

    fun setup(){
        bluegametile.oldcolor= blueButton.backgroundTintList
        redgametile.oldcolor= redButton.backgroundTintList
        greengametile.oldcolor= greenButton.backgroundTintList
        yellowgametile.oldcolor= yellowButton.backgroundTintList

        bluegametile.button=blueButton
        redgametile.button=redButton
        greengametile.button=greenButton
        yellowgametile.button=yellowButton

        setofcolors= setOf(redgametile,bluegametile,greengametile,yellowgametile)
    }

    fun ImageButton.flash(time:Long,oldColor:ColorStateList?){
        Handler(Looper.getMainLooper()).postDelayed({
            this.backgroundTintList = resources.getColorStateList(R.color.flash_list_color)
        }, time)
        Handler(Looper.getMainLooper()).postDelayed({
            this.backgroundTintList = oldColor
        }, time+500)
    }

    fun nextPage(){
        var intent= Intent(this,ExitActivity::class.java)
        startActivity(intent)
    }

    fun startAgain(){
        timesclicked=0
        order.clear()
        for(count in 1 ..8) {
            var tile = setofcolors.random()
            order.add(tile)
            tile.button?.flash(1000L * count, tile.oldcolor)
        }
        User.playtimegames+=1
        User.score=0
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        startAgain()
    }

}
