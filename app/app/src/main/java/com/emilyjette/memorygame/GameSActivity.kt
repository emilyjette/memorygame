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
    var maximumclicks=8
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
                if (User.score==maximumclicks){
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

        User.score=0
        timesclicked=0
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
        for(count in 1 ..8) {
            var tile = setofcolors.random()
            order.add(tile)
            tile.button?.flash(1000L * count, tile.oldcolor)

        }
    }
    fun win(){
        User.totalwins+=1
        maximumclicks +=8
        User.highscore=8*User.totalwins
        startAgain()
        timesclicked=0
        
    }
    fun lose(){
        println("wrong")
        User.highscore= kotlin.math.max(User.highscore, User.score)
        nextPage()
    }
}
