package Tester;


import Model.Invoice;
import Service.InvoiceService;

public class InvoiceTester {
    private final InvoiceService invoiceService;

    public InvoiceTester(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    public void readInvoiceInfo() {
        Invoice invoice = new Invoice();
        invoice.setCustomerId(Integer.parseInt(ReadData.acceptString("Customer Id: ")));
        invoice.setInvoiceMonth(Integer.parseInt(ReadData.acceptString("Invoice Month: ")));
        invoice.setInvoiceYear(Integer.parseInt(ReadData.acceptString("Invoice Year: ")));
        invoice.setDescription(ReadData.acceptString("Description: "));
        invoiceService.generateInvoice(invoice);
    }
}

