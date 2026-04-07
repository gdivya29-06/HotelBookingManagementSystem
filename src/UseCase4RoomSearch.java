import java.util.HashMap;

/**
 * Use Case 4: Room Search & Availability Check
 * Demonstrates read-only room search using centralized inventory.
 */
public class UseCase4RoomSearch {

    // Centralized inventory
    private HashMap<String, Integer> roomInventory;

    /**
     * Constructor to initialize room availability
     */
    public UseCase4RoomSearch() {
        roomInventory = new HashMap<>();

        roomInventory.put("Single Room", 5);
        roomInventory.put("Double Room", 0);
        roomInventory.put("Suite Room", 2);
    }

    /**
     * Method to search and display only available rooms
     */
    public void searchAvailableRooms() {
        System.out.println("Available Rooms:");

        for (String roomType : roomInventory.keySet()) {
            int availability = roomInventory.get(roomType);

            // Only display rooms with count > 0
            if (availability > 0) {
                displayRoomDetails(roomType, availability);
            }
        }
    }

    /**
     * Method to display room details
     */
    public void displayRoomDetails(String roomType, int availability) {
        if (roomType.equals("Single Room")) {
            System.out.println(roomType + " | Price: Rs.2000 | Available: " + availability);
        } else if (roomType.equals("Double Room")) {
            System.out.println(roomType + " | Price: Rs.3500 | Available: " + availability);
        } else if (roomType.equals("Suite Room")) {
            System.out.println(roomType + " | Price: Rs.5000 | Available: " + availability);
        }
    }

    /**
     * Main method
     */
    public static void main(String[] args) {
        UseCase4RoomSearch search = new UseCase4RoomSearch();
        search.searchAvailableRooms();
    }
}
