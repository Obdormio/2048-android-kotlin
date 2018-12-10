package org.eternal.game.kotlin2048

import android.graphics.Canvas
import android.graphics.Paint

// This class is pure for display, for canvas to draw and make animation,
// cannot interact with user
open class ViewComponent(protected val view: BaseView) {

    val paint = Paint().apply {
        isAntiAlias = true
    }

    open fun onDraw(canvas: Canvas?) {
    }

    fun refresh() {
        view.invalidate()
    }
}
