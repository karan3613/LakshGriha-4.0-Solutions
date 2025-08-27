package Service;

import Dao.DAO;
import Model.Customer;

public class CustomerService {
    private final DAO DAO;
    public CustomerService(DAO DAO) {
        this.DAO = DAO;
    }
    public void registerCustomer(Customer customer) {
        DAO.saveCustomer(customer);
    }
}