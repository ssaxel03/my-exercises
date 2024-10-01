package io.codeforall.fanSTATICs_;

public class Playground {

    public static void main(String[] args) {

        Hotel hotel = new Hotel("Hotel jevarcio",10);
        Hotel hotel1 = new Hotel("Hotel das quintas",8);
        Client client1 = new Client("Jacubino");
        client1.checkIn(hotel);
        client1.checkIn(hotel1);

    }

}

// person will have a reference to an hotel
// when person wants to checkout, a reference to an hotel is passed as argument
// if I compare the hotel reference the person has with the hotel reference the checkOut methods gets as argument... maybe there's something here