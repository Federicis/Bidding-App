package bidding;

import enums.ProductCategories;

public class Miscellaneous extends Product {
    public Miscellaneous(String name, String description) {
        super(name, description);
        super.productCategory = ProductCategories.MISCELLANEOUS;
    }
}
