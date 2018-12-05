package org.eternal.game.kotlin2048

import android.app.Activity
import android.os.Bundle
import android.widget.RelativeLayout

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val relativeLayout = RelativeLayout(this@MainActivity).apply {
            setPadding(15, 15, 15, 15)
        }

        val gameView = GameView(this@MainActivity)
        val gameViewParam = RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        ).apply {
            addRule(RelativeLayout.CENTER_IN_PARENT)
        }
        relativeLayout.addView(gameView, gameViewParam)

        setContentView(relativeLayout)
    }
}
