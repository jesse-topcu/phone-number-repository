# Phone Number Repository
A repository for phone numbers with functionality to store, retrieve and activate phone numbers.

## Usage
`InMemoryPhoneNumberRepository` Stores the phone numbers in memory using a hash map. 

### Add Phone Number
To store a phone number, use `addPhoneNumber()` which takes a phone number object as an argument and persists it in memory.

### Get All Phone Numbers for Customer
To retrieve all phone numbers for a particular customer, use `getCustomerPhoneNumbers()`. This method takes a customer ID as a string and returns all phone numbers found for that customer or an empty list if none are found.

### Get All Phone Numbers
To retrieve all phone numbers in the repository, use `getAllPhoneNumbers()`.

### Activate Phone Number
To activate a phone number, use `activatePhoneNumber()`. This method takes a phone number as a string as an argument and activates the number if the phone number exists in the repository. Returns true if the activation is successful and false otherwise.