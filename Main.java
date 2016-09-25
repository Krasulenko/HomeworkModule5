package module5;

public class Main {

    public static void main(String[] args) {

        Controller controller = new Controller();

        System.out.println("Rooms on requestion:");
        controller.requestRooms(200, 2, "Oslo", "Redisson");
        controller.requestRooms(140, 1, "London", "Hilton");
        controller.requestRooms(150, 2, "London", "Holliday Inn");
        controller.requestRooms(150, 2, "Madrid", "Hilton");


        controller.check(new BookingComAPI(), new GoogleAPI());
        System.out.println("Found " + controller.check(new BookingComAPI(), new GoogleAPI()).length + " same rooms");
        controller.check(new BookingComAPI(), new TripAdvisorAPI());
        System.out.println("Found " + controller.check(new BookingComAPI(), new TripAdvisorAPI()).length + " same rooms");
        controller.check(new TripAdvisorAPI(), new GoogleAPI());
        System.out.println("Found " + controller.check(new TripAdvisorAPI(), new GoogleAPI()).length + " same rooms");

    }


}
