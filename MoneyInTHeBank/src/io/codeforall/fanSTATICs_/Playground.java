package io.codeforall.fanSTATICs_;

import java.util.ArrayList;

public class Playground {

    public static void main(String[] args) {

     Person person = new Person("Axel", Jobs.PROGRAMMER, "Crédito Bacano");

     System.out.println("Pocket: " + person.getPocket());
     person.work();
     System.out.println("Pocket: " + person.getPocket());
     person.deposit(200f);
     person.withdraw(100f);
     System.out.println("Balance: " + person.getBankBalance());
     person.makeBankPayment(90f);
     person.getBankLog();
     System.out.println("Pocket: " + person.getPocket());
    }

}
