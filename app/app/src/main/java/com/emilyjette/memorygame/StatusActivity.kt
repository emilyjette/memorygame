package com.emilyjette.memorygame

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.emilyjette.memorygame.User.totalgames
import kotlinx.android.synthetic.main.activity_status.*

class StatusActivity : AppCompatActivity() {
    var fileSave= FileSave(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_status)
        Context.UI_MODE_SERVICE
        playedStatus.text=""+User.totalgames
        winStatus.text=""+User.totalwins
        fileSave.load()
        highStatus.text=""+User.highscore
        currentStatus.text=""+User.playtimescore

        Handler(Looper.getMainLooper()).postDelayed({
            finish()
        }, 5000)
    }
}
