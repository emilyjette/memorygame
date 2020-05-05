package com.emilyjette.memorygame

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.emilyjette.memorygame.User.totalgames
import kotlinx.android.synthetic.main.activity_status.*

class StatusActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_status)
        Context.UI_MODE_SERVICE
        playedStatus.text=""+User.totalgames
        winStatus.text=""+User.totalwins
        highStatus.text=""+User.highscore//19?
        currentStatus.text=""+User.playtimescore//19?

        Handler(Looper.getMainLooper()).postDelayed({
            finish()
        }, 8000)
    }
}
