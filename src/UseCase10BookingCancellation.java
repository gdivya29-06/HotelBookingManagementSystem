import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Use Case 10: Booking Cancellation & Inventory Rollback
 * Demonstrates safe cancellation using Stack (LIFO rollback).
 */
public class UseCase10BookingCancellation {

    private HashMap<String, Integer> inventory;
    private Set<String> confirmedBookings;
    private Stack<String> rollbackStack;

    /**
     * Constructor
     */
    public UseCase10BookingCancellation() {
        inventory = new HashMap<>();
        confirmedBookings = new HashSet<>();
        rollbackStack = new Stack<>();

        inventory.put("Single Room", 1);

        // Assume one confirmed booking already exists
        confirmedBookings.add("RES101");
        inventory.put("Single Room", inventory.get("Single Room") - 1);
    }

    /**
     * Cancel booking and rollback inventory
     */
    public void cancelBooking(String reservationId, String roomType) {

        // Validate reservation existence
        if (!confirmedBookings.contains(reservationId)) {
            System.out.println("Cancellation Failed: Reservation not found.");
            return;
        }

        // Push to rollback stack
        rollbackStack.push(reservationId);

        // Remove booking from confirmed list
        confirmedBookings.remove(reservationId);

        // Restore inventory immediately
        inventory.put(roomType, inventory.get(roomType) + 1);

        System.out.println("Booking cancelled successfully.");
        System.out.println("Rolled back reservation: " + rollbackStack.peek());
        System.out.println("Updated inventory: " + inventory.get(roomType));
    }

    /**
     * Main method
     */
    public static void main(String[] args) {
        UseCase10BookingCancellation cancelService =
                new UseCase10BookingCancellation();

        // Valid cancellation
        cancelService.cancelBooking("RES101", "Single Room");

        // Duplicate cancellation
        cancelService.cancelBooking("RES101", "Single Room");
    }
}
