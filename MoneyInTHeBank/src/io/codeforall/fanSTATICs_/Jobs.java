package io.codeforall.fanSTATICs_;

public enum Jobs {
    PROGRAMMER("programmer", 1500),
    DOCTOR("doctor", 2000),
    ENGINEER("engineer", 1800),
    HOE("hoe", 450),
    ELECTRICIAN("electrician", 1000),
    SELLER("seller", 4700),
    FIREFIGHTER("firefighter", 600);

    private final String description;
    private final int wage;

    Jobs(String description, int wage) {
        this.description = description;
        this.wage = wage;
    }

    public String getDescription() {
        return this.description;
    }

    public int getWage() {
        return wage;
    }

}
