package address.data;
import java.util.*;

public class AddressBook {


    public static List<AddressEntry> entries = null;

    public AddressBook() {
        entries = new ArrayList<>();
    }

    public void addEntry(AddressEntry entry) {
        entries.add(entry);
    }

    public void LastNameToRemove(AddressEntry entry) {
        entries.remove(entry);
    }


    /**
     * @param lastName Purpose is to scan for a matching last name within the AddressBook.
     * @return the variable it matches within the AddressBook.
     */
    public static Set<AddressEntry> findEntries(String lastName) {
        Set<AddressEntry> foundEntries = new HashSet<>();
        for (AddressEntry entry : entries) {
            if (entry.Entry().startsWith(lastName)) {
                foundEntries.add(entry);
            }
        }
        return foundEntries;
    }


    public void listEntries() {
        System.out.println();
        for (int i = 0; i < entries.size(); i++) {
            System.out.println((i + 1) + ":");
            System.out.println(entries.get(i));
            System.out.println();
        }
    }
    }






