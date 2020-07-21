package model;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private final String customerId;
    private final List<PhoneNumber> phoneNumbers;

    public Customer(String customerId) {
        this.customerId = customerId;
        phoneNumbers = new ArrayList<>();
    }

    public String getCustomerId() {
        return customerId;
    }

    public List<PhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
    }
}
