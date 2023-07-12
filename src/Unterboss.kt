/*das ist die Klasse Unterboss sie erbt von der Klasse Action.*/
class Unterboss(name: String) : Action(name) {
    //eigenschaft ist standart auf false.//
    var unterboss = false
    // die methode überschreibt die fun apply um den code auszuführen.//
    override fun apply(act: Charakter, target: Enemy) {
        //hier wird der subboss erstellt mit einer Aktion und schaden 10
        val subBoss = Enemy("Unterboss", 50, listOf(AttackAction("Angriff", 10)))
        // if bediengung ob der unterboss beschworen wurde oder nicht./
        if (unterboss) {
            println("Der Unterboss wurde bereits beschworen.")
            return
        }
        println("${act.name} beschwört den Unterboss: ${subBoss.name} (HP: ${subBoss.hp})")
        //schaden -10 vom gegner des unterbosses.//
        target.hp -= 10
        //führt hier seine aktion gegen den gegner aus.//
        subBoss.performAct(target)
        //setzt den boolean auf true, wenn der unterboss beschworen wurde.//
        unterboss = true
    }
}