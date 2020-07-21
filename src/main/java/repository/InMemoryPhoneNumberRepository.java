package repository;

import model.PhoneNumber;
import model.PhoneNumberStatus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InMemoryPhoneNumberRepository implements PhoneNumberRepository {
    private Map<String, PhoneNumber> phoneNumberMap;

    public InMemoryPhoneNumberRepository() {
        phoneNumberMap = new HashMap<>();
    }

    @Override
    public void addPhoneNumber(PhoneNumber phoneNumber) {
        phoneNumberMap.put(phoneNumber.getNumber(), phoneNumber);
    }

    @Override
    public List<PhoneNumber> getCustomerPhoneNumbers(String customerId) {
        return phoneNumberMap.values().stream()
                .filter(phoneNumber -> phoneNumber.getCustomerId().equals(customerId))
                .collect(Collectors.toList());
    }

    @Override
    public List<PhoneNumber> getAllPhoneNumbers() {
        return new ArrayList<>(phoneNumberMap.values());
    }

    @Override
    public boolean activatePhoneNumber(String number) {
        PhoneNumber phoneNumber = phoneNumberMap.get(number);

        if (phoneNumber == null) {
            return false;
        }

        phoneNumber.setStatus(PhoneNumberStatus.ACTIVE);

        return true;
    }
}
