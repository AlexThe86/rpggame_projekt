class Hero1 : Hero(
    //klasse erbt von Hero//
    "Krieger", 100, listOf(
        AttackAction("Angriff", 20),
        AttackAction("Schwertwirbel", 30),
        AttackAction("Todesstoß", 40),
    ), Bag().apply {
        addItem(Item("Heiltrank1", 50,0))
        addItem(Item("Heiltrank2", 50,0))
        addItem(Item("Heiltrank3", 50,0))
        addItem(Item("Vitamine", 0,30))
    }
)