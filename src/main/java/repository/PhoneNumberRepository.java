package repository;

import model.PhoneNumber;

import java.util.List;

public interface PhoneNumberRepository {

    /**
     * Adds a phone number to the repository
     * @param phoneNumber the phone number to be added to the repository
     */
    void addPhoneNumber(PhoneNumber phoneNumber);

    /**
     * Returns a list of phone numbers associated with the specified customer
     * @param customerId identifier for the customer
     * @return a list containing the phone numbers associated with the customer ID
     */
    List<PhoneNumber> getCustomerPhoneNumbers(String customerId);

    /**
     * Returns a list of all phone numbers in the repository. Will return an empty list if
     * the repository is empty
     * @return a list containing all phone numbers in the repository
     */
    List<PhoneNumber> getAllPhoneNumbers();

    /**
     * Sets the status of a phone number to ACTIVE if the phone number exists.
     * @param number the phone number that will be activated
     * @return true if the phone number exists and is successfully set to ACTIVE and false otherwise.
     */
    boolean activatePhoneNumber(String number);
}
