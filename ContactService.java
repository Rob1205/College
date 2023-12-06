import java.util.ArrayList;

public class ContactService {

    static ArrayList<Contact> contactList = new ArrayList<Contact>(0);

    public static void addContact(String fName, String lName, String phone, String address) {
        String ID = generateUniqueId();
        Contact Contact1 = new Contact(ID, fName, lName, phone, address);
        contactList.add(Contact1);
    }

    // Improved addContact method to accept Contact object
    public static void addContact(Contact newContact) {
        String tempId = newContact.getId();

        // Check if the ID already exists in the list
        for (int i = 0; i < contactList.size(); i++) {
            if (tempId.equals(contactList.get(i).getId())) {
                throw new IllegalArgumentException("Contact ID Must Be Unique");
            }
        }

        // If the ID is unique, add the contact to the list
        contactList.add(newContact);
    }

    // ... other methods ...

    public static String generateUniqueId() {
        // placeholder string
        String uniqueId;
        // start with a 10-digit number if list is empty
        if (contactList.isEmpty()) {
            publicId = "1000000001";
        }
        // gets the latest value, therefore highest, in the arraylist if it is not empty
        else {
            int arraySize = contactList.size();
            publicId = contactList.get(arraySize - 1).getId();
        }
        // convert string to int for creation of the next value
        int tempInt = Integer.valueOf(publicId);
        // add 1 to make the next value unique
        tempInt += 1;
        // convert back to string to store
        uniqueId = Integer.toString(tempInt);
        return uniqueId;
    }
}
