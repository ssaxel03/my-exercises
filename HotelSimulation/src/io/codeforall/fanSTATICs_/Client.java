package io.codeforall.fanSTATICs_;

import java.util.Objects;

public class Client {

    private String name;
    private String key;

    public Client(String name) {
        this.name = name;
        this.key = "-1-1";
    }

    public String getName() {
        return name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void checkIn(Hotel hotel) {
        if(!key.equals("-1-1")) {
            System.out.println("Client can't check in again");
            return;
        }

        // check in
        String result = hotel.checkIn();
        if (result.equals("-1-1")) {
            System.out.println("No rooms available");
            return;
        }
        this.key = result;
        System.out.println("Client checked in");
    }

    public void checkOut(Hotel hotel) {
        if (key.equals("-1-1")) {
            System.out.println("Client can't check out without a key");
            return;
        }

        // check out
        String result = hotel.checkOut(this.key);
        if (result.equals(this.key)) {
            System.out.println("This key is not from this hotel");
            return;
        }
        this.key = result;
        System.out.println("Client checked out");
    }
}
