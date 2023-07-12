class Hero1 : Hero(
    //klasse erbt von Hero, und der Krieger hat hier 3 Attacken zur Auswahl//
    "Krieger", 100, mutableListOf(
        AttackAction("Angriff", 20),
        AttackAction("Schwertwirbel", 30),
        AttackAction("Todesstoß", 40),
    ), Bag().apply {
        //hier wird ein Beutel erstellt mit 4 Items.//
        addItem(Item("Heiltrank1", 50, 0))
        addItem(Item("Heiltrank2", 50, 0))
        addItem(Item("Heiltrank3", 50, 0))
        addItem(Item("Vitamine", 0, 30))
    }
)