package com.emilyjette.memorygame

object User {
    var name:String=""
    var playtimegames:Int=0
    var playtimewins:Int=0
    var score:Int=0//1-8 per game
    var highscore:Int=0
    var playtimescore:Int=0
    var totalgames:Int=0
    var totalwins:Int=0

    fun reset(){
        name=""
        playtimegames=0
        playtimewins=0
        score=0//1-8 per game
        highscore=0
        playtimescore=0
        totalgames=0
        totalwins=0
    }
}
