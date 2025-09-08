package main;

import java.util.ArrayList;
import java.util.Scanner;


public class Shopping {
    private ArrayList<Items> availableItems;
    private ArrayList<Items> shoppingList;
    private Scanner scanner;

    // Set up lists and input reader
    public Shopping() {
        availableItems = new ArrayList<>();
        shoppingList   = new ArrayList<>();
        scanner        = new Scanner(System.in);
    }

    // Menu loop until user picks 7 to exit
    public void run() {
        int choice = 0;
        while (choice != 7) {
            showMenu();
            choice = getInt("Enter choice number: ");
            if (choice == 1) {
                addToShoppingList();
            } else if (choice == 2) {
                removeFromShoppingList();
            } else if (choice == 3) {
                printShoppingList();
            } else if (choice == 4) {
                addToAvailableItems();
            } else if (choice == 5) {
                removeFromAvailableItems();
            } else if (choice == 6) {
                printAvailableItems();
            } else if (choice == 7) {
                System.out.println("Exiting program. Goodbye!");
            } else {
                System.out.println("Invalid number. Try again.");
            }
        }
    }

    // Show the menu options
    private void showMenu() {
        System.out.println("\nShopping List");
        System.out.println("-------------");
        System.out.println("1) Add to Shopping List");
        System.out.println("2) Remove from Shopping List");
        System.out.println("3) Print Shopping List");
        System.out.println("\nAvailable Items");
        System.out.println("---------------");
        System.out.println("4) Add to Available Items");
        System.out.println("5) Remove from Available Items");
        System.out.println("6) Print Available Items");
        System.out.println("\n7) Exit Program");
    }

    // Read an integer from the user
    private int getInt(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.out.print("Please type a number: ");
        }
        int val = scanner.nextInt();
        scanner.nextLine(); // Consume leftover newline
        return val;
    }

    // Read a line of text
    private String getLine(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    // Add an item (by number) from AvailableItems to ShoppingList
    private void addToShoppingList() {
        if (availableItems.isEmpty()) {
            System.out.println("No items to add.");
            return;
        }
        printAvailableItems();
        int num = getInt("Item number to add: ");
        if (num < 1 || num > availableItems.size()) {
            System.out.println("That number is out of range.");
            return;
        }
        shoppingList.add(availableItems.get(num - 1));
        System.out.println("Item added.");
    }

    // Remove an item (by number) from ShoppingList
    private void removeFromShoppingList() {
        if (shoppingList.isEmpty()) {
            System.out.println("Your shopping list is empty.");
            return;
        }
        printShoppingList();
        int num = getInt("Item number to remove: ");
        if (num < 1 || num > shoppingList.size()) {
            System.out.println("That number is out of range.");
            return;
        }
        shoppingList.remove(num - 1);
        System.out.println("Item removed.");
    }

    // Show all items in the ShoppingList
    private void printShoppingList() {
        if (shoppingList.isEmpty()) {
            System.out.println("Shopping list is empty.");
            return;
        }
        System.out.println("Your Shopping List:");
        for (int i = 0; i < shoppingList.size(); i++) {
            System.out.println((i + 1) + ") " + shoppingList.get(i));
        }
    }

    // Let the user create and add a new AvailableItem
    private void addToAvailableItems() {
        String name = getLine("Item name: ");
        String dept = getLine("Department: ");
        float cost;
        System.out.print("Cost: ");
        while (!scanner.hasNextFloat()) {
            scanner.next();
            System.out.print("Please type a number: ");
        }
        cost = scanner.nextFloat();
        scanner.nextLine();
        availableItems.add(new Items(name, dept, cost));
        System.out.println("Available item added.");
    }

    // Remove an item (by number) from AvailableItems
    private void removeFromAvailableItems() {
        if (availableItems.isEmpty()) {
            System.out.println("No available items.");
            return;
        }
        printAvailableItems();
        int num = getInt("Item number to remove: ");
        if (num < 1 || num > availableItems.size()) {
            System.out.println("That number is out of range.");
            return;
        }
        availableItems.remove(num - 1);
        System.out.println("Available item removed.");
    }

    // Show all items in AvailableItems
    private void printAvailableItems() {
        if (availableItems.isEmpty()) {
            System.out.println("No available items.");
            return;
        }
        System.out.println("Available Items:");
        for (int i = 0; i < availableItems.size(); i++) {
            System.out.println((i + 1) + ") " + availableItems.get(i));
        }
    }
}
