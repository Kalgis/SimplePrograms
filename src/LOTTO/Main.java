package LOTTO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> lotto = new ArrayList<>();
        for (int i = 1; i <= 49; i++) {
            lotto.add(i);
        }
        Collections.shuffle(lotto);
        List<Integer> lottoDraw = lotto.stream().limit(6).collect(Collectors.toList());
        Collections.sort(lottoDraw);

        List<Integer> userGuesses = new ArrayList<>();
        boolean invalidNumber = false;
        int number = 0;
        for (int i = 0; i < 6; i++) {
            do {
                System.out.print("Please, pick a number: ");
                if (scan.hasNextInt()) {
                    number = scan.nextInt();
                    invalidNumber = false;
                    if ((number > 49) || (number < 1)) {
                        System.out.println("Please, pick a number from 1 to 49");
                        invalidNumber = true;
                    }
                    if (userGuesses.contains(number)) {
                        System.out.println("Please, select dfferent number");
                        invalidNumber = true;
                    }
                } else {
                    scan.next();
                    System.out.println("It's not a number!");
                    invalidNumber = true;
                }
            } while (invalidNumber);
            userGuesses.add(number);

        }
        Collections.sort(userGuesses);
        System.out.println("Your numbers are: " + userGuesses);
        System.out.println("Lotto Results: " + lottoDraw);
        List<Integer> userGuessed = new ArrayList<>();
        int result = 0;
        for (Integer guess : userGuesses) {
            if (lottoDraw.contains(guess)) {
                result++;
                userGuessed.add(guess);
            }
        }
        if (result >= 1) {
            System.out.println("You guess: " + userGuessed);
            System.out.println("You guess this many numbers: " + result);
            System.out.println("Congratulations!!!");
        }
    }
}