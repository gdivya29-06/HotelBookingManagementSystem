import java.util.*;

/**
 * Use Case 6: Reservation Confirmation & Room Allocation
 * Demonstrates room allocation with unique room IDs.
 */
public class UseCase6RoomAllocationService {

    // Queue for booking requests
    private Queue<String> bookingQueue;

    // Inventory for room availability
    private HashMap<String, Integer> inventory;

    // Set to store unique allocated room IDs
    private Set<String> allocatedRoomIds;

    /**
     * Constructor
     */
    public UseCase6RoomAllocationService() {
        bookingQueue = new LinkedList<>();
        inventory = new HashMap<>();
        allocatedRoomIds = new HashSet<>();

        // Initial room count
        inventory.put("Single Room", 2);
    }

    /**
     * Add booking request
     */
    public void addBookingRequest(String guestName) {
        bookingQueue.add(guestName);
    }

    /**
     * Allocate room
     */
    public void confirmReservation(String roomType) {

        // Check if queue has requests
        if (bookingQueue.isEmpty()) {
            System.out.println("No booking requests available.");
            return;
        }

        // Check room availability
        if (inventory.get(roomType) > 0) {

            String guest = bookingQueue.poll();

            // Generate unique room ID
            String roomId = roomType.substring(0, 2).toUpperCase()
                    + (allocatedRoomIds.size() + 1);

            // Add to set to prevent duplicates
            allocatedRoomIds.add(roomId);

            // Update inventory immediately
            inventory.put(roomType, inventory.get(roomType) - 1);

            System.out.println("Reservation Confirmed");
            System.out.println("Guest: " + guest);
            System.out.println("Allocated Room ID: " + roomId);
            System.out.println("Remaining Rooms: " + inventory.get(roomType));

        } else {
            System.out.println("No rooms available for " + roomType);
        }
    }

    /**
     * Main method
     */
    public static void main(String[] args) {
        UseCase6RoomAllocationService service =
                new UseCase6RoomAllocationService();

        service.addBookingRequest("Divya");
        service.addBookingRequest("Manya");

        service.confirmReservation("Single Room");
        service.confirmReservation("Single Room");
        service.confirmReservation("Single Room");
    }
}