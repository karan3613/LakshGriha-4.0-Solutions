package Service;

import Dao.DAO;
import Model.Invoice;

public class InvoiceService {
    private final DAO DAO;

    public InvoiceService(DAO DAO) {
        this.DAO = DAO;
    }

    public void generateInvoice(Invoice invoice) {
        DAO.saveInvoice(invoice);
    }
}
