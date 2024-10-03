package io.codeforall.fanSTATICs_;

public class RecyclableDemon extends Genie{
    private boolean hasBeenRecycled;

    public RecyclableDemon() {
        this.hasBeenRecycled = false;
    }

    public boolean getHasBeenRecycled() {
        return hasBeenRecycled;
    }

    public void Recycle() {
        this.hasBeenRecycled = true;
    }

    @Override
    public void grantWish() {
        System.out.println("Wish granted");
        this.incWishesGranted();
    }

    @Override
    public boolean isDemon() {
        return true;
    }
}
