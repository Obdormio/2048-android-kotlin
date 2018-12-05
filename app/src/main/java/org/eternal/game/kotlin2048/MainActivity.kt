package org.eternal.game.kotlin2048

import android.app.Activity
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.RelativeLayout

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        val relativeLayout = RelativeLayout(this@MainActivity).apply {
            setPadding(15, 15, 15, 15)
            setBackgroundColor(Color.BLACK)
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
