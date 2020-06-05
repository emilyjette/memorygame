package com.emilyjette.memorygame

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_exit.*

class ExitActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exit)
        if (User.score == 1) {
            textView3.text = "You got 1 point. Good Job"
        } else {
            textView3.text = "You got " + User.playtimescore + " points. Good Job"
        }
    }
    fun onClick(view:View){
        var intent= Intent(this,MainActivity::class.java)
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent)
        finish()
    }
}
