package services;

import java.util.Random;

public class Helper {
    public static int getRandomIntInRange(int min, int max) {
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }
}
