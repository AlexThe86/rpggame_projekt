class Hero3 : Hero(
    //klasse erbt von Hero, und der Krieger hat hier 3 Attacken zur Auswahl//
    "Bogenschütze", 90, mutableListOf(
        AttackAction("Schuss", 25),
        AttackAction("Präzisionsschuss", 30),
        AttackAction("Pfeilhagel", 35),
    ), Bag().apply {
        //hier wird ein Beutel erstellt mit 4 Items.//
        addItem(Item("Heiltrank1", 45, 0))
        addItem(Item("Heiltrank2", 45, 0))
        addItem(Item("Heiltrank3", 45, 0))
        addItem(Item("Vitamine", 0, 30))
    }
)
