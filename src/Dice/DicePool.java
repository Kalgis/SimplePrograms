package Dice;

import java.util.Random;
import java.util.Scanner;

public class DicePool {
    public static void main(String[] args) {
        System.out.println("Enter the type of throw in (xdy+z) form");
        Scanner scan = new Scanner(System.in);
        String diceCode = scan.next();
        if (!diceCode.contains("+"))
            diceCode += "+0";
        int x = 1, y, z = 0;
        if (Character.isDigit(diceCode.charAt(0)))
            x = diceCode.charAt(0) - 48;
        int yIndex = diceCode.indexOf('D') + 1;
        y = diceCode.charAt(yIndex) - 48;
        while (Character.isDigit(diceCode.charAt(yIndex + 1))) {
            yIndex++;
            y = y * 10 + diceCode.charAt(yIndex) - 48;
        }
        int zIndex = diceCode.indexOf('+') + 1;
        for (int i = zIndex; i < diceCode.length(); i++) {
            z = z * 10 + diceCode.charAt(i) - 48;
        }

        Random r = new Random();
        int result = 0;
        for (int i = 0; i < x; i++) {
            result += r.nextInt(y) + 1;
        }
        result += z;
        System.out.println("The result is " + result);
    }

}