package com.emilyjette.memorygame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView.text="Hello "+User.name
    }
    fun onClick(view:View){
        var intent= Intent(this,GameSActivity::class.java)
        startActivity(intent)
    }
}
