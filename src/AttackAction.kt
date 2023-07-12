import kotlin.random.Random
/*die klasse AttackAction ist für die angriffsaktion, die einen bestimmten vorhandenen angriff ausführt und schaden hinzufügt.
sie erbt hier von der klasse Action, die methode apply überschreibt die vorhandene apply aus der klasse Action.
hier habe ich noch eine funktion hinzugefügt, damit der gegner sich durch zufall verteidigen kann,
je nachdem werden schadenspunkte abgezogen oder nicht*/

class AttackAction(name: String, val damage: Int) : Action(name) {
    override fun apply(act: Charakter, target: Enemy) {
        if (target is Enemy) {
            println("\u001B[33m${act.name} greift ${target.name} an mit ${name} und fügt $damage Schaden zu.\u001B[0m")
            // Der angegriffene Charakter verteidigt sich zufällig gegen den Angriff durch den boolean defend.
            val defend = Random.nextBoolean()
            //defend boolean true oder false nach zufall//
            if (defend) {
                act.hp -= damage
                println("\u001B[33m${target.name} verteidigt sich erfolgreich mit ${name} und greift ${act.name} mit Schaden $damage an.\u001B[0m")
                println("\u001B[34m${act.name} hat noch ${act.hp} HP übrig.\u001B[0m")
                println("---------------------------------------------------------------------")
                Thread.sleep(500)
            } else {
                //hier werden die punkte des gegners abgezogen(Enemy)
                target.hp -= damage
                println("\u001B[33m${target.name} konnte sich nicht verteidigen und hat noch ${target.hp} HP.\u001B[0m")
            }
        } else {
            println("${act.name} kann diese Aktion nicht auf ${target.name} nutzen.")
        }
    }
}
