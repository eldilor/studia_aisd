package Lab3;

import services.Helper;

public class App {
    public static void run() {
        SinglyLinkedList<Card> deck = App.generateRandomSortedSinglyLinkedDeck();

        deck.display();
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
