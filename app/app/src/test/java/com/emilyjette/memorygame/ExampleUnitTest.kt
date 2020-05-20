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
    }
    @Before
    fun setup(){
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

    }
}
