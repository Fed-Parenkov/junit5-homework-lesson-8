package parenkov.tests;

import java.util.Random;

public class Randomizer {

    void randomNumber() {
        Random rand = new Random();
        int upperbound = 10000;
        int int_rand = rand.nextInt(upperbound);
        String randNumber = String.valueOf(int_rand);
    }
}
