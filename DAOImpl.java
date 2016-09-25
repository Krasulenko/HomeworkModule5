package module5;

public class DAOImpl implements DAO {

    @Override
    public Room save(Room room) {
        if (room != null) {
            System.out.println(room.toString() + " saved");
        } else System.out.println("No matches");
        return room;
    }

    @Override
    public boolean delete(Room room) {
        System.out.println(room.toString() + " deleted");
        return true;
    }

    @Override
    public Room update(Room room) {
        System.out.println(room.toString() + " updated");
        return room;
    }

    @Override
    public Room findById(long id) {
        System.out.println(id + " find");
        return null;
    }
}
