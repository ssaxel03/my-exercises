package io.codeforall.fanSTATICs_;

public class Playground {
    public static void main(String[] args) {


        MagicLampad lampad1 = new MagicLampad();
        Genie genie = lampad1.rub();
        Genie genie1 = lampad1.rub();
        Genie genie2 = lampad1.rub();

        genie.grantWish();
        genie1.grantWish();
        genie2.grantWish();




    }
}
