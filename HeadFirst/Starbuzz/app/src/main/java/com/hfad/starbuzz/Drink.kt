package com.hfad.starbuzz

class Drink(val name: String, val description: String, val imageResourceId: Int){
    companion object{
        val drinks: Array<Drink> = arrayOf(
            Drink("Latte", "A couple of espresso shots with steamed milk",
                R.drawable.latte),
            Drink("Cappuccino", "Espresso, hot milk, and a steamed milk foam",
                R.drawable.cappuccino),
            Drink("Filter", "Highest quality beans roasted and brewed fresh",
                R.drawable.filter)
        )
    }

    override fun toString(): String = name
}