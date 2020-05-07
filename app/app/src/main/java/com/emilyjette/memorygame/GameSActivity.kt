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

    var redgametile=GameTiles()
    var bluegametile=GameTiles()
    var greengametile=GameTiles()
    var yellowgametile=GameTiles()
    var timesclicked=0
    lateinit var setofcolors:Set<GameTiles>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_s)
        setup() //step 1
        startAgain()

    }
    fun onClick(view:View){

        if (timesclicked <8) {
            var clicked=view.id
            var tile = order[timesclicked]
            timesclicked += 1
            println(clicked)
            println(tile.button?.id)
            if (checkIfRight(clicked, tile)) {
                User.score += 1
                println(User.score)
                if (User.score==8){
                  win()
                }
            }
            else{
                lose()
            }
        }
        else{
            lose()
        }
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
    fun win(){
        User.playtimewins+=1
        var intent= Intent(this,StatusActivity::class.java)
        startActivityForResult(intent,1)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        startAgain()
    }

    fun lose(){
        println("wrong")
        User.playtimescore=User.playtimewins*8+User.score
        if(User.playtimescore>User.highscore){
            User.highscore=User.playtimescore
        }
        User.playtimewins=0
        nextPage()
    }
}
