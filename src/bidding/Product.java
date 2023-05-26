package bidding;

import enums.ProductCategories;

public class Product {
    protected String name;
    protected String description;
    protected ProductCategories productCategory;

    public Product(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public ProductCategories getCategory() {
        return productCategory;
    }
}
