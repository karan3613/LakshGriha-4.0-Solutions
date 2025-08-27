package Service;

import Dao.DAO;
import Model.Delivery;

public class DeliveryService {
    private final DAO DAO;

    public DeliveryService(DAO DAO) {
        this.DAO = DAO;
    }

    public void recordDelivery(Delivery delivery) {
        DAO.saveDelivery(delivery);
    }
}
