package org.eternal.game.kotlin2048

import android.app.Activity
import android.os.Bundle
import android.widget.RelativeLayout
import android.widget.TextView

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val relativeLayout = RelativeLayout(this@MainActivity).apply {
            setPadding(15, 15, 15, 15)
        }

        val text = TextView(this@MainActivity).apply {
            text = "Hello World"
        }
        val textParam = RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        ).apply {
            addRule(RelativeLayout.CENTER_IN_PARENT)
        }
        relativeLayout.addView(text, textParam)

        setContentView(relativeLayout)
    }
}
