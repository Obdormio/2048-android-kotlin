package org.eternal.game.kotlin2048

import android.util.Log

class UnitManager(view: GameView) : ViewComponent(view) {

    val rectUnits = arrayListOf<RectUnit>()

    fun getOneUnusedPosition(): Pair<Int, Int> {
        val array = arrayListOf<Int>()
        for (x in 1..16) {
            var notExistFlag = true
            rectUnits.takeWhile {
                val p = it.col + it.row * 4
                notExistFlag = p != x
                notExistFlag
            }
            if (notExistFlag) array.add(x)
        }

        if (array.size == 0) return Pair(-1, -1)

        val index = (0..(array.size - 1)).random()
        val value = array[index]
        return Pair(value % 4, value / 4)
    }

    fun addUnit() {
        val (col, row) = getOneUnusedPosition()
        rectUnits.add(RectUnit().apply {
            this@apply.row = row
            this@apply.col = col
        })
    }
}
