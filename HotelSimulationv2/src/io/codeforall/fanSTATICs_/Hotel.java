package io.codeforall.fanSTATICs_;

public class Hotel {

    private String name;
    private Room[] rooms;
    private int roomsAvailable;

    public Hotel(String name, int totalRooms) {

        this.name = name;
        this.rooms = new Room[totalRooms];
        this.roomsAvailable = totalRooms;

        for (int i = 0; i < totalRooms; i++) {
            this.rooms[i] = new Room();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Room checkIn() {
        if(roomsAvailable < 1){
            System.out.println("No rooms available");
            return null;
        }

        for (Room room: rooms) {
            if(room.getIsAvailable()){
                room.changeAvailableState();
                return room;
            }
        }

        return null;

    }

    public Room checkOut(Room key) {
        for (Room room : rooms) {
            if(room == key){
                return null;
            }
        }
        System.out.println("Key doesn't belong to this hotel");
        return key;
    }
}