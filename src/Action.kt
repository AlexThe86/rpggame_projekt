/*//die class action ist eine offene klasse, mit der eigenschaft name
und der apply methode die von den unterklassen überschrieben werden kann
dazu hat die klasse 2 parameter act für Charakter und target für Enemy.*/
open class Action(open val name: String) {
    open fun apply(act: Charakter, target: Enemy) {
    }
}
