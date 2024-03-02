package address.data;


public class AddressEntry {
    private final String firstName;
    private final String lastName;
    private final String street;
    private final String city;
    private final String state;
    private final int zip;
    private final String email;
    private final String phone;


    public String Entry() {
        return lastName;
    }


    /**
     * @param firstName The input of the first name.
     * @param lastName The input of the last name.
     * @param street The input of the street name.
     * @param city The input of the city name.
     * @param state The input of the city name.
     * @param zip The input of the zip code.
     * @param email The input of the email.
     * @param phone The input of the phone number.
     */
    public AddressEntry(String firstName, String lastName, String street, String city, String state, int zip, String email, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.email = email;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return String.format("%s %s\n%s\n%s, %s %d\n%s\n%s",
                firstName, lastName, street, city, state, zip, email, phone);
    }}