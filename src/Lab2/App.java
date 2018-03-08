package Lab2;

import services.Helper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class App {
    public static void run() {
        ArrayList<Card> deck = new ArrayList<Card>();
        Scanner scanner = new Scanner(System.in);
        App.displayMenu();

        while (scanner.hasNext()) {
            int option = scanner.nextInt();

            if (option == 0) {
                break;
            }

            switch (option) {
                case 1:
                    deck = App.generateRandomSortedDeck();
                    break;
                case 2:
                    App.displayDeck(deck);
                    break;
                case 3:
                    if (deck != null) {
                        System.out.println(deck.size());
                    }
                    break;
                case 4:
                    System.out.println("Podaj wartość <1, 13>");
                    App.displayByValue(deck, scanner.nextInt());
                    break;
                case 5:
                    System.out.println("Podaj kolor <0, 3>");
                    App.displayByColor(deck, scanner.nextInt());
                    break;
                case 6:
                    App.removeDuplicates(deck);
                    break;
            }

            App.displayMenu();
        }
    }

    private static ArrayList<Card> generateRandomSortedDeck() {
        ArrayList<Card> deck = new ArrayList<Card>();
        int randomValue;

        while ((randomValue = Helper.getRandomIntInRange(Card.MIN_VALUE - 1, Card.MAX_VALUE)) > 0) {
            int randomColor = Helper.getRandomIntInRange(Card.MIN_COLOR, Card.MAX_COLOR);
            Card newCard = new Card(randomValue, randomColor);

            if (deck.size() > 0) {
                int index = deck.size();

                for (Card card : deck) {
                    if (newCard.getValue() < card.getValue()) {
                        index = deck.indexOf(card);
                        break;
                    } else if (newCard.getValue() == card.getValue()) {
                        index = newCard.getColor() < card.getColor() ? deck.indexOf(card) : deck.indexOf(card) + 1;
                    }
                }

                deck.add(index, newCard);
            } else {
                deck.add(newCard);
            }
        }

        return deck;
    }

    private static void displayMenu() {
        System.out.println("\n0 - zakończ program");
        System.out.println("1 - utwórz liste");
        System.out.println("2 - wyświetl liste");
        System.out.println("3 - wyświetl liczbe elementow");
        System.out.println("4 - wyswietl karty z wartoscia");
        System.out.println("5 - wyswietl karty z kolorem");
        System.out.println("6 - usuń duplikaty kart\n");
    }

    private static void displayDeck(ArrayList<Card> deck) {
        if (checkDeck(deck)) {
            for (Card card : deck) {
                System.out.println(card);
            }
        }
    }

    private static void displayDeckWithWhile(ArrayList<Card> deck) {
        if (App.checkDeck(deck)) {
            Iterator iterator = deck.iterator();

            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        }
    }

    private static void displayDeckWithFor(ArrayList<Card> deck) {
        if (checkDeck(deck)) {
            for (Iterator iterator = deck.iterator();iterator.hasNext(); ) {
                System.out.println(iterator.next());
            }
        }
    }

    private static void displayByValue(ArrayList<Card> deck, int value) {
        if (App.checkDeck(deck)) {
            for (Card card : deck) {
                if (card.getValue() == value) {
                    System.out.println(card);
                }
            }
        }
    }

    private static void displayByColor(ArrayList<Card> deck, int color) {
        if (App.checkDeck(deck)) {
            for (Card card : deck) {
                if (card.getColor() == color) {
                    System.out.println(card);
                }
            }
        }
    }

    private static boolean checkDeck(ArrayList deck) {
        if (deck == null || deck.size() == 0) {
            System.out.println("Talia jest pusta");
            return false;
        }

        return true;
    }

    private static void removeDuplicates(ArrayList<Card> deck) {
        if (App.checkDeck(deck)) {
            boolean[][] valuesOptions = new boolean[13][];
            ArrayList<Card> newDeck = new ArrayList<Card>();

            for (Card card : deck) {
                int valueIndex = card.getValue() - 1;
                if (valuesOptions[valueIndex] != null) {
                    if (!valuesOptions[valueIndex][card.getColor()]) {
                        valuesOptions[valueIndex][card.getColor()] = true;
                        newDeck.add(card);
                    }
                } else {
                    boolean[] colorsOptions = new boolean[4];
                    valuesOptions[valueIndex] = colorsOptions;
                    valuesOptions[valueIndex][card.getColor()] = true;
                    newDeck.add(card);
                }
            }
            deck.clear();
            deck.addAll(newDeck);
        }
    }
}
