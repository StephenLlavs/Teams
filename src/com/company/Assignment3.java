package com.company;

import java.util.Scanner;
import java.util.ArrayList;

public class Assignment3 {
    public static Athlete get_athlete_data(Scanner scanner)
    {
        //Variables and Arrays for storing
        String first_name, last_name;
        int id;
        ArrayList<Integer> scores = new ArrayList<Integer>();

        // Asking user for FirstName, LastName, ID number
        System.out.print("Enter player first name: ");
        first_name = scanner.nextLine();

        System.out.print("Enter player last name: ");
        last_name = scanner.nextLine();

        System.out.print("Enter player id number: ");

        // Checking if User input is valid
        while (!scanner.hasNextInt()) {
            System.out.print("That is not a valid number. Please enter a valid number: ");
            scanner.nextLine();
        }
        id = scanner.nextInt();
        scanner.nextLine();

        // Asking User for score per game and checking if its Valid
        boolean end = false;
        while (!end)
        {
            System.out.print("Enter the games score per game of the player, press 1 to end: ");
            while (!scanner.hasNextInt()) {
                System.out.print("That is not a valid number. Please enter a valid number: ");
                scanner.nextLine();
            }
            int input = scanner.nextInt();
            scanner.nextLine();
            if (input == 1)
                end = true;
            else
                scores.add(input);
        }

        return new Athlete(first_name, last_name, id, scores);
    }

    // Asking how many Players are going to be inputted and checking if its valid
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("How many players are you going to enter? ");
        while (!scanner.hasNextInt()) {
            System.out.print("That is not a valid number. Please enter a valid number: ");
            scanner.nextLine();
        }
        int num_players = scanner.nextInt();
        scanner.nextLine();
        while (num_players <= 0) {
            System.out.print("That is not a valid number. Please enter a valid number: ");
            num_players = scanner.nextInt();
            scanner.nextLine();
        }

        // Storing Athletes/Players in an Array lists
        Athlete athletes[] = new Athlete[num_players];
        for (int i = 0; i < num_players; i++)
        {
            athletes[i] = get_athlete_data(scanner);
        }

        System.out.printf("%-20s%s%n", "Player", "Stats");
        System.out.printf("**************************%n");
        for (Athlete athlete : athletes)
        {
            athlete.display_results();
        }
    }
}
