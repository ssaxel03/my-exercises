package io.codeforall.fanSTATICs_;

public class Playground {

    public static void main(String[] args) {

        RecyclableDemon recyclableDemon = new RecyclableDemon();
        MagicLamp magicLamp = new MagicLamp(3);
        Genie genie1 = magicLamp.rub();
        Genie genie2 = magicLamp.rub();
        magicLamp.recycle(recyclableDemon);
        Genie genie3 = magicLamp.rub();
        Genie genie4 = magicLamp.rub();

        genie1.grantWish();
        genie2.grantWish();
        genie3.grantWish();

        for (int i = 0; i < 5; i++) {
            genie4.grantWish();
        }

        MagicLamp magicLamp1 = new MagicLamp(3);

        Genie genie5 = magicLamp1.rub();
        Genie genie6 = magicLamp1.rub();
        Genie genie7 = magicLamp1.rub();

        genie5.grantWish();
        genie6.grantWish();
        genie7.grantWish();
        magicLamp.recycle(genie4);
        magicLamp.recycle(genie4);
        magicLamp.recycle(genie4);

        MagicLamp magicLamp2 = new MagicLamp(3);

        MagicLamp.compare(magicLamp, magicLamp2);

        System.out.println(magicLamp.equals(magicLamp2));
    }


    }

