

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

    var game:Game=Game(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_s)
        setup() //step 1
        game.startAgain()

    }

    fun onClick(view:View){
        game.click(view.id)
    }

    fun setup(){
        game.bluegametile.oldcolor= blueButton.backgroundTintList
        game.redgametile.oldcolor= redButton.backgroundTintList
        game.greengametile.oldcolor= greenButton.backgroundTintList
        game.yellowgametile.oldcolor= yellowButton.backgroundTintList

        game.bluegametile.button=blueButton
        game.redgametile.button=redButton
        game.greengametile.button=greenButton
        game.yellowgametile.button=yellowButton

        game.bluegametile.id=blueButton.id
        game.redgametile.id=redButton.id
        game.greengametile.id=greenButton.id
        game.yellowgametile.id=yellowButton.id

        game.setup()
    }

    fun nextPage(){
        var intent= Intent(this,ExitActivity::class.java)
        startActivity(intent)
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        game.startAgain()
    }

    fun goToStatusActivity(){
        var intent= Intent(this,StatusActivity::class.java)
        startActivityForResult(intent,1)
    }

}
