class Hero3 : Hero(
    //Klasse erbt von Hero//
    "Bogenschütze", 90, listOf(
        AttackAction("Schuss", 25),
        AttackAction("Präzisionsschuss", 30),
        AttackAction("Pfeilhagel", 35),
    ), Bag().apply {
        addItem(Item("Heiltrank1", 45,0))
        addItem(Item("Heiltrank2", 45,0))
        addItem(Item("Heiltrank3", 45,0))
        addItem(Item("Vitamine", 0,30))
    }
)
