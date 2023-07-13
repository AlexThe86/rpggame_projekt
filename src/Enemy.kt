/*die klasse Enemy erbt hier von der klasse Charakter eigenschaften (name und healtpoints)
* */
class Enemy(name: String, healthPoints: Int, val actions: List<Action>) : Charakter(name, healthPoints) {
    val maxlife = healthPoints
    var attackedHeroes: MutableList<Hero> = mutableListOf()
    //wird aufgerufen um eine Aktion auf das Ziel auszuführen(Charakter)//
    fun performAct(target: Charakter) {
        if (target is Hero) {
            val randomAction = actions.random()
            //führt die attacke zufällig gegen das ziel aus.//
            randomAction.apply(target, this)
        }
    }
    //wird aufgerufen um eine Fluch Aktion auszuführen.
    fun applyCurse(cursedmg: Double) {
        val curseDamage = (maxlife * cursedmg).toInt()
        println("$name erleidet $curseDamage Schaden durch den Fluch!")
        // die lebenspunkte werden durch den fluch abgezogen.//
        hp -= curseDamage
        println("$name hat noch $hp HP")
    }
    //berechnet den schaden, der verursacht wird. und gibt einen Int wert zw 10-35 zurück.//
    fun calculateDmg(): Int {
        //gibt einen wert zwischen 10 und 35 zurück.//
        return (10..35).random()
    }
    fun attackHeroes(heroes: List<Hero>) {
        for (hero in heroes) {
            if (!attackedHeroes.contains(hero)) {
                //wählt hier eine zufällige attacke aus//
                val randomAttack = actions.random()
                println("\u001B[31m$name greift ${hero.name} an mit ${randomAttack.name}!\u001B[0m")
                //ruft hier die berechnungs methode auf//
                val dmg = calculateDmg()
                //zieht hier die lebenspunkte der helden ab.//
                hero.hp -= dmg
                println("${hero.name} erleidet $dmg Schaden. Verbleibende HP: ${hero.hp}")
                //fügt die attackierten helden in die mutableliste hinzu.//
                attackedHeroes.add(hero)
            }
        }
    }
}
