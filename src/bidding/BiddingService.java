package bidding;

import app.DBUtils;

import java.sql.SQLException;

public class BiddingService {
    public static BiddingService instance;

    public static BiddingService getInstance() {
        if (instance == null) {
            instance = new BiddingService();
        }
        return instance;
    }
    public void showAllProducts() throws SQLException {
        DBUtils.populateProducts();

    }
}
