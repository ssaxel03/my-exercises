package io.codeforall.fanSTATICs_;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.ArrayList;

public class Bank {

    private int logIndex;
    private final String name;
    private float balance;
    private ArrayList log;

    public Bank(String name) {
        this.logIndex = 0;
        this.name = name;
        balance = 0;
        this.log = new ArrayList();
    }

    public String getName() {
        return this.name;
    }

    public float getBalance() {
        return this.balance;
    }

    public void getLog() {
        System.out.println("ID   MOVE  AMOUN");
        for(Object logLine : log) {
            System.out.println(logLine);
        }
        System.out.println("Balance: " + this.balance);
    }

    public void deposit(float depositAmount) {

        this.balance += depositAmount;
        System.out.println("Deposit was successful (" + depositAmount + ")");
        this.addMove("DEPO", depositAmount);
    }

    private boolean useBalance(float amount) {

        if (amount > this.balance) {
            System.out.println("Not enough funds in the bank");
            return false;
        }

        this.balance -= amount;
        return true;
    }

    public void withdraw(float withdrawalAmount) {

        if (this.useBalance(withdrawalAmount)) {
            System.out.println("Withdraw was successful (" + withdrawalAmount + ")");
            this.addMove("WITH", withdrawalAmount);
            return;
        }
        System.out.println("Withdrawal was not successful (" + withdrawalAmount + ")");

    }

    public void payment(float amount) {
        if (this.useBalance(amount)) {
            System.out.println("Payment was successful (" + amount + ")");
            this.addMove("PAYM", amount);
            return;
        }
        System.out.println("Payment was not successful (" + amount + ")");
    }

    private void addMove(String move, float amount) {
        String logMessage = String.format("%03d  %s  %f", logIndex, move, amount);
        logIndex++;
        log.add(logMessage);
    }

}
