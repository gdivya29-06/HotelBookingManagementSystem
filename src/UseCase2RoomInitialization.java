/**
 * Use Case 2: Basic Room Types & Static Availability
 * This program demonstrates object-oriented domain modeling
 * using abstraction, inheritance, polymorphism, and encapsulation
 * for a Hotel Booking Management System.
 *
 * Version 2.0 - New class implementation
 *
 * @author Divya
 * @version 2.0
 */

/**
 * Abstract Room class representing common room properties.
 */
abstract class Room {
    private String roomType;
    private int numberOfBeds;
    private String roomSize;
    private double pricePerNight;

    /**
     * Constructor to initialize common room details.
     *
     * @param roomType Type of the room
     * @param numberOfBeds Number of beds in the room
     * @param roomSize Size/category of the room
     * @param pricePerNight Price per night for the room
     */
    public Room(String roomType, int numberOfBeds, String roomSize, double pricePerNight) {
        this.roomType = roomType;
        this.numberOfBeds = numberOfBeds;
        this.roomSize = roomSize;
        this.pricePerNight = pricePerNight;
    }

    /**
     * Displays room details.
     */
    public void displayRoomDetails() {
        System.out.println("Room Type      : " + roomType);
        System.out.println("Number of Beds : " + numberOfBeds);
        System.out.println("Room Size      : " + roomSize);
        System.out.println("Price/Night    : Rs. " + pricePerNight);
    }
}

/**
 * Concrete class representing a Single Room.
 */
class SingleRoom extends Room {
    public SingleRoom() {
        super("Single Room", 1, "Small", 2500.0);
    }
}

/**
 * Concrete class representing a Double Room.
 */
class DoubleRoom extends Room {
    public DoubleRoom() {
        super("Double Room", 2, "Medium", 4500.0);
    }
}

/**
 * Concrete class representing a Suite Room.
 */
class SuiteRoom extends Room {
    public SuiteRoom() {
        super("Suite Room", 3, "Large", 8000.0);
    }
}

/**
 * Main class for Use Case 2.
 */
public class UseCase2RoomInitialization {

    /**
     * Main method - entry point of the application.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {

        // Creating room objects using polymorphism
        Room singleRoom = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suiteRoom = new SuiteRoom();

        // Static availability variables
        int singleRoomAvailability = 5;
        int doubleRoomAvailability = 3;
        int suiteRoomAvailability = 2;

        // Display application header
        System.out.println("=================================================");
        System.out.println("        Book My Stay App - Version 2.0           ");
        System.out.println("   Use Case 2: Basic Room Types & Availability   ");
        System.out.println("=================================================");

        // Display Single Room details
        System.out.println("\n--- Single Room Details ---");
        singleRoom.displayRoomDetails();
        System.out.println("Available Rooms : " + singleRoomAvailability);

        // Display Double Room details
        System.out.println("\n--- Double Room Details ---");
        doubleRoom.displayRoomDetails();
        System.out.println("Available Rooms : " + doubleRoomAvailability);

        // Display Suite Room details
        System.out.println("\n--- Suite Room Details ---");
        suiteRoom.displayRoomDetails();
        System.out.println("Available Rooms : " + suiteRoomAvailability);

        System.out.println("\n=================================================");
        System.out.println(" Room details and static availability displayed. ");
        System.out.println("=================================================");
    }
}