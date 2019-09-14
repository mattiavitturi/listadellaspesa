package it.mavd.listadellaspesa.utils

import android.content.Context

fun convertDpToPx(context: Context, dp: Float): Float {
    return dp * context.resources.displayMetrics.density
}

fun convertPxToDp(context: Context, px: Float): Float {
    return px / context.resources.displayMetrics.density
}