package com.emilyjette.memorygame

import androidx.appcompat.app.AppCompatActivity

class FileSave(var activity:GameSActivity?) {
    fun save() {
         activity?.getSharedPreferences("game", AppCompatActivity.MODE_PRIVATE)?.edit()?.putInt("highscore",User.highscore)?.apply()
    }

    fun load(){
        User.highscore=activity?.getSharedPreferences("game", AppCompatActivity.MODE_PRIVATE)?.getInt("highscore",0) ?: 0

    }
}