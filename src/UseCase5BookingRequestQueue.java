import java.util.LinkedList;
import java.util.Queue;

/**
 * Use Case 5: Booking Request Queue
 * Demonstrates First-Come-First-Served booking requests using Queue.
 */
public class UseCase5BookingRequestQueue {

    // Queue to store booking requests
    private Queue<String> bookingQueue;

    /**
     * Constructor
     */
    public UseCase5BookingRequestQueue() {
        bookingQueue = new LinkedList<>();
    }

    /**
     * Method to add booking request
     */
    public void addBookingRequest(String guestName) {
        bookingQueue.add(guestName);
        System.out.println(guestName + " booking request added to queue.");
    }

    /**
     * Method to display all requests
     */
    public void displayQueue() {
        System.out.println("\nCurrent Booking Request Queue:");
        for (String guest : bookingQueue) {
            System.out.println(guest);
        }
    }

    /**
     * Main method
     */
    public static void main(String[] args) {
        UseCase5BookingRequestQueue queueSystem =
                new UseCase5BookingRequestQueue();

        // Booking requests arriving in order
        queueSystem.addBookingRequest("Divya");
        queueSystem.addBookingRequest("Manya");
        queueSystem.addBookingRequest("Vyom");

        // Display queue
        queueSystem.displayQueue();
    }
}