/*hier ist die offene klasse Chrakter, die klasse hat die eigenschaften
* name als string und hp als int für die lebenspunkte, die fun performAct
* kann in den unterklassen überschreiben.*/
open class Charakter(val name: String, var hp: Int) {
    open fun performAct(target: Enemy) {
    }
}