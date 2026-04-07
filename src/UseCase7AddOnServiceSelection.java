import java.util.*;

/**
 * Use Case 7: Add-On Service Selection
 * Demonstrates attaching optional services to a reservation.
 */
public class UseCase7AddOnServiceSelection {

    // Map reservation ID -> list of selected services
    private HashMap<String, List<String>> reservationServices;

    // Map service name -> service cost
    private HashMap<String, Integer> serviceCosts;

    /**
     * Constructor
     */
    public UseCase7AddOnServiceSelection() {
        reservationServices = new HashMap<>();
        serviceCosts = new HashMap<>();

        // Predefined service costs
        serviceCosts.put("Breakfast", 500);
        serviceCosts.put("Laundry", 300);
        serviceCosts.put("Airport Pickup", 800);
    }

    /**
     * Add service to reservation
     */
    public void addService(String reservationId, String serviceName) {

        // Create list if reservation doesn't exist
        reservationServices.putIfAbsent(reservationId, new ArrayList<>());

        // Add service
        reservationServices.get(reservationId).add(serviceName);

        System.out.println(serviceName + " added to reservation " + reservationId);
    }

    /**
     * Calculate total add-on cost
     */
    public int calculateAdditionalCost(String reservationId) {
        int total = 0;

        List<String> services = reservationServices.get(reservationId);

        if (services != null) {
            for (String service : services) {
                total += serviceCosts.get(service);
            }
        }

        return total;
    }

    /**
     * Display selected services
     */
    public void displayServices(String reservationId) {
        System.out.println("\nServices for Reservation " + reservationId + ":");
        System.out.println(reservationServices.get(reservationId));

        System.out.println("Additional Cost: Rs."
                + calculateAdditionalCost(reservationId));
    }

    /**
     * Main method
     */
    public static void main(String[] args) {
        UseCase7AddOnServiceSelection serviceManager =
                new UseCase7AddOnServiceSelection();

        String reservationId = "RES101";

        serviceManager.addService(reservationId, "Breakfast");
        serviceManager.addService(reservationId, "Laundry");

        serviceManager.displayServices(reservationId);
    }
}
