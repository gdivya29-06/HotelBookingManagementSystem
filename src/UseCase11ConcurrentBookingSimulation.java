import java.util.LinkedList;
import java.util.Queue;

/**
 * Use Case 11: Concurrent Booking Simulation
 * Demonstrates thread-safe booking using synchronized method.
 */
public class UseCase11ConcurrentBookingSimulation {

    // Shared inventory
    private int availableRooms = 2;

    // Shared booking queue
    private Queue<String> bookingQueue = new LinkedList<>();

    /**
     * Synchronized booking method
     */
    public synchronized void processBooking(String guestName) {

        bookingQueue.add(guestName);

        if (availableRooms > 0) {
            System.out.println(guestName + " booking confirmed.");
            availableRooms--;
            System.out.println("Remaining rooms: " + availableRooms);
        } else {
            System.out.println(guestName + " booking failed. No rooms available.");
        }
    }

    /**
     * Main method
     */
    public static void main(String[] args) {

        UseCase11ConcurrentBookingSimulation bookingSystem =
                new UseCase11ConcurrentBookingSimulation();

        // Multiple guest threads
        Thread guest1 = new Thread(() ->
                bookingSystem.processBooking("Divya"));

        Thread guest2 = new Thread(() ->
                bookingSystem.processBooking("Manya"));

        Thread guest3 = new Thread(() ->
                bookingSystem.processBooking("Vyom"));

        // Start all threads
        guest1.start();
        guest2.start();
        guest3.start();
    }
}