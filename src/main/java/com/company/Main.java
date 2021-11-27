package com.company;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;

public class Main {

    private static final String BR = "========";

    public static void main(String[] args) throws InterruptedException, IOException, URISyntaxException {
        Viewer viewer;
        String input;

        Scanner scanner = new Scanner(System.in);
        newline();
        System.out.println(BR + " WELCOME TO THE ZENDESK TICKET VIEWER! " + BR);

        while (true) {
            // main menu
            newline();
            System.out.println(BR + " MAIN MENU " + BR);
            System.out.println("What would you like to do?");
            System.out.println("[1] View all tickets");
            System.out.println("[2] View ticket by ID");
            System.out.println("[3] Quit");
            newline();
            System.out.print("> ");
            input = scanner.nextLine().trim();

            if (input.equals("1") || input.equals("[1]")) {
                // view first ticket page
                viewer = Viewer.getFirstPage();
                viewTicketPage(viewer);

                // ticket pagination loop
                while (true) {
                    System.out.println("What would you like to do?");
                    System.out.println("[1] Next page");
                    System.out.println("[2] Previous page");
                    System.out.println("[3] View ticket by ID");
                    System.out.println("[4] Back to main menu");
                    newline();
                    System.out.print("> ");
                    input = scanner.nextLine().trim();

                    if (input.equals("1") || input.equals("[1]")) {
                        // view next ticket page
                        viewer = viewer.getNextPage();
                        viewTicketPage(viewer);

                    } else if (input.equals("2") || input.equals("[2]")) {
                        // view previous ticket page
                        viewer = viewer.getPreviousPage();
                        viewTicketPage(viewer);

                    } else if (input.equals("3") || input.equals("[3]")) {
                        // view single ticket details
                        viewSingleTicket(scanner);
                        break;
                    } else if (input.equals("4") || input.equals("[4]")) {
                        // return to main menu
                        break;
                    } else {
                        // invalid command
                        newline();
                        System.out.println("Please enter a valid command! Returning to main menu...");
                        break;
                    }
                }

            } else if (input.equals("2") || input.equals("[2]")) {
                // view single ticket details
                viewSingleTicket(scanner);

            } else if (input.equals("3") || input.equals("[3]")) {
                // quit
                newline();
                System.out.println(BR + " THANK YOU FOR USING THE ZENDESK TICKET VIEWER. GOODBYE! " + BR);
                break;

            } else {
                // invalid command
                newline();
                System.out.println("Please enter a valid command!");
            }
        }
    }

    private static void viewTicketPage(Viewer viewer) throws InterruptedException, IOException, URISyntaxException {
        newline();
        System.out.println(BR + " YOUR TICKETS " + "(PAGE " + viewer.getPage() + ") " + BR);
        System.out.println(viewer.displayPage());
    }

    private static void viewSingleTicket(Scanner scanner) {
        newline();
        System.out.println("Please enter ticket ID:");
        System.out.print("> ");
        String input = scanner.nextLine().trim();

        try {
            newline();
            int n = Integer.parseInt((input));
            Viewer viewer = Viewer.getSingleTicket(n);
            System.out.println(viewer.displayPage()); // make detailed

        } catch (NumberFormatException c) {
            System.out.println("Oh no! Ticket IDs must be integers. Retuning to main menu...");
        } catch (IOException | URISyntaxException | InterruptedException e) {
            System.out.println("Oh no! There are no tickets with the ID you entered. Returning to main menu...");
        }
    }

    private static void newline() {
        System.out.println();
    }
}
