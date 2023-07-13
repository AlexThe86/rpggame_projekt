/*das ist die offene Klasse Item, mit den eigenschaften
* name, healamount , damage*/
open class Item(open val name: String, open val healAmount: Int, open val damage: Int) {
    //zähler variable für die items.//
    var i = 0
    // wird aufgerufen um ein Item für den Chrakter zu nutzen, vorrausgesetzt die bedienungen passen.//
    open fun useItem(hero: Charakter) {
        //jedes item kann nur 1x benutzt werden.//
        if (i >= 1) {
            println("Du kannst dieses Item nicht mehr verwenden.")
            return
        }
        //wenn das item Vitamine ist.//
        if (name == "Vitamine") {
            //wenn der held ein held ist.//
            if (hero is Hero) {
                var olddmg = 0
                try {
                    // ittieriert durch die aktionen der helden//
                    for (action in hero.actions) {
                        //wenn aktion vorhanden, dann neuen wert errechnen.//
                        if (action is AttackAction) {
                            //füge den schaden zu//
                            olddmg += action.damage
                        }
                    }
                    //berechnung der schadenswerte//
                    var newdmg = olddmg + (olddmg * 0.1).toInt()
                    println("\u001B[33m${hero.name} nimmt Vitamine ein.\u001B[0m")
                    println("${hero.name} sein Schadenswert wurde von $olddmg auf $newdmg erhöht.")
                } catch (e: Exception) {
                    println("Fehler in der Item.kt Berechnen des Schadenswerts.")
                }
            } else {
                //wird ausgegeben wenn die bedienung Vitamine nicht zu trifft.//
                println("${hero.name} kann keine Vitamine zu sich nehmen.")
            }
        } else {
            // wenn alle bedienungen erfüllt sind, nutze die Vitamine.//
            println("Du nutzt das Item '$name'. Es heilt dich um $healAmount HP.")
            hero.hp += healAmount
            println("${hero.name} hat jetzt ${hero.hp} HP.")
        }
        //zählt den benutzen Item.//
        i++
    }
}