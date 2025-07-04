# EP2 Aufgabenblatt 7

Kernthemen: Java-Collections, Ausnahmebehandlung

## Organisatorisches
Abgabe Deadline: 03.06.2025 13:00<br>
Art der Abgabe: git commit & git push<br>
Erzielbare Punkteanzahl: 9

### Allgemeine Hinweise
* Die Lösung Ihrer Aufgabe muss im vorgegebenen Projekt und damit in den vorhandenen Dateien erfolgen.
* Führen Sie keine weiteren eigenen Klassen ein.
* Definieren Sie auch keine geschachtelten oder (anonymen) inneren Klassen, also keine Klassen, die
  in einer anderen Klasse, einem Objekt oder einer Methode stehen.
* Sie *sollen* zur Lösung dieser Aufgabe auf das *Java Collections Framework* zurückgreifen.
* Implementieren Sie keine unnötigen Getter-/Setter-Methoden. Implementieren Sie auch keine eigenen Iteratoren (nutzen
  Sie die vorhandenen aus dem Java Collections Framework).
* Alle Objektvariablen und etwaige von Ihnen zusätzlich erstellte Methoden in vorgegebenen
  Klassen müssen `private` sein.
* Verändern Sie *keine* der vorgegebenen Methodensignaturen.
* Verändern Sie keine vorgegebenen Programmteile oder Dateien, die mit ```DO NOT EDIT``` gekennzeichnet sind.
* Verändern Sie keine vorgegebenen Variablendeklarationen oder Code-Fragmente, außer den return-Statements in Methoden,
  die Sie implementieren müssen.
* **Achten Sie darauf, dass Ihre Abgabe ausführbar ist. Nicht lauffähige Abgaben werden nicht beurteilt.**

## Information zur Domäne
Nach der äußerst erfolgreichen Abwicklung des Auftrags zur Entwicklung von Bausteinen zu einem Computerspiel für das
Unternehmen Schneesturm, konnte vom Management der nächste Auftrag an Land gezogen werden. Diesmal sollen Komponenten einer
Casino-Simulation, konkret eine vereinfachte und angepasste Umsetzung des Kartenspiels [Blackjack](https://en.wikipedia.org/wiki/Blackjack) als Teil der
Open-World Western-Crime-Simulation Grand-Heist-Hackney von Diva-Games entwickelt werden.

Bei Blackjack, auch bekannt als "17 und 4", handelt es sich um ein Kartenspiel mit 52 Standardkarten, bei dem Spieler direkt gegen die Bank spielen. Die Bank
wird am Casino-Tisch durch den Kartengeber (Dealer) vertreten, der sowohl Karten an alle Spieler ausgibt als auch als Spieler mit Sonderregeln
aktiv am Spiel teilnimmt.

Ziel des Spiels ist es, mit seiner Hand (den in der Hand gehaltenen Karten), 21 Punkte zu erreichen. Wird dieser Wert überschritten,
endet das Spiel für den betroffenen Spieler sofort ("busted") und gilt als verloren. Regelanpassung durch den Auftraggeber: Haben
alle anderen Spieler (inklusive der Bank) den Wert ebenfalls überschritten, endet das Spiel für alle unentschieden.

Der Spieler beginnt mit zwei offen gespielten Handkarten, wobei auch die Bank zwei Karten offen erhält. Haben die beiden Karten
bereits den Gesamtwert von 21 liegt ein Blackjack vor und die Runde endet für den Betroffenen sofort (der Spieler hat keine Aktionen mehr zur Verfügung).
Hat die Bank zur gleichen Zeit keinen Blackjack, gewinnt der Spieler, sonst zählt die Runde als unentschieden. Hat nur die Bank einen
Blackjack gewinnt diese.

Liegt der Wert einer Hand unter 21, kann der Spieler weitere Karten von der Bank erhalten und seiner Hand hinzufügen ("hit"). Ist der
Spieler mit dem erreichten Gesamtwert zufrieden, teilt er dies der Bank mit ("stay"), und beendet seine Aktivitäten. Danach muss
die Bank nach einem festen Regelwerk Karten zu ihrer Hand hinzufügen. Dabei kann die Bank entweder einen gültigen
Gesamtwert erreichen, oder, wie auch der Spieler, 21 überschreiten und damit verlieren. Haben Bank und Spieler ihre Runde beendet,
werden deren Ergebnisse verglichen. Die Runde endet unentschieden ("draw"), wenn beide Spieler entweder verloren, oder beide einen Blackjack,
oder beide denselben gültigen Gesamtwert ihrer Hand (z.B. 18) erzielt haben. Ansonsten gewinnt der Spieler mit dem höchsten gültigen
Gesamtwert seiner Hand.

Der Gesamtwert einer Kartenhand wird ermittelt, indem der Wert der einzelnen Karten aufsummiert wird. Dabei sind Bildkarten 
(König, Dame, Bub) je 10 Punkte wert. Der Wert der Zahlenkarten entsprechend ihrer Zahl. Der Wert der Asse ist 11 Punkte
oder wahlweise auch nur 1 Punkt. 


## Aufgabenstellung

Ziel dieser Aufgabe ist die Entwicklung, der zum Spielen von Blackjack in einem simulierten Western-Casino benötigten 
Software-Komponenten. Diese können in einem vorgegebenen exemplarischen Spielablauf (Methode main() in [Application.java](../../src/AB7/Application.java)))
getestet werden.

