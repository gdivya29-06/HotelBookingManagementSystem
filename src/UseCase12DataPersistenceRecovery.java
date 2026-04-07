import java.io.*;
import java.util.HashMap;

/**
 * Use Case 12: Data Persistence & System Recovery
 * Demonstrates saving and loading inventory data using file handling.
 */
public class UseCase12DataPersistenceRecovery {

    private HashMap<String, Integer> inventory;
    private final String FILE_NAME = "hotel_data.txt";

    /**
     * Constructor
     */
    public UseCase12DataPersistenceRecovery() {
        inventory = new HashMap<>();
    }

    /**
     * Initialize sample inventory
     */
    public void initializeData() {
        inventory.put("Single Room", 5);
        inventory.put("Double Room", 3);
    }

    /**
     * Save data to file
     */
    public void saveData() {
        try (ObjectOutputStream out =
                     new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {

            out.writeObject(inventory);
            System.out.println("Data saved successfully.");

        } catch (IOException e) {
            System.out.println("Error while saving data.");
        }
    }

    /**
     * Load data from file
     */
    public void loadData() {
        try (ObjectInputStream in =
                     new ObjectInputStream(new FileInputStream(FILE_NAME))) {

            inventory = (HashMap<String, Integer>) in.readObject();
            System.out.println("Data recovered successfully.");

        } catch (FileNotFoundException e) {
            System.out.println("No previous saved data found.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error while loading data.");
        }
    }

    /**
     * Display recovered data
     */
    public void displayInventory() {
        System.out.println("\nRecovered Inventory:");
        for (String room : inventory.keySet()) {
            System.out.println(room + " : " + inventory.get(room));
        }
    }

    /**
     * Main method
     */
    public static void main(String[] args) {

        UseCase12DataPersistenceRecovery system =
                new UseCase12DataPersistenceRecovery();

        // Save current state
        system.initializeData();
        system.saveData();

        // Simulate restart by creating new object
        UseCase12DataPersistenceRecovery recoveredSystem =
                new UseCase12DataPersistenceRecovery();

        recoveredSystem.loadData();
        recoveredSystem.displayInventory();
    }
}
