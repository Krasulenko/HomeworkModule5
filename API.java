package module5;

public interface API {

    Room[] findRooms(int price, int persons, String cityName, String hotelName);

    Room[] getAll();
}
