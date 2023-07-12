class Hero2 : Hero(
    //klasse erbt von Hero, und der Krieger hat hier 3 Attacken zur Auswahl//
    "Magier", 80, mutableListOf(
        AttackAction("Zauber", 30),
        AttackAction("Feuerball", 35),
        AttackAction("Blitzschlag", 40),
    ), Bag().apply {
        //hier wird ein Beutel erstellt mit 4 Items.//
        addItem(Item("Heiltrank1", 50, 0))
        addItem(Item("Heiltrank2", 50, 0))
        addItem(Item("Heiltrank3", 50, 0))
        addItem(Item("Vitamine", 0, 30))
    }
)