package services;

import java.util.ArrayList;
import java.util.Random;

public class Helper {
    public static int getRandomIntInRange(int min, int max) {
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }

    public static double getRandomDoubleInRange(int min, int max) {
        Random rand = new Random();
        return min + (max - min) * rand.nextDouble();
    }

    public static String[] split(String string, char delimeter) {
        ArrayList<String> result = new ArrayList<>();
        char[] charsArray = string.toCharArray();
        String word = "";

        for (char character : charsArray) {
            if (character != delimeter) {
                word += character;
            } else {
                if (!word.equals("")) {
                    result.add(word);
                    word = "";
                }
            }
        }

        if (!word.equals("")) {
            result.add(word);
        }

        String[] arrayResult = new String[result.size()];
        int i = 0;

        for (String resultWord : result) {
            arrayResult[i++] = resultWord;
        }

        return arrayResult;
    }
}
