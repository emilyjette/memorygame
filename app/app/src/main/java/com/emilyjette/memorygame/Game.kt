package com.emilyjette.memorygame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

class Game {
    var redgametile = GameTiles()
    var bluegametile = GameTiles()
    var greengametile = GameTiles()
    var yellowgametile = GameTiles()
    var timesclicked = 0
    lateinit var setofcolors: Set<GameTiles>
    var order = mutableListOf<GameTiles>()

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
        return clicked == tile.button?.id
    }

    fun win(){
        User.playtimewins+=1
        User.playtimescore=User.playtimewins*8
        var intent= Intent(this,StatusActivity::class.java)
        startActivityForResult(intent,1)
    }

    fun lose(){
        println("wrong")
        User.playtimescore=User.playtimewins*8+User.score
        User.highscore=getSharedPreferences("game", AppCompatActivity.MODE_PRIVATE).getInt("highscore",0)
        if(User.playtimescore>User.highscore){
            User.highscore=User.playtimescore
            getSharedPreferences("game", AppCompatActivity.MODE_PRIVATE).edit().putInt("highscore",User.highscore).apply()
        }
        User.playtimewins=0
        nextPage()
    }
}