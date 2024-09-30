package io.codeforall.fanSTATICs_;

public class Person {

    private final String name;
    private float pocket;
    private Jobs job;
    private Bank bank;

    public Person(String name, Jobs job, String bankName) {
        this.name = name;
        this.pocket = 0f;
        this.job = job;
        this.bank = new Bank(bankName);
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
        if (usePocket(amount)) {
            this.bank.deposit(amount);
        }
    }

    public void withdraw(float amount) {
        this.bank.withdraw(amount);
    }

    public String getBankName() {
        return this.bank.getName();
    }

    public float getBankBalance() {
        return this.bank.getBalance();
    }

    public void makeBankPayment(float amount) {
        this.bank.payment(amount);
    }

    public void getBankLog() {
        this.bank.getLog();
    }
}
