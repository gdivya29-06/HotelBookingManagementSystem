import java.util.HashMap;

/**
 * Use Case 3: Centralized Room Inventory Management
 * Demonstrates how HashMap is used to manage room availability.
 */
public class UseCase3InventorySetup {

    // HashMap to store room type and available count
    private HashMap<String, Integer> roomInventory;

    /**
     * Constructor to initialize room inventory
     */
    public UseCase3InventorySetup() {
        roomInventory = new HashMap<>();

        // Initial room availability
        roomInventory.put("Single Room", 10);
        roomInventory.put("Double Room", 5);
        roomInventory.put("Suite Room", 2);
    }

    /**
     * Method to display current inventory
     */
    public void displayInventory() {
        System.out.println("Current Room Inventory:");
        for (String roomType : roomInventory.keySet()) {
            System.out.println(roomType + " : " + roomInventory.get(roomType));
        }
    }

    /**
     * Method to get availability of a room type
     */
    public int getAvailability(String roomType) {
        return roomInventory.getOrDefault(roomType, 0);
    }

    /**
     * Method to update room availability
     */
    public void updateAvailability(String roomType, int count) {
        roomInventory.put(roomType, count);
    }

    /**
     * Main method
     */
    public static void main(String[] args) {
        UseCase3InventorySetup inventory = new UseCase3InventorySetup();

        // Display initial inventory
        inventory.displayInventory();

        // Update room count
        inventory.updateAvailability("Single Room", 8);

        System.out.println("\nAfter Booking Update:");
        inventory.displayInventory();

        // Check availability
        System.out.println("\nAvailable Double Rooms: "
                + inventory.getAvailability("Double Room"));
    }
}