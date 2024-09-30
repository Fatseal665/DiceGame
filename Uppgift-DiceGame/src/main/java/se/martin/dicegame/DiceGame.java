package se.martin.dicegame;

import java.util.Scanner;
import java.util.Random;

public class DiceGame {
   static Scanner scanner = new Scanner(System.in);
   static Random random = new Random();
   static boolean continueGame = true;

   //Skapar spelare
    public static Player createPlayer(int playerNum) {
        System.out.println("Ange namn för spelare " + playerNum + ": ");
        String name = scanner.nextLine();

        Player player = new Player(name, 0);
        return player;
    }


    //Kastar tärning och adderar kasten
    public static void rollDice(Player player) {

        int sum = 0;
        System.out.println(player.getName() + ", din tur! Tryck på enter för att kasta: ");

        String kast1 = scanner.nextLine();
        if (!kast1.equals(" ")) {
        }
        int roll1 = random.nextInt(6) + 1;

        System.out.println("Du kastade " + roll1 + ". Kasta igen ");

        String kast2 = scanner.nextLine();
        if (!kast2.equals(" ")) {
        }
        int roll2 = random.nextInt(6) + 1;
        System.out.println("Du kastade " + roll2);

        //Summa av kast spelare
        sum = roll1 + roll2;
        player.setScore(sum);
        System.out.println("Du fick totalt " + player.getScore() + " poäng!\n");
    }


    //Jämför summan av spelarnas kast och utser vinnare
    public static void results(Player player1, Player player2) {
        if (player1.getScore() > player2.getScore()) {
            System.out.println("Grattis " + player1.getName() + "! Du vann");
        } else if (player1.getScore() < player2.getScore()) {
            System.out.println("Grattis " + player2.getName() + "! Du vann");
        } else if (player1.getScore() == player2.getScore()) {
            System.out.println("Oavgjort");
        }
    }


    //Spela igen eller inte
    public static boolean replayGame() {
        System.out.println("Vill du spela igen? ja/nej");

        String val = scanner.nextLine();

        if (val.equals("nej")) {
            System.out.println("\nTack för att ni spelade! \nHejdå!\n");
            continueGame = false;
        }
        while (true) {
            if (!val.equals("ja") && !val.equals("nej")) {
                System.out.println("Skriv ja eller nej!");
                val = scanner.nextLine();

            } else {
                break;
            }
        }
        return continueGame;
    }


    //Spelet
    public static void main(String[] args) {

        while (continueGame) {

            //Välkomstmeddelande + metod för att skapa spelare
            System.out.println("\n*Välkommna till tärningsspelet!*\n");
            Player player1 = createPlayer(1);
            Player player2 = createPlayer(2);


            //Spelet instruktioner
            System.out.println("\nNi ska nu slå en tärning två gånger");


            //Spelare 1 och spelare 2 kastar
            rollDice(player1);
            rollDice(player2);


            //Resultat
            results(player1, player2);


            //Spela om eller avsluta
            replayGame();


        }
    }
}

