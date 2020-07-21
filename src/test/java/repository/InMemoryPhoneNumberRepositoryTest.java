package repository;

import model.PhoneNumber;
import model.PhoneNumberStatus;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class InMemoryPhoneNumberRepositoryTest {
    private InMemoryPhoneNumberRepository phoneNumberRepository;

    @Before
    public void setup() {
        phoneNumberRepository = new InMemoryPhoneNumberRepository();
    }

    @Test
    public void shouldRetrieveAllPhoneNumbersOfCustomerGivenValidCustomerId() {
        String customerId = "customer-id";
        String phoneNumberOne = "1111111111";
        String phoneNumberTwo = "2222222222";
        String phoneNumberThree = "3333333333";

        phoneNumberRepository.addPhoneNumber(new PhoneNumber(phoneNumberOne, customerId));
        phoneNumberRepository.addPhoneNumber(new PhoneNumber(phoneNumberTwo, customerId));
        phoneNumberRepository.addPhoneNumber(new PhoneNumber(phoneNumberThree, customerId));


        List<PhoneNumber> customerPhoneNumbers = phoneNumberRepository.getCustomerPhoneNumbers(customerId);


        assertEquals(3, customerPhoneNumbers.size());
        assertPhoneNumber(customerId, phoneNumberOne, customerPhoneNumbers);
        assertPhoneNumber(customerId, phoneNumberTwo, customerPhoneNumbers);
        assertPhoneNumber(customerId, phoneNumberThree, customerPhoneNumbers);
    }

    @Test
    public void shouldReturnNullWhenRetrievingPhoneNumbersForCustomerThatDoesNotExist() {
        List<PhoneNumber> customerPhoneNumbers = phoneNumberRepository.getCustomerPhoneNumbers("customer-id");

        assertEquals(0, customerPhoneNumbers.size());
    }

    @Test
    public void shouldReturnAllPhoneNumbers() {
        String phoneNumberOne = "1111111111";
        String phoneNumberTwo = "2222222222";
        phoneNumberRepository.addPhoneNumber(new PhoneNumber(phoneNumberOne, "111"));
        phoneNumberRepository.addPhoneNumber(new PhoneNumber(phoneNumberTwo, "222"));

        List<PhoneNumber> allPhoneNumbers = phoneNumberRepository.getAllPhoneNumbers();

        assertEquals(2, allPhoneNumbers.size());
        assertEquals(phoneNumberOne, findNumber(allPhoneNumbers, phoneNumberOne).getNumber());
        assertEquals(phoneNumberTwo, findNumber(allPhoneNumbers, phoneNumberTwo).getNumber());
    }

    @Test
    public void shouldReturnEmptyListWhenFetchingAllPhoneNumbersIfRepositoryIsEmpty() {
        List<PhoneNumber> allPhoneNumbers = phoneNumberRepository.getAllPhoneNumbers();

        assertEquals(0, allPhoneNumbers.size());
    }

    @Test
    public void shouldActivatePhoneNumber() {
        String number = "1111111111";
        String customerId = "customer-id";
        phoneNumberRepository.addPhoneNumber(new PhoneNumber(number, customerId));

        boolean activated = phoneNumberRepository.activatePhoneNumber(number);

        assertTrue(activated);
        assertEquals(PhoneNumberStatus.ACTIVE, phoneNumberRepository.getAllPhoneNumbers().get(0).getStatus());
    }

    @Test
    public void shouldFailPhoneNumberActivationIfPhoneNumberDoesNotExist() {
        phoneNumberRepository.addPhoneNumber(new PhoneNumber("1111111111", "customer-id"));

        boolean activated = phoneNumberRepository.activatePhoneNumber("invalid-phone-number");

        assertFalse(activated);
        assertEquals(PhoneNumberStatus.INACTIVE, phoneNumberRepository.getAllPhoneNumbers().get(0).getStatus());
    }

    private void assertPhoneNumber(String customerId, String number, List<PhoneNumber> phoneNumberList) {
        PhoneNumber phoneNumber = findNumber(phoneNumberList, number);
        assertEquals(number, phoneNumber.getNumber());
        assertEquals(customerId, phoneNumber.getCustomerId());
    }

    private PhoneNumber findNumber(List<PhoneNumber> phoneNumberList, String number) {
        return phoneNumberList.stream()
                .filter(n -> n.getNumber().equals(number))
                .findFirst()
                .orElse(null);
    }
}