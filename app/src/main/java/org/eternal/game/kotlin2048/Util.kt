package org.eternal.game.kotlin2048

import android.content.Context
import android.util.TypedValue
import java.util.*

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

fun IntRange.random(): Int {
    return Random().nextInt(endInclusive + 1 - start) + start
}
