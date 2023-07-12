/*die klasse Bag ist ein Item Beutel für die Helden (Hero1,Hero2,Hero3), damit können sie die vorhandenen
* items nutzen , die anschliessend entfernt werden und mit einem counter gezählt werden, wieviele davon verwendet werden.*/
class Bag {
    val items = mutableListOf<Item>()
    val itemCounter = mutableMapOf<Item, Int>()
    //fügt einen gegenstand zu dem beutel hinzu, der counter wird initialisiert.//
    fun addItem(item: Item) {
        items.add(item)
        itemCounter[item] = 0
    }
    //nutzt das item, wenn item vorhanden sind//
    fun useItem(target: Charakter) {
        if (items.isEmpty()) {
            println("Keine Items im Beutel vorhanden.")
            return
        }
        println("Wähle einen Gegenstand aus dem Beutel:")
        for ((index, item) in items.withIndex()) {
            println("${index + 1}. ${item.name}")
        }
        println("0. Keine Auswahl")
        println("Bitte gib die Aktion an:")
        try {
        val input = readln().toIntOrNull()
        //prüft für den ausgewählten gegenstand ob der counter grösser oder maximal als 4 ist//
        if (input != null && input in 1..items.size) {
            val selectedItem = items[input - 1]
            if (itemCounter[selectedItem]!! >= 4) {
                println("Du kannst dieses Item nicht mehr verwenden.")
            } else {
                //hier wird der gegenstand verwendet und geprüft wie oft es genutzt wurde, danach wird es aus der liste entfernt//
                selectedItem.useItem(target)
                itemCounter[selectedItem] = itemCounter[selectedItem]!! + 1
                items.remove(selectedItem)
            }
            // eingabe 0 , bricht die schleife ab und setzt den spielverlauf fort.//
        } else if (input == 0) {
            println("Keine Aktion ausgewählt. Weiter geht's...")
        } else {
            println("Ungültige Eingabe.")
        }
        } catch (e: NumberFormatException) {
            println("Ungültige Eingabe. Bitte eine Zahl eingeben.")
        }
    }
}
