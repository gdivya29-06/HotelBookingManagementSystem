import java.util.ArrayList;
import java.util.List;

/**
 * Use Case 8: Booking History & Reporting
 * Demonstrates storing confirmed bookings in chronological order.
 */
public class UseCase8BookingHistoryReport {

    // List to store booking history
    private List<String> bookingHistory;

    /**
     * Constructor
     */
    public UseCase8BookingHistoryReport() {
        bookingHistory = new ArrayList<>();
    }

    /**
     * Add confirmed booking to history
     */
    public void addConfirmedBooking(String reservationId) {
        bookingHistory.add(reservationId);
        System.out.println("Booking confirmed and added: " + reservationId);
    }

    /**
     * Display full booking history
     */
    public void displayBookingHistory() {
        System.out.println("\nBooking History:");
        for (String booking : bookingHistory) {
            System.out.println(booking);
        }
    }

    /**
     * Generate simple booking report
     */
    public void generateReport() {
        System.out.println("\nBooking Report:");
        System.out.println("Total Confirmed Bookings: " + bookingHistory.size());
    }

    /**
     * Main method
     */
    public static void main(String[] args) {
        UseCase8BookingHistoryReport reportService =
                new UseCase8BookingHistoryReport();

        // Add confirmed bookings
        reportService.addConfirmedBooking("RES101");
        reportService.addConfirmedBooking("RES102");
        reportService.addConfirmedBooking("RES103");

        // Display history
        reportService.displayBookingHistory();

        // Generate summary report
        reportService.generateReport();
    }
}
