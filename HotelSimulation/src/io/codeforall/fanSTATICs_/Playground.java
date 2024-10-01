package io.codeforall.fanSTATICs_;

public class Playground {

    public static void main(String[] args) {

        Hotel hotel1 = new Hotel("Hotel do caralho", 3);
        Hotel hotel2 = new Hotel("Hotel fodido", 40);
        Client client = new Client("Alberto");

        client.checkIn(hotel1);

        client.checkOut(hotel2);

        Room room = new Room();

        System.out.println(room);

    }
}
