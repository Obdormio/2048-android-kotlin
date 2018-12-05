package org.eternal.game.kotlin2048

import android.content.Context
import android.util.TypedValue

fun Context.sp2px(spSize: Float): Float {
    return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_SP,
            spSize,
            resources.displayMetrics
    )
}

fun Context.dp2px(dpSize: Float): Float {
    return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            dpSize,
            resources.displayMetrics
    )
}
