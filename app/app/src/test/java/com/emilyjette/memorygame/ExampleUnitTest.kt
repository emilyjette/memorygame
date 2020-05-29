package com.emilyjette.memorygame

import kotlinx.android.synthetic.main.activity_game_s.*
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    var game=Game(null)

    companion object {
        const val Red=1
        const val Blue=2
        const val Green=3
        const val Yellow=4
        const val Wrong=5
    }
    @Before
    fun setup(){
        User.reset()

        game.bluegametile.id=Blue
        game.redgametile.id=Red
        game.greengametile.id=Green
        game.yellowgametile.id=Yellow
    }

    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
    @Test
    fun `everytime we set up pattern 8 +1 games`(){
        assertEquals(0, User.playtimegames)

        game.setup()
        game.startAgain()

        assertEquals(1, User.playtimegames)
    }
    @Test
    fun `8 correct get +1 wins`(){
        assertEquals(0,User.playtimewins)

        game.win()

        assertEquals(1,User.playtimewins)
    }
    @Test
    fun `start again score is 0`(){
        assertEquals(0, User.score)

        game.setup()
        game.startAgain()

        assertEquals(0, User.score)
    }
    @Test
    fun `if score 8 win`(){
        assertEquals(0,User.playtimewins)

        game.setup()
        game.startAgain()

        //run 8 times clicked, order and ids. clicked x8
        game.click(game.order[0].id)
        game.click(game.order[1].id)
        game.click(game.order[2].id)
        game.click(game.order[3].id)
        game.click(game.order[4].id)
        game.click(game.order[5].id)
        game.click(game.order[6].id)
        game.click(game.order[7].id)

        assertEquals(1,User.playtimewins)
    }
    @Test
    fun `if click is correct score +1`(){

        game.setup()
        game.startAgain()
        assertEquals(0, User.score)

        game.click(game.order[0].id)

        assertEquals(1, User.score)

    }
    @Test
    fun `when lose playtimescore is wins x8+score`(){

        game.setup()
        game.startAgain()

        game.win()
        game.win()
        game.click(game.order[0].id)
        game.click(game.order[1].id)
        game.click(game.order[2].id)
        game.click(game.order[3].id)
        var score=4
        var wins =2
        game.click(Wrong)

        assertEquals(wins*8+score ,User.playtimescore)
    }
    @Test
    fun`lose right away`(){
        game.setup()
        game.startAgain()


        game.click(game.order[0].id)
        game.click(game.order[1].id)
        game.click(game.order[2].id)
        game.click(game.order[3].id)
        var score=4
        var wins =0
        game.click(Wrong)

        assertEquals(wins*8+score ,User.playtimescore)
    }
    @Test
    fun`if playtimescore is greater than highscore, highscore=playtimescore`(){
        game.setup()
        game.startAgain()

        User.highscore=10
        User.playtimewins=2
//       User.score=1
        game.lose()
//        game.win()
//        game.win()
//        game.click(game.order[0].id)
//        game.click(Wrong)

        var highscore=10
        var playtimescore=16

        assertEquals(playtimescore,User.highscore)
    }
}
