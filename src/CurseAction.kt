/*die klasse CurseAction erbt hier von der klasse Action.
* die fun apply wird hier überschrieben wenn diese funktion aufgerufen wird,
* vorraussetzung dafür ist wenn die if bedienung nicht stimmt.*/
class CurseAction(name: String, private val cursedmg: Double) : Action(name) {
    override fun apply(act: Charakter, target: Enemy) {
        if (target.hp <= target.maxlife * 0.2) {
            println("${act.name} kann den Fluch nicht auf ${target.name} anwenden.")
            return
        }
        println("${act.name} wendet einen Fluch auf ${target.name} an.")
        //wendet den fluch an.//
        target.applyCurse(cursedmg)
    }
}