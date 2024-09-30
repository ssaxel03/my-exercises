package io.codeforall.fanSTATICs_;

public class Person {

    private final String name;
    private float pocket;
    private Jobs job;
    private Bank bank;

    public Person(String name, Jobs job, Bank bank) {
        this.name = name;
        this.pocket = 0f;
        this.job = job;
        this.bank = bank;
    }

    public String getName() {
        return this.name;
    }

    public float getPocket() {
        return this.pocket;
    }

    private boolean usePocket(float amount) {

        if (amount > this.pocket) {
            System.out.println("Not enough funds in pocket");
            return false;
        }

        pocket -= amount;
        return true;
    }

    public String getJob() {
        return this.job.getDescription();
    }

    public void setJob(Jobs job) {
        this.job = job;
    }

    public void work() {
        this.pocket += this.job.getWage();
        System.out.println("Work done");
    }

    public void deposit(float amount) {
        if(amount > 0) {
            if (usePocket(amount)) {
                this.bank.deposit(amount);
                return;
            }

        }
        System.out.println("Amount not valid");
    }

    public void withdraw(float amount) {
        if(amount > 0) {
            this.bank.withdraw(amount);
            return;
        }
        System.out.println("Amount not valid");
    }

    public String getBankName() {
        return this.bank.getName();
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public float getBankBalance() {
        return this.bank.getBalance();
    }

    public void makeBankPayment(float amount) {
        if (amount > 0) {
            this.bank.payment(amount);
            return;
        }
        System.out.println("Amount not valid");
    }

    public void getBankLog() {
        this.bank.getLog();
    }
}
