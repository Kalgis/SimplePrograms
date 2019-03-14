package GuessGame;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Random r = new Random();
        int numb = r.nextInt(101);
        int number = 0;
        Scanner scan = new Scanner(System.in);
        System.out.println("Guess a number from 0 to 100: ");
        while (!(numb == number)) {
            try {
                number = scan.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("It's not a number!");
                scan.next();
            }
            if (number > numb) {
                System.out.println("Too many!");
            } else if (number < numb && number != 0) {
                System.out.println("Too less!");
            } else if (number == numb) {
                System.out.println("Correct :)");
            }

        }
    }
}