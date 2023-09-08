package org.studiosolution;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    /** Items we need while app is running **/
    static Scanner doubleInput = new Scanner(System.in);
    static Scanner stringInput = new Scanner(System.in);
    static List<MenuItem> allItems = new ArrayList<>();


    /** Main Method **/
    /** Main Method **/
    /** Main Method **/
    public static void main(String[] args) {
        System.out.println("Create your menu items here\n");

        /** Infinite Prompts **/
        /** Infinite Prompts **/
        /** Infinite Prompts **/
        while (true) {
            System.out.println("Please Select\n1. Make Item\n2. View Menu\n3. Create Default Menu\n4. View Item Details\n5. Remove an Item from the Menu\n0. Exit App");

            double choice;

            try {
                choice = doubleInput.nextDouble();
            } catch (Exception e) {
                System.out.println("\nInvalid input\n");
                break;
            }

            /** Choose Method to Run **/
            if (choice == 1) {
                makeMenuItem();
            }
            if (choice == 2) {
                viewMenuItems();
            }
            if (choice == 3) {
                allItems.addAll(Menu.createDefaultMenu());
                System.out.println("Default menu has been created.\n");
            }
            if (choice == 4) {
                viewChoiceMenuItems();
            }
            if (choice == 5) {
                removeMenuItem();
            }
            if (choice == 0) {
                System.out.println("\nApp is terminating\n......\n.....\n...\n..\n.\n.");
            }

        }
    }

    /** Series of prompts to make a menu item **/
    /** Series of prompts to make a menu item **/
    /** Series of prompts to make a menu item **/
    static public void makeMenuItem() {
        System.out.println("Nice! Lets make an item.\n\nWhat is the items name?");
        String itemName = stringInput.nextLine();

        System.out.println("\nSo the name of the item is " + itemName + ". Okay, how would you describe it?");
        String itemDescription = stringInput.nextLine();

        System.out.println("\nSo you would describe this '" +itemName + "' as...\n" + itemDescription + "\n\nAlright, is this an app, meal, or drink?");
        String itemCategory = stringInput.nextLine();

        System.out.println("\nOkay, this item is a " + itemCategory + ". How much does it cost?");
        double itemCost = doubleInput.nextDouble();

        System.out.println("\nIs the item new? 1 for yes, 2 for no");
        double itemNew = doubleInput.nextDouble();
        String isItNew;

        if(itemNew == 1) {
            isItNew = "Yes";
        } else {
            isItNew = "No";
        }

        System.out.println("\nAlright, so we have an item with the stats\nname: " + itemName + "\ndescription: " + itemDescription + "\ncategory: " + itemCategory + "\ncost: " + itemCost + "\nNew: " + isItNew +"\n\nIf this is correct, press 1 to add it to the menu item repository, or 0 to start over.");
        double proceed = doubleInput.nextDouble();

        if (proceed == 1) {
            MenuItem newItem = new MenuItem(itemName, itemCost, itemDescription, itemCategory, true);

            allItems.add(newItem);

            System.out.println("\nHere are all the items in your menu item repository.\n");

            for(MenuItem menuItems : allItems) {
                System.out.println(menuItems.getName().toUpperCase());
            }
            System.out.println("\n");

        } else if (proceed == 0) {
            System.out.println("\nItem has been deleted, returning to the root menu.");
        } else {
            System.out.println("\nInvalid entry, returning to root.");
        }
    }

    /** View all Menu Items **/
    /** View all Menu Items **/
    /** View all Menu Items **/
    static public void viewMenuItems() {
        System.out.println("\nHere are all the items in our menu item repository.\n");

        for(MenuItem menuItems : allItems) {
            System.out.println(menuItems.getName().toUpperCase());
        }

        System.out.println("\n");
    }

    /** Select an item by name and view the details of the item **/
    /** Select an item by name and view the details of the item **/
    /** Select an item by name and view the details of the item **/
    static public void viewChoiceMenuItems() {
        System.out.println("\nWhat is the name of the item you want to view?");
        String itemQuery = stringInput.nextLine().toLowerCase();
        Integer count = 1;
        for (MenuItem item : allItems) {
            count = count + 1;
            if(itemQuery.equals(item.getName().toLowerCase())) {
                System.out.println(item.getItemDetails());
                break;
            }
        }
        if (count == allItems.size()) {
            System.out.println("\nNo items were found\n");
        }

    }

    /** Remove item from menu by name **/
    /** Remove item from menu by name **/
    /** Remove item from menu by name **/

    static public void removeMenuItem() {
        System.out.println("\nWhat is the name of the item you want to remove?");
        String deleteItem = stringInput.nextLine().toLowerCase();

        for (MenuItem item : allItems) {
            if (deleteItem.equals(item.getName().toLowerCase())) {
                System.out.println("Are you sure you want to delete this item? Enter 1 for yes, 2 for no.");
                double response = doubleInput.nextDouble();
                if (response == 1) {
                    allItems.remove(item);
                    System.out.println("Item removed!\n");
                    break;
                } else if (response == 0) {
                    System.out.println("Item not removed.\n");
                }
            }
        }
    }

}
