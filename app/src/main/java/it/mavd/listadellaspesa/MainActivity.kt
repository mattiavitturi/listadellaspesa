package it.mavd.listadellaspesa

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import it.mavd.listadellaspesa.items.ItemAdapter
import it.mavd.listadellaspesa.items.ItemModel
import it.mavd.listadellaspesa.utils.MarginItemDecoration
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    lateinit var list: List<ItemModel>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        list = listOf(
            ItemModel(resources.getDrawable(R.drawable.food_apple, theme), "Pane", 1, 0.34),
            ItemModel(resources.getDrawable(R.drawable.food_banana, theme), "Acqua",1, 0.34),
            ItemModel(resources.getDrawable(R.drawable.food_basket, theme), "Latte",1, 0.34),
            ItemModel(resources.getDrawable(R.drawable.food_blender, theme), "Formaggio",1, 0.34),
            ItemModel(resources.getDrawable(R.drawable.food_bread, theme), "Caffè",1, 0.34),
            ItemModel(resources.getDrawable(R.drawable.food_broccoli, theme), "Miele",1, 0.34),
            ItemModel(resources.getDrawable(R.drawable.food_carrot, theme), "Brioche",1, 0.34),
            ItemModel(resources.getDrawable(R.drawable.food_coconut, theme), "Qualcosa molto lungooo",1, 0.34)
        )



        grid_menu.apply {
            layoutManager  = GridLayoutManager(this@MainActivity, 3)
            adapter = ItemAdapter(list)
            addItemDecoration(MarginItemDecoration(10))
        }



    }
}
