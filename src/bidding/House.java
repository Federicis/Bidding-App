package bidding;

import enums.ProductCategories;

public class House extends Product{
    private int area;
    private int numberOfRooms;

    public House(String name, String description, int area, int numberOfRooms) {
        super(name, description);
        this.productCategory = ProductCategories.HOUSES;
        this.area = area;
        this.numberOfRooms = numberOfRooms;
    }

    public int getArea() {
        return area;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }
}
