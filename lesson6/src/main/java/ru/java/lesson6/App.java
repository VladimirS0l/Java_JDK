package ru.java.lesson6;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class App {
    private static final String playerStr = "Player";
    private static final String leadingStr = "Leading";
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void main( String[] args ) {
        String start = "";
        HashMap<Integer, Result> map = new HashMap<>();
        while (!start.equals("q")) {
            int count = 0;
            System.out.println("Enter yor choice: ");
            start = scanner.nextLine();
            switch (start) {
                case "p":
                    System.out.println("Игра началась:\n");
                    int iterable = scanner.nextInt();
                    for (int i = 0; i < iterable; i++) {

                        int car = random.nextInt(1,4);
                        int player = random.nextInt(1,4);
                        int leading = random.nextInt(1,4);
                        while (leading == car && leading == player) {
                            leading = random.nextInt(1,4);
                        }
                        while (player == leading) {
                            player = random.nextInt(1,4);
                        }
                        boolean result = player == car;
                        if (result) {
                            count++;
                        }
                        Result resultPlayer = new Result(i, car, leading, player, result, count);
                        map.put(i, resultPlayer);
                    }
                    double success = Math.round(((double)count / iterable) * 100);
                    System.out.println("Result:\n" +
                            "Successful= " + success + "%");
                    System.out.println("Fail= " + (100-success) + "%");
                    break;
                case "q":
                    break;
            }
        }


    }
}
