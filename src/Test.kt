// Test Programm um das Spiel und die Einzelnen Funktionen zu testen.//
fun main() {
    testCharacterActions()
    testBag()
    testEnemyActions()
    testRPGGame()
    println("Alle Tests wurden erfolgreich durchgeführt. Das Spiel kann gestartet werden.")
}
fun testCharacterActions() {
    val enemy = Enemy("Gegner", 100, listOf(AttackAction("Angriff", 10)))
    val hero = Hero("Held", 100, listOf(AttackAction("Angriff", 20)), Bag())

    println("Teste Character Actions")
    hero.performAct(enemy)
    println(".....")
}
fun testBag() {
    val bag = Bag()
    val hero = Hero("Held", 100, listOf(), bag)
    val item1 = Item("Item 1", 10,0)
    val item2 = Item("Item 2", 20,0)

    println("Teste Bag")
    bag.addItem(item1)
    bag.addItem(item2)
    hero.bag.useItem(hero)
    hero.bag.useItem(hero)
    hero.bag.useItem(hero)
    hero.bag.useItem(hero)
    println("...")
}
fun testEnemyActions() {
    val enemy = Enemy("Gegner", 100, listOf(AttackAction("Angriff", 10), CurseAction("Fluch", 0.1)))
    val hero = Hero("Held", 100, listOf(), Bag())

    println("Teste Enemy Actions")
    enemy.performAct(hero)
    enemy.performAct(hero)
    println("...")
}
fun testRPGGame() {
    val game = Game()
    game.createHeroes()
    game.createEnemy()
    game.createItems()

    println("Teste RPG Game")
    game.startRound()
    println("...")
}