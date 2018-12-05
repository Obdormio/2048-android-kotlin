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

    // Init background
    init {
        components["background"] = object : ViewComponent(this) {
            override fun onDraw(canvas: Canvas?) {
                super.onDraw(canvas)
                paint.color = 0xFFBDAE9C.toInt()
                canvas?.drawRoundRect(0F, 0F, BACKGROUND_SIZE, BACKGROUND_SIZE, BACKGROUND_RADIUS, BACKGROUND_RADIUS, paint)
                paint.color = 0xFFD6CEC5.toInt()
                for (x in 1..4) {
                    for (y in 1..4) {
                        val dx = GAP * x + RECT_UNIT_SIZE * (x - 1)
                        val dy = GAP * y + RECT_UNIT_SIZE * (y - 1)
                        canvas?.drawRoundRect(dx, dy, dx + RECT_UNIT_SIZE, dy + RECT_UNIT_SIZE, RECT_RADIUS, RECT_RADIUS, paint)
                    }
                }
            }
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        setMeasuredDimension(VIEW_SIZE.toInt(), VIEW_SIZE.toInt())
    }
}
