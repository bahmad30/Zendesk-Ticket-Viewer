package com.company;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException, IOException, URISyntaxException {
        Viewer viewer;
        String input;
        String br = "========";
        Scanner scanner = new Scanner(System.in);

        newline();
        System.out.println(br + " WELCOME TO THE ZENDESK TICKET VIEWER! " + br);

        while (true) {
            newline();
            System.out.println(br + " MAIN MENU " + br);
            System.out.println("What would you like to do?");
            System.out.println("[1] View all tickets");
            System.out.println("[2] View ticket by ID");
            System.out.println("[3] Quit");
            newline();
            System.out.print("> ");
            input = scanner.nextLine().trim();

            if (input.equals("1") || input.equals("[1]")) {
                newline();
                viewer = Viewer.getFirstPage();
                System.out.println(br + " YOUR TICKETS " + "(PAGE " + viewer.getPage() + ") " + br);
                System.out.println(viewer.displayPage());

                // make pagination loop

            } else if (input.equals("2") || input.equals("[2]")) {
                newline();
                System.out.println("Please enter ticket ID:");
                System.out.print("> ");
                input = scanner.nextLine().trim();

                try {
                    newline();
                    int n = Integer.parseInt((input));
                    viewer = Viewer.getSingleTicket(n);
                    System.out.println(viewer.displayPage()); // make detailed

                } catch (NumberFormatException c) {
                    System.out.println("Oh no! Ticket IDs must be integers. Retuning to main menu...");
                } catch (IOException e) {
                    System.out.println("Oh no! There are no tickets with the ID you entered. Returning to main menu...");
                }

            } else if (input.equals("3") || input.equals("[3]")) {
                newline();
                System.out.println(br + " THANK YOU FOR USING THE ZENDESK TICKET VIEWER. GOODBYE! " + br);
                break;

            } else {
                newline();
                System.out.println("Please enter a valid command!");
            }

        }

    }

    private static void newline() {
        System.out.println();
    }


}
