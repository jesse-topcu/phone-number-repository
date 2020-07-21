package model;

public class PhoneNumber {

    private String number;
    private PhoneNumberStatus status;
    private String customerId;

    public PhoneNumber(String number, String customerId) {
        this.number = number;
        this.status = PhoneNumberStatus.INACTIVE;
        this.customerId = customerId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public PhoneNumberStatus getStatus() {
        return status;
    }

    public void setStatus(PhoneNumberStatus status) {
        this.status = status;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}
