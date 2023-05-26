package bidding;

import account.UserEntity;

public class Auction {
    Product product;
    private int startingPrice;
    private int currentPrice;
    private int buyNowPrice;
    private int timeLeft;
    private UserEntity topBidder;
    private UserEntity seller;

    public Auction(Product product, int startingPrice, int currentPrice, int buyNowPrice, int timeLeft, UserEntity topBidder, UserEntity seller) {
        this.product = product;
        this.startingPrice = startingPrice;
        this.currentPrice = currentPrice;
        this.buyNowPrice = buyNowPrice;
        this.timeLeft = timeLeft;
        this.topBidder = topBidder;
        this.seller = seller;
    }
}
