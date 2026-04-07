import java.util.HashMap;

/**
 * Custom exception for invalid booking
 */
class InvalidBookingException extends Exception {
    public InvalidBookingException(String message) {
        super(message);
    }
}

/**
 * Use Case 9: Error Handling & Validation
 * Demonstrates validation and custom exception handling.
 */
public class UseCase9ErrorHandlingValidation {

    private HashMap<String, Integer> inventory;

    /**
     * Constructor
     */
    public UseCase9ErrorHandlingValidation() {
        inventory = new HashMap<>();
        inventory.put("Single Room", 2);
        inventory.put("Double Room", 1);
    }

    /**
     * Validate and process booking
     */
    public void validateBooking(String roomType) {
        try {
            // Validate room type
            if (!inventory.containsKey(roomType)) {
                throw new InvalidBookingException("Invalid room type entered.");
            }

            // Prevent negative inventory
            if (inventory.get(roomType) <= 0) {
                throw new InvalidBookingException("No rooms available.");
            }

            // Update inventory safely
            inventory.put(roomType, inventory.get(roomType) - 1);

            System.out.println("Booking successful for " + roomType);
            System.out.println("Remaining rooms: " + inventory.get(roomType));

        } catch (InvalidBookingException e) {
            System.out.println("Booking Failed: " + e.getMessage());
        }
    }

    /**
     * Main method
     */
    public static void main(String[] args) {
        UseCase9ErrorHandlingValidation bookingSystem =
                new UseCase9ErrorHandlingValidation();

        // Valid booking
        bookingSystem.validateBooking("Single Room");

        // Invalid room type
        bookingSystem.validateBooking("Luxury Room");

        // Repeated booking to show validation
        bookingSystem.validateBooking("Double Room");
        bookingSystem.validateBooking("Double Room");
    }
}