Konkret sollen für die Casino-Simulation Klassen für Karten, eine Kartenhand, einen Dealer als Vertreter der Bank, und den Spieler
entwickelt werden. Darüber hinaus verlangt der Auftraggeber, dass spezifizierte Fehlerfälle in der Implementierung abgefangen und mittels
Exceptions behandelt werden müssen.

Die Klasse [BJCard](../../src/AB7/BJCard.java) implementiert die im Blackjack Spiel verwendeten Spielkarten. Darüber hinaus stellt diese Klasse auch den jeweiligen
Wert der einzelnen Karten zur Verfügung.

Die Klasse [BJHand](../../src/AB7/BJHand.java) implementiert die vom Spielteilnehmer (Spieler und Bank) gehaltenen Karten. Diese Klasse implementiert
auch den Blackjack-spezifischen Regelsatz zur Berechnung des Gesamtwerts der gehaltenen Karten. 

Mit der Klasse [BJDeck](../../src/AB7/BJDeck.java) wird ein vollständiges Päckchen (Deck) von 52 Standardkarten (4 Farben, 13 Werte) simuliert. Die Klasse implementiert dazu
Methoden, welche die Karten eine nach der anderen zur Verfügung stellen ("geben"), und welche das Päckchen mischen können.

Die Klasse [BJDealer](../../src/AB7/BJDealer.java) implementiert den Dealer des Spiels. Seine Aufgabe ist die Verwaltung des Decks (Geben der Karten, Mischen, etc.)
sowie die aktive Teilnahme am Spiel als Vertreter der Bank.

In der Hauptklasse der Anwendung des AB7 [Application:main()](../../src/AB7/Application.java) werden alle zu implementierenden Komponenten
zu einem vollständigen interaktiven Blackjack-Spiel verbunden. 

Zur Lösung der Aufgabenstellung ist das vorgegebene Code-Skelett entsprechend dieser Angabe sowie der Kommentare im
Quellcode anzupassen und zu vervollständigen. Der Übersichtlichkeit halber sind relevante Stellen im Quellcode mit 
```@TODO``` gekennzeichnet.

Die für dieses Aufgabenblatt zu bearbeitenden Dateien sind:

* [BadDeckException.java](../../src/AB7/BadDeckException.java)
* [BJCard.java](../../src/AB7/BJCard.java)
* [BJDealer.java](../../src/AB7/BJDealer.java)
* [BJDeck.java](../../src/AB7/BJDeck.java)
* [BJHand.java](../../src/AB7/BJHand.java)
* [BJPlayer.java](../../src/AB7/BJPlayer.java)
* [IllegalOperationException.java](../../src/AB7/IllegalOperationException.java)
* [OutOfCardsException.java](../../src/AB7/OutOfCardsException.java)
* [Application.java](../../src/AB7/Application.java)
* [MCTestAB7.java](../../src/AB7/MCTestAB7.java)

