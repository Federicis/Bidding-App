package bidding;

import enums.ProductCategories;

public class Car extends Product {
    private int horsePower;
    private int maxSpeed;

    public Car(String name, String description, int horsePower, int maxSpeed) {
        super(name, description);
        this.productCategory = ProductCategories.CARS;
        this.horsePower = horsePower;
        this.maxSpeed = maxSpeed;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }
}
