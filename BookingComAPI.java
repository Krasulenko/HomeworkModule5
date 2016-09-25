package module5;

import java.util.Date;

public class BookingComAPI implements API {

    private Room[] rooms = new Room[5];

    public BookingComAPI() {
        Room room1 = new Room(143, 120, 2, new Date(2016, 9, 26), "Hilton", "Madrid");
        rooms[0] = room1;
        Room room2 = new Room(144, 140, 2, new Date(2016, 9, 23), "Holliday Inn", "Oslo");
        rooms[1] = room2;
        Room room3 = new Room(145, 190, 2, new Date(2016, 9, 28), "Redisson", "Paris");
        rooms[2] = room3;
        Room room4 = new Room(146, 70, 1, new Date(2016, 9, 30), "Ritz", "Berlin");
        rooms[3] = room4;
        Room room5 = new Room(147, 220, 3, new Date(2016, 10, 10), "Carlton", "London");
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