Darüber hinaus erhalten Sie wieder ein Paket/Verzeichnis [Interfaces](../../src/AB7/Interfaces) mit
Interface-Definitionen. Diese sind für Ihre Implementierungsarbeit relevant, dürfen aber wie gewohnt nicht verändert
werden.

Die Hauptklasse der Anwendung, also der Einstiegspunkt in die Anwendungslogik, ist die Klasse
[Application](../../src/AB7/Application.java). Dort werden in der Methode ```Application.main()``` alle notwendigen Objekte
erzeugt, um die Funktionsweise der Anwendung zu demonstrieren. Sie dürfen das vorgegebene Spiel beliebig abändern, um 
Ihre Klassen entsprechend zu testen. Weitere Anwendungs- wie auch etwaige selbst entwickelte
Testfälle sollen dort ebenfalls implementiert werden.


### Teilaufgabe 1

Absolvieren Sie den Multiple-Choice-Test. Um die MC Fragen zu beantworten, editieren Sie die Datei [MCTestAB7.java](../../src/AB7/MCTestAB7.java)
und befolgen Sie die Anweisungen aus den Kommentaren in der Datei. Führen Sie diese Datei dann zur Kontrolle aus.
Eine Auswertung Ihrer Ergebnisse kann nach Einreichung Ihrer Abgabe Server-seitig erfolgen.

### Teilaufgabe 2

Implementieren Sie die mit ```TODO: implementation``` gekennzeichneten Methoden.
Testen Sie jede einzelne Klasse gewissenhaft, auch jene Methoden die vom Beispielcode in ```Application.main()```
nicht aufgerufen werden.
Vergleichen Sie die von Ihrer Implementierung gemachten Berechnungen bzw. Ausgaben mit
bekannten oder manuell berechneten Werten. Sie dürfen dazu in der Datei [Application.java](../../src/AB7/Application.java) 
Änderungen nach Belieben vornehmen. Diese Datei muss für eine erfolgreiche Abgabe zwar ausführbar sein, wird aber nicht
zur Bewertung herangezogen.


#### Beispielausgabe

Hinweis: Da das Spiel ein Kartenspiel ist, und daher der Zufall eine wesentliche Rolle spielt, wird die tatsächliche Ausgabe
von der hier angegebenen abweichen. Strukturell ist aber trotzdem klar zu erkennen, wie die einzelnen Bausteine funktionieren
bzw. was diese ausgeben sollten.

Bei korrekter Implementierung aller TODOs bewirkt folgender Code bei Aufruf von [Application.main()](../../src/AB7/Application.java)

