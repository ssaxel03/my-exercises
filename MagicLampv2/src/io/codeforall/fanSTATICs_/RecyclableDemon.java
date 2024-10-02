package io.codeforall.fanSTATICs_;

public class RecyclableDemon extends Genie {

    private boolean hasBeenRecycle;

    RecyclableDemon(){
        super(0);
        this.hasBeenRecycle = false;
    }
    public boolean getHasBeenRecycled() {
        return hasBeenRecycle;
    }

    public void Recycle() {
        this.hasBeenRecycle = true;
    }

}
