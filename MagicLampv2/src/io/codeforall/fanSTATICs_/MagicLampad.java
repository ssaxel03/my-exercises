package io.codeforall.fanSTATICs_;

public class MagicLampad {

    /*  PROPRIEDADES

     */
    private int maxgenies;
    private int geniesAvailable;

    private int timesRecycled;

    MagicLampad() {
        this.maxgenies = 4;
        this.geniesAvailable = this.maxgenies;
    }

    /*  FUNCIONALIDADES
        CRIA GENIOS
        DA PA ESFREGAR
        DA PA RECICLAR
     */

    public Genie rub() {
        if (geniesAvailable == 0) {
            return new RecyclableDemon();

        }
        if (maxgenies - geniesAvailable + 1 % 2 == 0) {
            return new FriendlyGenie();
        }
        return new GrumpyGenie();
    }

    public void Recycle(RecyclableDemon demon) {
        if (demon.getHasBeenRecycled()) {
            geniesAvailable = maxgenies;
            System.out.println("This demon has been recycle before");
            return;
        }

        if (this.geniesAvailable != 0) {
            System.out.println("This lamp still has genies available");
            return;
        }

        System.out.println("The Recyclable Demon has been recycled");

        this.geniesAvailable = this.maxgenies;
        this.timesRecycled++;

        demon.Recycle();
    }
}
