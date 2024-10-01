package io.codeforall.fanSTATICs_;

public class Hotel {

    private static int hotelCounter = 0;
    private int hotelId;
    private String name;
    private Room[] rooms;
    private int roomsAvailable;

    public Hotel(String name, int totalRooms) {

        this.hotelId = hotelCounter;
        hotelCounter++;

        this.name = name;
        this.rooms = new Room[totalRooms];
        this.roomsAvailable = totalRooms;

        for (int i = 0; i < totalRooms; i++) {
            this.rooms[i] = new Room();
        }
    }

    public static int getHotelCounter() {
        return hotelCounter;
    }

    public int getHotelId() {
        return hotelId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String checkIn() {
        if (this.roomsAvailable > 0) {
            int i = 0;
            for(; i < rooms.length; i++) {
                if (rooms[i].getIsAvailable()) {
                    break;
                }
            }
            rooms[i].changeAvailableState();
            this.roomsAvailable--;
            return String.format("%02d%02d", this.hotelId, i);
        }
        return "-1-1";
    }

    public String checkOut(String key) {
        if(key.substring(0, 2).equals(String.format("%02d", hotelId))) {
            int roomNumber = Integer.parseInt(key.substring(2));
            rooms[roomNumber].changeAvailableState();
            this.roomsAvailable++;
            return "-1-1";
        }
        return key;
    }
}