```java
public class Application {
  public static void main(String[] args) {

    // create a dealer with a new deck
    Deck casinoDeck = new BJDeck();
    Dealer dealer = new BJDealer(casinoDeck);

    // create a player
    BJHand hand = new BJHand();
    BJPlayer player = new BJPlayer(hand, dealer);

    // before the games start, shuffle the dealer's deck
    dealer.shuffleDeck();
    System.out.println("Deck shuffled!");

    // now run interactive games of Blackjack
    boolean gameLoop = true;
    while (gameLoop) {

      // start game for player drawing a starting hand
      Hand playerStartingHand = player.startGame();

      // prepare starting hand for the dealer
      // due to specific Blackjack rules, the dealer's hand has to be constructed upfront
      Hand dealerStartingHand = new BJHand();
      dealerStartingHand.addCard(dealer.dealCard());
      dealerStartingHand.addCard(dealer.dealCard());

      System.out.println("---------------------------------------");
      System.out.println("Dealer has: " + dealerStartingHand + " (" + dealerStartingHand.getScore() + ")");
      System.out.println("Player has: " + playerStartingHand + " (" + playerStartingHand.getScore() + ")");
      System.out.println("---------------------------------------");

      if (player.getScore() != 100) {
        if (dealerStartingHand.getScore() != 100) {   // no draw so lets play
          // player starts
          Hand playerHand;

          Scanner scanner = new Scanner(System.in);
          boolean loop = true;
          while (loop) {
            System.out.println("What do you want to do? [ (h)it, (s)tay ,(q)uit ]?");
            char c = scanner.next().charAt(0);
            switch (c) {
              case 'h':   // hit -> get another card
                playerHand = player.hit();
                System.out.println("new hand: " + playerHand + " (" + player.getScore() + ")");
                if (player.getScore() == 0) {
                  loop = false;
                  System.out.println("BUSTED!");
                }
                break;
              case 's':   // stay -> no more cards
                System.out.println("Player stays. The final hand is: " + " (" + player.getScore() + ")");
                loop = false;
                break;
              case 'q':
                System.out.println("Quitting...");
                loop = false;
                gameLoop = false;
                break;
              default:
                System.out.println("Invalid input!");
            }
          }

          // then the dealer
          Hand dealerHand = dealerStartingHand.clone();
          int dealerScore = dealer.playAction(dealerHand);
          System.out.println("Dealer final hand:" + dealerHand + " (" + dealerHand.getScore() + ")");
          if (dealerScore == 0) {
            System.out.println("BUSTED!");
          }
          System.out.println("---------------------------------------");
          System.out.println((dealerScore > player.getScore()) ? "Player loses." :
                  (player.getScore() > dealerScore) ? "Player wins!" : "Draw");
        } else {
          System.out.println("Dealer wins with Blackjack!");
        }
      } else {
        System.out.println("Player wins with Blackjack!");
      }
      System.out.println("=======================================");

      System.out.println();
    }

    // TODO: implementation of any developer specific tests (optional)

  }
}
```
eine Ausgabe ähnlich der nachfolgenden am Bildschirm:

```txt
Deck shuffled!
---------------------------------------
Dealer has: [ QUEEN of HEARTS (10), SEVEN of DIAMONDS (7) ] (17)
Player has: [ KING of SPADES (10), FIVE of SPADES (5) ] (15)
---------------------------------------
What do you want to do? [ (h)it, (s)tay ,(q)uit ]?
h
new hand: [ KING of SPADES (10), FIVE of SPADES (5), JACK of SPADES (10) ] (0)
BUSTED!
Dealer final hand:[ QUEEN of HEARTS (10), SEVEN of DIAMONDS (7) ] (17)
---------------------------------------
Player loses.
=======================================

---------------------------------------
Dealer has: [ SEVEN of CLUBS (7), THREE of DIAMONDS (3) ] (10)
Player has: [ QUEEN of CLUBS (10), THREE of SPADES (3) ] (13)
---------------------------------------
What do you want to do? [ (h)it, (s)tay ,(q)uit ]?
h
new hand: [ QUEEN of CLUBS (10), THREE of SPADES (3), ACE of CLUBS (11) ] (14)
What do you want to do? [ (h)it, (s)tay ,(q)uit ]?
h
new hand: [ QUEEN of CLUBS (10), THREE of SPADES (3), ACE of CLUBS (11), SIX of CLUBS (6) ] (20)
What do you want to do? [ (h)it, (s)tay ,(q)uit ]?
s
Player stays. The final hand is:  (20)
Dealer final hand:[ SEVEN of CLUBS (7), THREE of DIAMONDS (3), TEN of HEARTS (10) ] (20)
---------------------------------------
Draw
=======================================

---------------------------------------
Dealer has: [ ACE of SPADES (11), NINE of HEARTS (9) ] (20)
Player has: [ FIVE of DIAMONDS (5), JACK of DIAMONDS (10) ] (15)
---------------------------------------
What do you want to do? [ (h)it, (s)tay ,(q)uit ]?
q
Quitting...
Dealer final hand:[ ACE of SPADES (11), NINE of HEARTS (9) ] (20)
---------------------------------------
Player loses.
=======================================
```


