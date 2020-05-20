@file:Suppress("DEPRECATION")
package com.emilyjette.memorygame

import android.content.Intent
import android.content.res.ColorStateList
import android.os.Handler
import android.os.Looper
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class Game(var activity:GameSActivity?) {
    var redgametile = GameTiles()
    var bluegametile = GameTiles()
    var greengametile = GameTiles()
    var yellowgametile = GameTiles()
    var timesclicked = 0
    lateinit var setofcolors: Set<GameTiles>
    var order = mutableListOf<GameTiles>()
    var fileSave= FileSave(activity)

    fun click(id: Int) {

        if (timesclicked < 8) {
            var clicked = id
            var tile = order[timesclicked]
            timesclicked += 1
            println(clicked)
            println(tile.button?.id)
            if (checkIfRight(clicked, tile)) {
                User.score += 1
                println(User.score)
                if (User.score == 8) {
                    win()
                }
            } else {
                lose()
            }
        } else {
            lose()
        }
    }

    fun checkIfRight(clicked: Int, tile: GameTiles): Boolean {
        return clicked == tile.id
    }

    fun win(){
        User.playtimewins+=1
        User.playtimescore=User.playtimewins*8
        activity?.goToStatusActivity()
    }

    fun lose(){
        println("wrong")
        User.playtimescore=User.playtimewins*8+User.score
        fileSave.load()
        if(User.playtimescore>User.highscore){
            User.highscore=User.playtimescore
           fileSave.save()
        }
        User.playtimewins=0
        activity?.nextPage()
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

    fun ImageButton.flash(time:Long, oldColor: ColorStateList?){
        Handler(Looper.getMainLooper()).postDelayed({
            this.backgroundTintList = resources.getColorStateList(R.color.flash_list_color)
        }, time)
        Handler(Looper.getMainLooper()).postDelayed({
            this.backgroundTintList = oldColor
        }, time+500)
    }

    fun setup(){
        setofcolors= setOf(redgametile,bluegametile,greengametile,yellowgametile)
    }
}