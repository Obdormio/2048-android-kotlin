package org.eternal.game.kotlin2048

import android.content.Context
import android.graphics.Canvas
import android.view.View

open class BaseView(context: Context) : View(context) {

    val components = hashMapOf<String, ViewComponent>()

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        components.forEach { _, u ->
            u.onDraw(canvas)
        }
    }
}
