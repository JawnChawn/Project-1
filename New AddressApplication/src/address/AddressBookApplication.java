package address;
import address.data.AddressBook;
import address.data.AddressEntry;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;

/** A class that has all the possible functions the Address Book Application has.
 * each case (labeled a,b,c,d,e,f) have a unique function.
 * Case a: Allows user to input a txt file to read and store into the address book as an object array.
 * Case b: Allows user to add their own address (first name,last name,street,city,state,zip code,email,phone number).
 *         It is then stored into the address book as an object array as well.
 * Case c: Allows the user to remove an address entry that is not needed. It prompts the user to look for an existing entry by looking for the last name of the recipient.
 *         It then displays the correlating entry and asks to type "y" to delete or "n" to go back to menu.
 * Case d: Allows the user to find existing entries within the AddressBook. It then displays the entries that match the user's input.
 * Case e: It prints out all existing entries within the program.
 * Case f: force quits the program.
 */
public class AddressBookApplication {
    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        Scanner scanner = new Scanner(System.in);
        char choice;


        //inputs two pre-existing address entries for easier reference.

        AddressEntry entry1 = new AddressEntry("Corey", "Winston", "247 grove St", "Walen", "AR", 62701, "Corey@gmail.com", "124- 245 1242");
        AddressEntry entry2 = new AddressEntry("Will", "Smith", "222 Yom Ave", "Hayward", "CA", 94601, "Will@gmail.com", "444-444-4444");

        addressBook.addEntry(entry1);
        addressBook.addEntry(entry2);

        do {
            Menu.displayMenu();
            System.out.println("Enter your choice:");
            choice = scanner.next().charAt(0);
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 'a':
                    System.out.println("Enter the file to import:");
                    String filePath = scanner.nextLine();
                    try {
                        File file = new File(filePath);
                        Scanner fileScanner = new Scanner(file);
                        while (fileScanner.hasNextLine()) {
                            String line = fileScanner.nextLine();
                            String[] parts = line.split(",");
                            if (parts.length == 8) {
                                String firstName = parts[0].trim();
                                String lastName = parts[1].trim();
                                String street = parts[2].trim();
                                String city = parts[3].trim();
                                String state = parts[4].trim();
                                int zip = Integer.parseInt(parts[5].trim());
                                String email = parts[6].trim();
                                String phone = parts[7].trim();
                                AddressEntry NewEntry = new AddressEntry(firstName, lastName, street, city, state, zip, email, phone);
                                addressBook.addEntry(NewEntry);
                            } else {
                                System.out.println("Invalid entry format: " + line);
                            }
                        }
                        fileScanner.close();
                        System.out.println("Address Entries imported successfully.");
                    } catch (FileNotFoundException e) {
                        System.out.println("File not found: " + filePath);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid ZIP code format in the file.");
                    }
                    // Load entries from file
                    break;
                case 'b':
                    AddressEntry newEntry = Menu.promptEntry();
                    addressBook.addEntry(newEntry);
                    break;
                case 'c':
                    //Asks for a last name to find to remove entry.
                    String lastNameToRemove = Menu.promptLastName(scanner);
                    Set<AddressEntry> foundEntries = AddressBook.findEntries(lastNameToRemove);

                    if (foundEntries.isEmpty()) {
                        System.out.println("No matching entries found.");
                    } else {
                        // Display found entries
                        System.out.println("The following entry/entries were found in the address book:");
                        int count = 1;
                        for (AddressEntry entry : foundEntries) {
                            System.out.println(count + ":");
                            System.out.println(entry);
                            System.out.println();
                            count++;
                        }

                        // Prompt user to remove the entry
                        System.out.println("Hit 'y' to remove the entry or 'n' to return to the main menu:");
                        char removeChoice = scanner.next().charAt(0);
                        scanner.nextLine(); // Consume newline
                        if (removeChoice == 'y') {
                            // Remove the entry from the address book
                            for (AddressEntry entry : foundEntries) {
                                AddressBook.entries.remove(entry);
                            }
                            System.out.println("Entry removed successfully.");
                        } else if (removeChoice == 'n') {
                            System.out.println("Returning to the main menu.");
                        } else {
                            System.out.println("Invalid choice.");
                        }
                    }
                    break;
                case 'd':
                    //Displays the found entries after inputting a last name.
                    String lastNameToFind = Menu.promptLastName(scanner);
                    Set<AddressEntry> foundEntriesToFind = AddressBook.findEntries(lastNameToFind);
                    if (foundEntriesToFind.isEmpty()) {
                        System.out.println("No matching entries found.");
                    } else {
                        System.out.println("The following entry/entries match the last name '" + lastNameToFind + "':");
                        int count = 1;
                        for (AddressEntry entry : foundEntriesToFind) {
                            System.out.println(count + ":");
                            System.out.println(entry);
                            System.out.println();
                            count++;
                        }
                    }

                    break;
                case 'e':
                    addressBook.listEntries();
                    break;
                case 'f':
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 'f');
    }
}