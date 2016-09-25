package module5;

import java.util.Date;

public class GoogleAPI implements API {

    private Room[] rooms = new Room[5];

    public GoogleAPI() {
        Room room1 = new Room(133, 110, 2, new Date(2016, 9, 26), "Hilton", "London");
        rooms[0] = room1;
        Room room2 = new Room(134, 130, 2, new Date(2016, 9, 23), "Holliday Inn", "Madrid");
        rooms[1] = room2;
        Room room3 = new Room(135, 180, 2, new Date(2016, 9, 28), "Redisson", "Oslo");
        rooms[2] = room3;
        Room room4 = new Room(136, 80, 1, new Date(2016, 9, 30), "Ritz", "Paris");
        rooms[3] = room4;
        Room room5 = new Room(137, 210, 3, new Date(2016, 10, 10), "Carlton", "Berlin");
        rooms[4] = room5;
    }

    @Override
    public Room[] findRooms(int price, int persons, String cityName, String hotelName) {
        int roomsCount = 0;
        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i].getPrice() <= price && rooms[i].getPersons() >= persons && rooms[i].getCityName() == cityName && rooms[i].getHotelName() == hotelName) {
                roomsCount++;
            }
        }

        Room[] roomsFitched = new Room[roomsCount];
        int j = 0;
        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i].getPrice() <= price && rooms[i].getPersons() >= persons && rooms[i].getCityName() == cityName && rooms[i].getHotelName() == hotelName) {
                roomsFitched[j] = rooms[i];
                j++;
            }
        }
        return roomsFitched;
    }

    @Override
    public Room[] getAll() {
        return rooms;
    }
}
