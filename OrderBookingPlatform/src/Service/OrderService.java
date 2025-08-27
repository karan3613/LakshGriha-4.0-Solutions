package Service;


import Dao.DAO;
import Model.Order;

public class OrderService {
    private final DAO DAO;

    public OrderService(DAO DAO) {
        this.DAO = DAO;
    }

    public void placeOrder(Order order) {
        DAO.saveOrder(order);
    }
}
