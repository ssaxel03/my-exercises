package io.codeforall.fanSTATICs_;

public class Playground {

    public static void main(String[] args) {

        MagicLamp magicLamp = new MagicLamp(3);
        Genie genie1 = magicLamp.rub();
        Genie genie2 = magicLamp.rub();
        Genie genie3 = magicLamp.rub();
        Genie genie4 = magicLamp.rub();

        genie1.grantWish();
        genie2.grantWish();
        genie3.grantWish();
        genie4.grantWish();

        magicLamp.recycle((RecyclableDemon) genie4);
    }
}
