class Hero2 : Hero("Magier", 80, mutableListOf(AttackAction("Zauber", 30), AttackAction("Feuerball", 35), AttackAction("Blitzschlag", 40)), Bag().apply{
    addItem(Item("Heiltrank1", 50, 0))
    addItem(Item("Heiltrank2", 50, 0))
    addItem(Item("Heiltrank3", 50, 0))
    addItem(Item("Vitamine", 0, 30))
})