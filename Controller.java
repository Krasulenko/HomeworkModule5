package module5;

public class Controller {
    private API apis[] = new API[3];

    public Controller() {
        BookingComAPI bookingComAPI = new BookingComAPI();
        apis[0] = bookingComAPI;
        GoogleAPI googleAPI = new GoogleAPI();
        apis[1] = googleAPI;
        TripAdvisorAPI tripAdvisorAPI = new TripAdvisorAPI();
        apis[2] = tripAdvisorAPI;
    }

    public Controller(API[] apis) {
        this.apis = apis;
    }

    Room[] requestRooms(int price, int persons, String city, String hotel) {
        int roomscount = 0;
        for (int i = 0; i < apis.length; i++) {
            roomscount += apis[i].findRooms(price, persons, city, hotel).length;
        }
        Room[] requestedRoms = new Room[roomscount];
        DAOImpl dao = new DAOImpl();

        int requstcount = 0;
        for (API api : apis) {
            for (Room room : api.findRooms(price, persons, city, hotel)) {
                requestedRoms[requstcount] = room;
                dao.save(room);
                requstcount++;
            }
        }
        return requestedRoms;
    }

    Room[] check(API api1, API api2) {

        Room[] roomsFromApi1 = api1.getAll();
        Room[] roomsFromApi2 = api2.getAll();

        int sameRoomCount = 0;
        for (Room room1 : roomsFromApi1) {
            for (Room room2 : roomsFromApi2) {
                if (room1.equals(room2)) {
                    sameRoomCount++;
                }
            }
        }

        Room[] sameroom = new Room[sameRoomCount];

        int i = 0;
        for (Room room1 : roomsFromApi1) {
            for (Room room2 : roomsFromApi2) {
                if (room1.equals(room2)) {
                    sameroom[i] = room1;
                    i++;
                }
            }
        }
        return sameroom;
    }
}
