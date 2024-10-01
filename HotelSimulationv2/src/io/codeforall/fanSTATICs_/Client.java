package io.codeforall.fanSTATICs_;

import java.util.Objects;

public class Client {

    private String name;
    private Room key;

    public Client(String name) {
        this.name = name;
        this.key = null;
    }

    public String getName() {
        return name;
    }

    public Room getKey() {
        return key;
    }

    public void setKey(Room key) {
        this.key = key;
    }

    public void checkIn(Hotel hotel) {
        if(key != null){
            System.out.println("You cannot check in again");
            return;
        }

        // check in
        Room result = hotel.checkIn();
        this.key = result;

        if(result != null){
            System.out.println("Check in done");
        }


    }

    public void checkOut(Hotel hotel) {
        if(key == null){
            System.out.println("You cannot check out without a key");
            return;
        }

        Room result = hotel.checkOut(this.key);
           this.key = result;
        if (result == null){
            System.out.println("Check out done");
        }


    }

}
