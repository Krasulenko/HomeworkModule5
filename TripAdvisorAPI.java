package module5;

import java.util.Date;

public class TripAdvisorAPI implements API {

    private Room[] rooms = new Room[5];

    public TripAdvisorAPI() {
        Room room1 = new Room(123, 120, 2, new Date(2016, 9, 25), "Hilton", "Madrid");
        rooms[0] = room1;
        Room room2 = new Room(124, 150, 2, new Date(2016, 9, 22), "Holliday Inn", "London");
        rooms[1] = room2;
        Room room3 = new Room(125, 170, 2, new Date(2016, 9, 29), "Redisson", "Madrid");
        rooms[2] = room3;
        Room room4 = new Room(126, 90, 1, new Date(2016, 9, 30), "Ritz", "Oslo");
        rooms[3] = room4;
        Room room5 = new Room(127, 200, 3, new Date(2016, 10, 11), "Carlton", "Paris");
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
