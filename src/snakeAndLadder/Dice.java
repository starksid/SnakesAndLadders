package snakeAndLadder;

import java.util.Random;

public class Dice {
    Random random = new Random();
    private int Number;
    public void roll() {
        Number = random.nextInt(5) + 1;
    }

    public int getNumber() {
        roll();
        return Number;
    }

}
