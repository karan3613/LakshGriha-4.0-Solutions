package Tester;

import Model.Customer;
import Service.CustomerService;

public class CustomerTester {

    private final CustomerService customerService;

    public CustomerTester(CustomerService customerService) {
        this.customerService = customerService;
    }

    public void readCustomerInfo() {
        Customer customer = new Customer();
        customer.setName(ReadData.acceptString("Customer Name: "));
        customer.setDateOfRegistration(ReadData.acceptString("Date Of Registration (DD-MMM-YYYY): "));
        customer.setAddress(ReadData.acceptString("Address: "));
        customer.setCity(ReadData.acceptString("City: "));
        customer.setPin(ReadData.acceptString("Pin: "));
        customer.setPhone(ReadData.acceptString("Telephone Number: "));
        customer.setEmail(ReadData.acceptString("E-mail Id: "));
        customerService.registerCustomer(customer);
    }
}
