package io.codeforall.fanstatics;

import io.codeforall.fanstatics.observer.Subscriber;

public class Client implements Subscriber {

    private String name;

    public Client(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.printf("%s: I just got the following message: \"%s\"\n", this.name, message);
    }
}
