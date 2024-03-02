package address;
import address.data.AddressEntry;

import java.util.Scanner;


public class Menu {
    public static void displayMenu() {
        System.out.println("Menu Options:");
        System.out.println("a) Loading of entries from a file.");
        System.out.println("b) Addition");
        System.out.println("c) Removal");
        System.out.println("d) Find");
        System.out.println("e) Listing");
        System.out.println("f) Quit");
    }

    /**
     * @return The address that is sent to AddressEntry and stored within the AddressBook.
     * @param <Int> Variables that are taken and stored into an object.
     */
    public static <Int> AddressEntry promptEntry() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first name:");
        String firstName = scanner.nextLine();

        System.out.println("Enter last name:");
        String lastName = scanner.nextLine();

        System.out.println("Enter street:");
        String street = scanner.nextLine();

        System.out.println("Enter city:");
        String city = scanner.nextLine();

        System.out.println("Enter state:");
        String state = scanner.nextLine();

        System.out.println("Enter zip:");
        int zip = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter email:");
        String email = scanner.nextLine();

        System.out.println("Enter phone:");
        String phone = scanner.nextLine();

        return new AddressEntry(firstName, lastName, street, city, state, zip, email, phone);
    }

    /**
     *
     * @param scanner variable to find the matching Address Entry to delete
     * @return The variable that is inputted into the program by the user to find the matching Address Entry.
     */
    public static String promptLastName(Scanner scanner) {
        System.out.println("Enter last name or its beginning:");
        return scanner.nextLine();
    }
}