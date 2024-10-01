package io.codeforall.fanSTATICs_;

public class Room {

    private boolean isAvailable;

    public Room() {
        this.isAvailable = true;
    }

    public boolean getIsAvailable() {
        return this.isAvailable;
    }

    public void changeAvailableState() {
        this.isAvailable = !this.isAvailable;
    }
}
