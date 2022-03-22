package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static int p1Score = 0;
    private static int p2Score = 0;
    private static boolean cheats = false;

    public static void main(String[] args) {
        boolean p1Turn = true;
        String current;
        String P1 = getInput("player 1 name:");
        String P2 = getInput("player 2 name:");
        int size = getInt("how big should the array be?");
        int guesses = getInt("how many guesses should each person get?");
        String cheat = getInput("do you want to know if the array location was filled?");
        if (cheat.equals("yes")) {
            cheats = true;
        }
        System.out.println(size);
        String[] array = new String[size];
        int guessTotal = 0;
        while (guessTotal < guesses * 2) {
            if (p1Turn) {
                current = P1;
            } else {
                current = P2;
            }
            int guess = getInt("where would you like to place your token " + current + "?");
            if (array[guess] == null) {
                array[guess] = current;
                if (p1Turn) {
                    p1Score++;
                } else {
                    p2Score++;
                }
                if (cheats) {
                    System.out.println("hit");
                }

            } else {
                if (cheats) {
                    System.out.println("miss");
                }
            }

            p1Turn = !p1Turn;
            guessTotal++;
        }
        if (p1Score > p2Score) {
            System.out.println(P1 + " wins!");
        }
        if (p2Score > p1Score) {
            System.out.println(P2 + " wins!");
        }
        if (p2Score == p1Score) {
            System.out.println("its a draw!");
        }
        System.out.println(Arrays.toString(array));

    }

    private static String getInput(String prompt) {
        System.out.println(prompt);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private static int getInt(String prompt) {
        System.out.println(prompt);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

}
