package org.studiosolution;

public class MenuItem {

    private String name;
    private double price;
    private String description;
    private String category;
    private boolean isNew;

    public MenuItem(String name, double p, String d, String c, boolean iN) {
        this.name = name;
        this.price = p;
        this.description = d;
        this.category = c;
        this.isNew = iN;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setNew(boolean aNew) {
        isNew = aNew;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /** Item detail format **/
    public String getItemDetails() {
        return "\nName: " + this.name + "\nDescription: " + this.description + "\nCategory: " + this.category + "\nPrice: " + this.price + "\nNew: " + isItNew() + "\n";
    }

    /** Return string based on boolean **/
    public String isItNew() {
        if (this.isNew) {
            return "Yes";
        } else {
            return "No";
        }

    }
}

