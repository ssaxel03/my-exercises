package io.codeforall.fanSTATICs_;

public class Genie {
    private final int maximumWishes;
    private int wishesGranted;

    public Genie() {
        this.maximumWishes = 3;
        this.wishesGranted = 0;
    }

    public void grantWish() {
       if (this.wishesGranted < this.maximumWishes) {
           System.out.println("Wish granted");
           this.wishesGranted++;
           return;
       }

        System.out.println("No more wishes left for this genie");
    }

    public int getWishesGranted() {
        return wishesGranted;
    }

    public void incWishesGranted() {
        this.wishesGranted++;
    }

    public boolean isDemon() {
        return false;
    }
}
