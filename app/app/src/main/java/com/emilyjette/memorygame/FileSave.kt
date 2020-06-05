package com.emilyjette.memorygame

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity

class FileSave(var activity: Activity?) {

    fun save() {
         activity?.getSharedPreferences("game", AppCompatActivity.MODE_PRIVATE)?.edit()?.putInt("highscore",User.highscore)?.apply()
    }

    fun load(){
        User.highscore=activity?.getSharedPreferences("game", AppCompatActivity.MODE_PRIVATE)?.getInt("highscore",0) ?: 0

    }
    fun savetotalwins () {
        activity?.getSharedPreferences("game", AppCompatActivity.MODE_PRIVATE)?.edit()?.putInt("totalwins",User.totalwins)?.apply()
    }

    fun loadtotalwins(){
        User.totalwins=activity?.getSharedPreferences("game", AppCompatActivity.MODE_PRIVATE)?.getInt("totalwins",0) ?: 0

    }
    fun savetotalgames () {
        activity?.getSharedPreferences("game", AppCompatActivity.MODE_PRIVATE)?.edit()?.putInt("totalgames",User.totalgames)?.apply()
    }

    fun loadtotalgames(){
        User.totalgames=activity?.getSharedPreferences("game", AppCompatActivity.MODE_PRIVATE)?.getInt("totalgames",0) ?: 0

    }
}