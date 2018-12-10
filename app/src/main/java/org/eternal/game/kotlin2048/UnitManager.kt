package org.eternal.game.kotlin2048

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.MotionEvent
import kotlin.math.abs

class UnitManager(view: GameView) : ViewComponent(view) {

    private val rectUnits = arrayListOf<RectUnit>()

    init {
        var x0 = 0F
        var y0 = 0F
        view.setOnTouchListener { _, event ->
            when (event.actionMasked) {
                MotionEvent.ACTION_DOWN -> {
                    x0 = event.x
                    y0 = event.y
                }
                MotionEvent.ACTION_UP -> {
                    val dx = event.x - x0
                    val dy = event.y - y0
                    val direction = getDirection(dx, dy)
                    performSwap(direction)
                }
            }
            true
        }
    }

    fun start() {
        addUnit()
    }

    private enum class Direction {
        LEFT, UP, RIGHT, DOWN, ORIGIN
    }

    private fun performSwap(direction: Direction) {
        val u = rectUnits[0]
        when(direction) {
            Direction.UP -> u.rowMove(1)
            Direction.DOWN -> u.rowMove(4)
            Direction.LEFT -> u.colMove(1)
            Direction.RIGHT -> u.colMove(4)
            else -> Unit
        }
    }

    private fun getDirection(dx: Float, dy: Float): Direction {
        return if (abs(dx) < 50 && abs(dy) < 50) {
            Direction.ORIGIN
        } else {
            if (abs(dx) > abs(dy)) {
                if (dx > 0) Direction.RIGHT else Direction.LEFT
            } else {
                if (dy > 0) Direction.DOWN else Direction.UP
            }
        }
    }

    private fun getOneUnusedPosition(): Pair<Int, Int> {
        val array = arrayListOf<Pair<Int, Int>>()

        for (x in 1..4) {
            for (y in 1..4) {
                var exist = false
                rectUnits.takeWhile {
                    exist = (it.col == x && it.row == y)
                    !exist
                }
                if (!exist) array.add(Pair(x, y))
            }
        }

        if (array.size == 0) return Pair(-1, -1)

        val index = (0..(array.size - 1)).random()
        return array[index]
    }

    private fun addUnit() {
        val (col, row) = getOneUnusedPosition()
        val num = (1..2).random() * 2
        rectUnits.add(RectUnit(this@UnitManager).apply {
            setData(col, row, num)
        })
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        this.rectUnits.forEach {
            paint.color = it.color
            canvas?.apply {
                // save canvas state before move it
                save()
                // move to the center of unit rect
                translate(it.x, it.y)
                // draw color block
                drawRoundRect(-it.size / 2, -it.size / 2, it.size / 2, it.size / 2, RECT_RADIUS, RECT_RADIUS, paint)
                // prepare the text
                paint.color = Color.WHITE
                paint.textSize = view.context.sp2px(30F)
                paint.textAlign = Paint.Align.CENTER
                val top = paint.fontMetrics.top
                val bottom = paint.fontMetrics.bottom
                // draw the text
                drawText(it.num.toString(), 0F, -(top + bottom) / 2, paint)
                // restore the canvas after draw
                restore()
            }
        }
    }
}
