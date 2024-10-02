package io.codeforall.fanSTATICs_;

public class Genie {
    private int maximumWishes;
    private int wishesGranted;

    public Genie(int maximumWishes) {
        this.maximumWishes = maximumWishes;
        this.wishesGranted = 0;
    }

    public void grantWish() {
       if (this.wishesGranted < this.maximumWishes || this.maximumWishes == 0) {
           System.out.println("Wish granted");
           this.wishesGranted++;
           return;
       }

        System.out.println("No more wishes left for this genie");
    }
}
