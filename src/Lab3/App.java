package Lab3;

import services.Helper;

import java.util.Scanner;

public class App {
    public static void run() {
        SinglyLinkedList<Card> deck = new SinglyLinkedList<Card>();
        Scanner scanner = new Scanner(System.in);
        App.displayMenu();

        while (scanner.hasNext()) {
            int option = scanner.nextInt();

            if (option == 0) {
                break;
            }

            switch (option) {
                case 1:
                    deck = App.generateRandomSortedSinglyLinkedDeck();
                    break;
                case 2:
                    if (deck != null) {
                        deck.display();
                    }
                    break;
                case 3:
                    if (deck != null) {
                        System.out.println("Liczba Elementów: " + deck.size());
                    }
                    break;
                case 4:
                    System.out.println("Podaj wartość <1, 13>");
                    int value = scanner.nextInt();
                    for (int i = 0; deck != null && i < deck.size(); i++) {
                        Card card = deck.get(i);
                        if (card.getValue() == value) {
                            System.out.println(card);
                        }
                    }
                    break;
                case 5:
                    System.out.println("Podaj kolor <0, 3>");
                    int color = scanner.nextInt();
                    for (int i = 0; deck != null && i < deck.size(); i++) {
                        Card card = deck.get(i);
                        if (card.getColor() == color) {
                            System.out.println(card);
                        }
                    }
                    break;
            }

            App.displayMenu();
        }
    }

    private static void displayMenu() {
        System.out.println("\n0 - zakończ program");
        System.out.println("1 - utwórz liste");
        System.out.println("2 - wyświetl liste");
        System.out.println("3 - wyświetl liczbe elementow");
        System.out.println("4 - wyswietl karty z wartoscia");
        System.out.println("5 - wyswietl karty z kolorem");
    }

    private static SinglyLinkedList<Card> generateRandomSortedSinglyLinkedDeck() {
        SinglyLinkedList<Card> deck = new SinglyLinkedList<Card>();
        int randomValue;

        while ((randomValue = Helper.getRandomIntInRange(Card.MIN_VALUE - 1, Card.MAX_VALUE)) > 0) {
            int randomColor = Helper.getRandomIntInRange(Card.MIN_COLOR, Card.MAX_COLOR);
            Card newCard = new Card(randomValue, randomColor);

            if (deck.size() > 0) {
                int index = deck.size(), i = 0;

                for (int j = 0; j < deck.size(); j++) {
                    if (newCard.getValue() < deck.get(i).getValue()) {
                        index = i;
                        break;
                    } else if (newCard.getValue() == deck.get(i).getValue()) {
                        if (newCard.getColor() < deck.get(i).getColor()) {
                            index = i;
                            break;
                        } else if (newCard.getColor() == deck.get(i).getColor()) {
                            if (deck.size() <= i + 1) {
                                index = i + 1;
                                break;
                            } else if (deck.get(i + 1).getColor() > deck.get(i).getColor()) {
                                index = i;
                                break;
                            }
                        }
                    }
                    i++;
                }

                deck.add(index, newCard);
            } else {
                deck.add(newCard);
            }
        }

        return deck;
    }
}
