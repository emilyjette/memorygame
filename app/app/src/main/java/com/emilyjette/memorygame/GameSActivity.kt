@file:Suppress("DEPRECATION")

package com.emilyjette.memorygame

import android.content.res.ColorStateList
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import kotlinx.android.synthetic.main.activity_game_s.*
import java.lang.Thread.sleep

class GameSActivity : AppCompatActivity() {

    var redgametile=GameTiles()
    var bluegametile=GameTiles()
    var greengametile=GameTiles()
    var yellowgametile=GameTiles()
    var x=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_s)
        setup() //step 1
        var setofcolors= setOf(redgametile,bluegametile,greengametile,yellowgametile)
        for(count in 1 ..8) {
            var tile = setofcolors.random()
            order.add(tile)
            tile.button?.flash(1000L * count, tile.oldcolor)

        }

    }
    fun onClick(view:View){
        if (x <8) {
            var clicked=view.id
            var tile = order[x]
            x += 1
            println(clicked)
            println(tile.button?.id)
            if (checkIfRight(clicked, tile)) {
                User.score += 1
                println(User.score)
                if (User.score==8){
                    //winner
                    User.totalwins+=1
                    User.highscore=8
                }
            }
            else{
//                println("wrong")
                User.highscore=User.score
            }
        }
        else{}
    }

    fun checkIfRight(clicked:Int, tile:GameTiles):Boolean{
         return clicked==tile.button?.id
    }

    var order= mutableListOf<GameTiles>()

    fun setup(){

        bluegametile.oldcolor= blueButton.backgroundTintList
        redgametile.oldcolor= redButton.backgroundTintList
        greengametile.oldcolor= greenButton.backgroundTintList
        yellowgametile.oldcolor= yellowButton.backgroundTintList

        bluegametile.button=blueButton
        redgametile.button=redButton
        greengametile.button=greenButton
        yellowgametile.button=yellowButton

        User.score=0
        x=0

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
