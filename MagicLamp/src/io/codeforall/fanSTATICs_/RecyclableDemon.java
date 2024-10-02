package io.codeforall.fanSTATICs_;

public class RecyclableDemon extends Genie{
    private boolean hasBeenRecycled;

    public RecyclableDemon() {
        super(0);
        this.hasBeenRecycled = false;
    }

    public boolean getHasBeenRecycled() {
        return hasBeenRecycled;
    }

    public void Recycle() {
        this.hasBeenRecycled = true;
    }
}
