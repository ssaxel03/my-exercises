package io.codeforall.fanSTATICs_;

public class GrumpyGenie extends Genie{

    @Override
    public void grantWish() {
        if (this.getWishesGranted() > 0) {
            System.out.println("No more wishes left for this genie");
            return;
        }

        System.out.println("Wish granted");
        this.incWishesGranted();
    }

}
