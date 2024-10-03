package io.codeforall.fanSTATICs_;

public class MagicLamp {
    private final int maxGenies;
    private int geniesAvailable;
    private int timesRecycled;

    public MagicLamp(int maxGenies) {
        this.maxGenies = maxGenies;
        this.geniesAvailable = maxGenies;
        this.timesRecycled = 0;
    }

    public int getCapacity() {
        return this.maxGenies;
    }

    public int getRemainingGenies() {
        return geniesAvailable;
    }

    public int getTimesRecycled() {
        return timesRecycled;
    }

    public void recycle(RecyclableDemon recyclableDemon) {
        if (recyclableDemon.getHasBeenRecycled()) {
            System.out.println("This demon has already been recycled");
            return;
        }

        if (this.geniesAvailable != 0) {
            System.out.println("This lamp still has genies available");
            return;
        }

        System.out.println("The Recyclable Demon has been recycled");

        this.geniesAvailable = this.maxGenies;
        this.timesRecycled++;

        recyclableDemon.Recycle();
    }

    public Genie rub() {

        if(this.geniesAvailable == 0) {
            System.out.println("A Recyclable Demon has been released");
            return new RecyclableDemon();
        }

        int mod = (this.maxGenies - this.geniesAvailable + 1) % 2;

        this.geniesAvailable--;
        if (mod == 0) {
            System.out.println("A Friendly Genie has been released");
            return new FriendlyGenie();
        }

        System.out.println("A Grumpy Genie has been released");
        return new GrumpyGenie();

    }

    public boolean equals(MagicLamp magicLamp) {
        return (this.getCapacity() == magicLamp.getCapacity() &&
                this.getRemainingGenies() == magicLamp.getRemainingGenies() &&
                this.getTimesRecycled() == magicLamp.getTimesRecycled());
    }

    public static void compare(MagicLamp magicLamp1, MagicLamp magicLamp2) {
        // capacity, remaining geniuses, number of recharched

        System.out.println("DESC  LAMP1   LAMP2");
        System.out.printf("CAPA  %05d   %05d%n", magicLamp1.getCapacity(), magicLamp2.getCapacity());
        System.out.printf("REMA  %05d   %05d%n", magicLamp1.getRemainingGenies(), magicLamp2.getRemainingGenies());
        System.out.printf("RECY  %05d   %05d%n", magicLamp1.getTimesRecycled(), magicLamp2.getTimesRecycled());
    }

}
