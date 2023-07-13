class Hero3 : Hero("Bogenschütze", 90, mutableListOf(AttackAction("Schuss", 25), AttackAction("Präzisionsschuss", 30), AttackAction("Pfeilhagel", 35)), Bag().apply{
    addItem(Item("Heiltrank1", 50, 0))
    addItem(Item("Heiltrank2", 50, 0))
    addItem(Item("Heiltrank3", 50, 0))
    addItem(Item("Vitamine", 0, 30))
})