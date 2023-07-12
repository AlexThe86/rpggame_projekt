open class Hero(name: String, hp: Int, val actions: List<Action>, val bag: Bag) : Charakter(name, hp) {

    override fun performAct(target: Enemy) {
        println("Wähle eine Aktion für $name:")
        //schleife läuft durch und gibt die aktionen mit einer Zahl aus//
        for (i in actions.indices) {
            val action = actions[i]
            println("${i + 1}. ${action.name}")
        }
        //eine aktion auswählen durch eingabe einer Zahl//
        println("Bitte wähle die aktion aus:")
        try {
        val input = readln().toIntOrNull()
        //prüft die eingabe ob sie gültig ist, und die aktion vorhanden ist.//
        if (input != null && input in 1..actions.size) {
            val selected = actions[input - 1]
            //wird ausgeführt wenn die if bedienung passt.//
            selected.apply(this, target)
        } else {
            //ausgabe wenn falsche zahl eingegeben wurde.//
            println("Ungültige Eingabe.")
        }
            //wird ausgerufen wenn statt zahlen irgendwas anderes eingegeben wird.//
        } catch (e: NumberFormatException) {
            println("Ungültige Eingabe. Bitte gib eine Zahl ein.")
        }
    }
}