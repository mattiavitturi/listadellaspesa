package it.mavd.listadellaspesa.items

import android.graphics.Color
import android.graphics.drawable.Drawable

data class ItemModel(
    val icon: Drawable,
    val name: String,
    val quantity: Int,
    val price: Double,
    val activeGradientColor: IntArray = intArrayOf(
        Color.parseColor("#E95E1E"),
        Color.parseColor("#E91E63"))) {

    val activeTextColor = Color.WHITE
    val inactiveTextColor = Color.LTGRAY

    val inactiveGradientColors = intArrayOf(Color.GRAY, Color.GRAY)

    lateinit var activationCallback: () -> Unit

    lateinit var deactivationCallback: () -> Unit

    var active = true

    fun onActivation(f: () -> Unit) {
        activationCallback = f
    }

    fun onDeactivation(f: () -> Unit) {
        deactivationCallback = f
    }

    fun activate() {
        active = true
        activationCallback()
    }

    fun deactivate() {
        active = false
        deactivationCallback()
    }

    fun initialize(f: () -> Unit) {
        f()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ItemModel

        if (icon != other.icon) return false
        if (name != other.name) return false
        if (quantity != other.quantity) return false
        if (price != other.price) return false
        if (!activeGradientColor.contentEquals(other.activeGradientColor)) return false
        if (activeTextColor != other.activeTextColor) return false
        if (inactiveTextColor != other.inactiveTextColor) return false
        if (!inactiveGradientColors.contentEquals(other.inactiveGradientColors)) return false
        if (activationCallback != other.activationCallback) return false
        if (deactivationCallback != other.deactivationCallback) return false
        if (active != other.active) return false

        return true
    }

    override fun hashCode(): Int {
        var result = icon.hashCode()
        result = 31 * result + name.hashCode()
        result = 31 * result + quantity
        result = 31 * result + price.hashCode()
        result = 31 * result + activeGradientColor.contentHashCode()
        result = 31 * result + activeTextColor
        result = 31 * result + inactiveTextColor
        result = 31 * result + inactiveGradientColors.contentHashCode()
        result = 31 * result + activationCallback.hashCode()
        result = 31 * result + deactivationCallback.hashCode()
        result = 31 * result + active.hashCode()
        return result
    }


}