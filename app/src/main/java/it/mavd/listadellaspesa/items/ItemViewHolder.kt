package it.mavd.listadellaspesa.items

import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.LayerDrawable
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import it.mavd.listadellaspesa.R
import kotlinx.android.synthetic.main.list_item.view.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class ItemViewHolder(private val view: View) :
    RecyclerView.ViewHolder(view) {

    fun bind(item: ItemModel) {

        item.initialize {
            item.icon.alpha = 60

            view.apply {
                (background as LayerDrawable)
                    .setDrawableByLayerId(                          // change the background icon
                        R.id.list_item_icon,
                        item.icon
                    )

                list_item_name.text = item.name
                list_item_price.text = "%.2f".format(item.price)    // format price to 2 decimal places
                list_item_quantity.text = item.quantity.toString() + "x"
            }
        }

        item.onActivation {

            view.apply {
                ((background as LayerDrawable)
                    .findDrawableByLayerId(                          // change to active gradient
                        R.id.list_item_gradient
                    ) as GradientDrawable)
                        .colors = item.activeGradientColor

                // set active text colors
                list_item_name.setTextColor(item.activeTextColor)
                list_item_price.setTextColor(item.activeTextColor)
                list_item_quantity.setTextColor(item.activeTextColor)
                list_item_currency.setTextColor(item.activeTextColor)


            }



        }

        item.onDeactivation {
            view.apply {
                ((background as LayerDrawable)
                    .findDrawableByLayerId(                         // change to inactive gradient
                        R.id.list_item_gradient
                    ) as GradientDrawable)
                    .colors = item.inactiveGradientColors


                // set inactive text colors
                list_item_name.setTextColor(item.inactiveTextColor)
                list_item_price.setTextColor(item.inactiveTextColor)
                list_item_quantity.setTextColor(item.inactiveTextColor)
                list_item_currency.setTextColor(item.inactiveTextColor)
            }

        }

        view.onClick {
                if(item.active) {
                    item.deactivate()
                } else {
                    item.activate()
                }

        }
    }

}