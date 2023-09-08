package org.studiosolution;

import java.util.ArrayList;
import java.util.Date;

public class Menu {
    private Date lastUpdated;
    private ArrayList<MenuItem> items;

    public Menu(Date d, ArrayList<MenuItem> i) {
        this.lastUpdated = d;
        this.items = i;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public void setItems(ArrayList<MenuItem> items) {
        this.items = items;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public ArrayList<MenuItem> getItems() {
        return items;
    }

    /** Return a default menu any time with Menu class **/
    /** Return a default menu any time with Menu class **/
    /** Return a default menu any time with Menu class **/

    public static ArrayList<MenuItem> createDefaultMenu() {
        ArrayList<MenuItem> preMadeMenu = new ArrayList<>();

        MenuItem item1 = new MenuItem("Pizza", 18.99, "A delicious pizza", "Meal", true);
        MenuItem item2 = new MenuItem("Hamburger", 9.99, "A delicious Hamburger", "Meal", false);
        MenuItem item3 = new MenuItem("Chocolate Cake", 8.99, "Incredible Chocolate Cake", "Dessert", false);
        MenuItem item4 = new MenuItem("Cheese Cake", 9.99, "Delicious Cheese Cake", "Dessert", false);
        MenuItem item5 = new MenuItem("Espresso Martini", 10.99, "Amazing Espresso Martini", "Drink", true);
        MenuItem item6 = new MenuItem("Old Fashion", 10.99, "A classic Old Fashion", "Drink", true);
        MenuItem item7 = new MenuItem("Buffalo Wings", 8.99, "Bone or Boneless", "Appetizer", false);
        MenuItem item8 = new MenuItem("Perfect Steak", 14.99, "Delicious 100oz Steak", "Meal", true);

        preMadeMenu.add(item1);
        preMadeMenu.add(item2);
        preMadeMenu.add(item3);
        preMadeMenu.add(item4);
        preMadeMenu.add(item5);
        preMadeMenu.add(item6);
        preMadeMenu.add(item7);
        preMadeMenu.add(item8);

        return preMadeMenu;
    }
}
