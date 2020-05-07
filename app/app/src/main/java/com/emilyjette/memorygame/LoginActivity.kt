package com.emilyjette.memorygame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        username.setText(getSharedPreferences("game",MODE_PRIVATE).getString("name",""))
    }
    fun onClick(view:View){
        User.name=username.text.toString()
        getSharedPreferences("game",MODE_PRIVATE).edit().putString("name",User.name).apply()
        var intent= Intent(this,MainActivity::class.java)
        startActivity(intent)

    }
}
