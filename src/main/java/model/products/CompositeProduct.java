package model.products;

import java.io.Serializable;

public class CompositeProduct extends MenuItem implements Serializable {
    public CompositeProduct(String title, int rating, double calories, double protein, double fat, double sodium, double price) {
        super(title, rating, calories, protein, fat, sodium, price);
    }
}
