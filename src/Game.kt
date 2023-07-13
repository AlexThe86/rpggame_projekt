class Game {
    //eigenschaften hereos und enemy//
    val heroes = createHeroes()
    val enemy = createEnemy()

    //erstellt eine Liste von drei Helden-Objekte in einer Liste zusammengefasst, die dann zurück gegeben wird.//
    fun createHeroes(): List<Hero> {
        val hero1 = Hero1()
        val hero2 = Hero2()
        val hero3 = Hero3()

        return listOf(hero1, hero2, hero3)
    }
    //erstellt einen gegner mit eigenschaften und aktionen, die dann zurück gegeben wird.//
    fun createEnemy(): Enemy {
        val enemyActions = listOf(
            AttackAction("Angriff", 15),
            AttackAction("Doppelter Angriff", 30),
            AttackAction("Gift", 45),
            AttackAction("DunkleFlamme", 45),
            CurseAction("Fluch", 0.1),
            Unterboss("Beschwörung"),
        )
        return Enemy("Drache", 200, enemyActions)
    }
    // erstellt eine Liste von Gegenständens als Objekt mit Namen und Int Werten.
    open fun createItems(): List<Item> {
        val item1 = Item("Heiltrank", 25,0)
        val item2 = Item("Stärketrank", 10,0)
        val item3 = Item("Powertrank", 30,0)
        val item4 = Item("Vitamine",0,30)
        return listOf(item1, item2, item3,item4)
    }
    //mit aufruf der Methode, startet der spiel ablauf.//
    fun run() {
        //spielausgabe beginnt... /
        println(
            "\u001B[34m" +
                    """

█▀█ █▀█ █▀▀   █▀▀ ▄▀█ █▀▄▀█ █▀▀
█▀▄ █▀▀ █▄█   █▄█ █▀█ █░▀░█ ██▄""".trimIndent() + "\u001B[0m"
        )

        println("Willkommen zum RPG-Spiel!")
        println("-------------------------")
        println("\u001B[33mHier eine Übersicht deiner Helden:\u001B[0m")
        //itteriert durch die hereos und gibt die verfügbaren helden aus.//
        for (hero in heroes) {
            println("\u001B[34m--- ${hero.name}[HP: ${hero.hp}] ---\u001B[0m")
            println("\u001B[34m-----------------------------\u001B[0m")
        }
        // variable für runden des Spiels, wird in diesem fall nach dem 3 Level beendet.//
        val maxRounds = 3
        //zähler variable fängt bei 1 an und  zählt die runden.//
        var roundCounter = 1
        //gibt true aus solange die bedienungen erfüllt sind.//
        while (roundCounter <= maxRounds && heroes.all { it.hp > 0 } && enemy.hp > 0)
        {
            println("\u001B[33mRunde $roundCounter startet.....\u001B[0m")
            Thread.sleep(1500)
            startRound()
            roundCounter++
        }
        val aliveHeroes = mutableListOf<Hero>()
        for (hero in heroes) {
            if (hero.hp > 0) {
                aliveHeroes.add(hero)
            }
        }
        if (aliveHeroes.isEmpty()) {
            println("\u001B[31m--- Die Helden haben verloren. Das Spiel ist zu Ende. ---\u001B[0m")
        } else if (roundCounter > maxRounds) {
            println("\u001B[32m--- Alle Helden haben überlebt! ---\u001B[0m")
        } else {
            println("\u001B[32m--- Der letzte Held hat gewonnen! ---\u001B[0m")
        }
        println("\u001B[33mEndstand der Helden:\u001B[0m")
        for (hero in heroes) {
            println("\u001B[34m--- ${hero.name}[HP: ${hero.hp}] ---\u001B[0m")
        }
        println("\u001B[33mEndstand des Gegners:\u001B[0m")
        println("\u001B[34m--- Enemy[HP: ${enemy.hp}] ---\u001B[0m")
    }
    //wenn held unter 0 hp, dann zu gestorbenen liste hinzufügen//
    fun startRound() {
        // erstellt mir eine kopie der mutablenliste.//
        val aliveHeroes = heroes.toMutableList()
        //itteriert durch die helden liste./
        for (hero in heroes) {
            //prüft ob die bediengung held in der kopie der liste erstellt ist.//
            if (!aliveHeroes.contains(hero)) {
                continue // Wenn der Held bereits gestorben ist, überspringen!!
            }
            println("\u001B[34m--- ${hero.name} ist an der Reihe ---\u001B[0m")
            // der held führt seine aktion gegen den gegner aus.//
            hero.performAct(enemy)
            //prüft hier ob der gegner und held keine lebenspunkte mehr hat.//
            if (enemy.hp <= 0 || hero.hp <= 0) {
                //falls ja ,wird der angriff nicht ausgeführt.//
                break
            }
            //prüft ob der beutel keine items mehr enthält.//
            if (hero.bag.items.isEmpty()) {
                println("Keine Items vorhanden. Weiter geht's...")
                // die schleife wird fortgesetzt und es geht zum nächsten helden.//
                continue
            }
            //nutzung des items für den helden.//
            hero.bag.useItem(hero)
            if (hero.hp <= 0) {
               aliveHeroes -= hero // Den gestorbenen Helden aus der Liste entfernen
            }
        }
        //wenn lebenspunkte mehr als 150, dann ist der Endgegner dran.
        if (enemy.hp > 150) {
            println("\u001B[31m--- Der Endgegner ist an der Reihe ---\u001B[0m")
            //hier wird über die helden ittiert ob sie noch am leben sind.//
            for (hero in aliveHeroes) {
                //führt dann die attacke gegen die überlebenden helden aus.//
                enemy.attackHeroes(aliveHeroes)
                continue
            }
        }
        //itteriert durch die überlebenden helden , und gibt einen hinweis aus zur lp.//
        for (hero in aliveHeroes) {
            if (hero.hp > 75) {
                println("\u001B[33mHinweis: ${hero.name} verfügt über 75 HP. Du kannst Items nutzen.\u001B[0m")
            }
        }
    }
}