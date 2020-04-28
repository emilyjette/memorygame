package com.emilyjette.memorygame

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_exit.*

class ExitActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exit)
        if (User.score==1){
            textView3.text="You got 1 point. Good Job"
        }
        else{
            textView3.text="You got "+ User.score +" points. Good Job"
        }
        //textView4.text="Hello again, "+ User.name
    }
}
