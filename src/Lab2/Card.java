package Lab2;

import java.security.InvalidParameterException;

public class Card {
    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 13;
    public static final int MIN_COLOR = 0;
    public static final int MAX_COLOR = 3;

    private int value;
    private int color;

    private final String[] values = {"As", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Walet", "Dama", "Król"};
    private final String[] colors = {"Kier", "Karo", "Trefl", "Pik"};

    Card(int value, int color) {
        if (value < Card.MIN_VALUE || value > Card.MAX_VALUE) {
            throw new InvalidParameterException("Value must be from range <" + Card.MIN_VALUE + ";" + Card.MAX_VALUE + "> !");
        }

        if (color < Card.MIN_COLOR || color > Card.MAX_COLOR) {
            throw new InvalidParameterException("Color must be from range <" + Card.MIN_COLOR + ";" + Card.MAX_COLOR + "> !");
        }

        this.value = value;
        this.color = color;
    }

    public int getValue() {
        return value;
    }

    public int getColor() {
        return color;
    }

    @Override
    public String toString() {
        return this.values[this.value-1] + " " + this.colors[this.color] +
                "\t\t" + this.value + " | " + this.color;
    }
}
