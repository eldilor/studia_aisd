package Lab4;

import services.Helper;

public class OrderItem {
    private String name;
    private int quantity;
    private double price;

    public OrderItem() {
        this.name = "Product" + Helper.getRandomIntInRange(1, 1000);
        this.quantity = Helper.getRandomIntInRange(1, 10);
        this.price = Helper.getRandomDoubleInRange(1, 100);
    }

    public double getTotal() {
        return this.price * this.quantity;
    }
}
