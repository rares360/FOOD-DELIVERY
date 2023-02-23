package model.products;

import java.io.Serializable;

public class MenuItem implements Comparable , Serializable {
    private String title;
    private double rating;
    private double calories;
    private double protein;
    private double fat;
    private double sodium;
    private double price;

    public MenuItem(String title, double rating, double calories, double protein, double fat, double sodium, double price) {
        this.title = title;
        this.rating = rating;
        this.calories = calories;
        this.protein = protein;
        this.fat = fat;
        this.sodium = sodium;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public double getProtein() {
        return protein;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    public double getFat() {
        return fat;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    public double getSodium() {
        return sodium;
    }

    public void setSodium(double sodium) {
        this.sodium = sodium;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public String toString(){
        return "TITLE: " + title + " RATING: " + Double.toString(rating) + " CALORIES: "
                + Double.toString(calories) + " PROTEIN: " + Double.toString(protein) + " FAT: " + Double.toString(fat) +
                " SODIUM: " + Double.toString(sodium) + " PRICE: " + Double.toString(price);
    }
    @Override
    public int compareTo(Object o) {
        if(this.title.compareTo(((MenuItem) o).title) < 0)
            return -1;
        if(this.title.compareTo(((MenuItem) o).title) > 0)
            return 1;
        if(this.rating < ((MenuItem) o).rating)
            return 1;
        if(this.rating > ((MenuItem) o).rating)
            return -1;
        if(this.price < ((MenuItem) o).price)
            return -1;
        if(this.price > ((MenuItem) o).price)
            return 1;
        if(this.calories < ((MenuItem) o).calories)
            return -1;
        if(this.calories > ((MenuItem) o).calories)
            return 1;
        if(this.protein < ((MenuItem) o).protein)
            return -1;
        if(this.protein > ((MenuItem) o).protein)
            return 1;
        if(this.fat < ((MenuItem) o).fat)
            return -1;
        if(this.fat > ((MenuItem) o).fat)
            return 1;
        if(this.sodium < ((MenuItem) o).sodium)
            return -1;
        if(this.sodium > ((MenuItem) o).sodium)
            return 1;
        return 0;
    }
}
