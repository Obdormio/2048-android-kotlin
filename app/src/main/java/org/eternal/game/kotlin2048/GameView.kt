package org.eternal.game.kotlin2048

import android.content.Context
import android.graphics.Canvas

// Rect Unit
const val RECT_UNIT_SIZE = 200F
const val RECT_RADIUS = 10F

const val GAP = 20F

// Background
const val BACKGROUND_SIZE = GAP * 5 + RECT_UNIT_SIZE * 4
const val BACKGROUND_RADIUS = 20F

// View
const val VIEW_SIZE = BACKGROUND_SIZE

class GameView(context: Context) : BaseView(context) {

    val background = object : ViewComponent(this) {
        override fun onDraw(canvas: Canvas?) {
            super.onDraw(canvas)
            paint.color = 0xFFBDAE9C.toInt()
            canvas?.drawRoundRect(0F, 0F, BACKGROUND_SIZE, BACKGROUND_SIZE, BACKGROUND_RADIUS, BACKGROUND_RADIUS, paint)
        }
    }

    init {
        components["background"] = background
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        setMeasuredDimension(VIEW_SIZE.toInt(), VIEW_SIZE.toInt())
    }
}
