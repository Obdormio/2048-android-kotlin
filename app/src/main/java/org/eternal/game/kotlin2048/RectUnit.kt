package org.eternal.game.kotlin2048

import android.animation.ValueAnimator
import android.graphics.Color
import android.view.animation.OvershootInterpolator

class RectUnit(private val unitManager: UnitManager) {

    var row = 1
    var col = 1
    var num = 2

    var x = 0F
    var y = 0F

    var size = 0F

    var color = Color.BLACK

    fun setData(col: Int, row: Int, num: Int) {
        this.col = col
        this.row = row
        this.num = num
        x = GAP * col + RECT_UNIT_SIZE * (col - 0.5F)
        y = GAP * row + RECT_UNIT_SIZE * (row - 0.5F)
        enterAnimation()
    }

    fun colMove(toCol: Int) {
        val toX = GAP * toCol + RECT_UNIT_SIZE * (toCol - 0.5F)
        val animate = ValueAnimator.ofFloat(x, toX).apply {
            duration = 300
            interpolator = OvershootInterpolator()
            addUpdateListener {
                x = animatedValue as Float
                unitManager.refresh()
            }
        }
        animate.start()
    }

    fun rowMove(toRow: Int) {
        val toY = GAP * toRow + RECT_UNIT_SIZE * (toRow - 0.5F)
        val animate = ValueAnimator.ofFloat(y, toY).apply {
            duration = 300
            interpolator = OvershootInterpolator()
            addUpdateListener {
                y = animatedValue as Float
                unitManager.refresh()
            }
        }
        animate.start()
    }

    private fun enterAnimation() {
        val animate = ValueAnimator.ofFloat(0F, RECT_UNIT_SIZE).apply {
            duration = 300
            interpolator = OvershootInterpolator()
            addUpdateListener {
                size = animatedValue as Float
                unitManager.refresh()
            }
        }
        animate.start()
    }
}
