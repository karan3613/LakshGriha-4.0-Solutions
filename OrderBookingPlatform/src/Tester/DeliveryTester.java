package Tester;

import Model.Delivery;
import Service.DeliveryService;

public class DeliveryTester {
    private final DeliveryService deliveryService;

    public DeliveryTester(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    public void readDeliveryInfo() {
        Delivery delivery = new Delivery();
        delivery.setEmployeeId(Integer.parseInt(ReadData.acceptString("Employee Id: ")));
        delivery.setOrderId(Integer.parseInt(ReadData.acceptString("Order Id: ")));
        delivery.setDeliveryDate(ReadData.acceptString("Date Of Delivery (DD-MMM-YYYY): "));
        delivery.setStatus(ReadData.acceptString("Status (P, R, D): "));
        delivery.setRemarks(ReadData.acceptString("Remarks: "));
        deliveryService.recordDelivery(delivery);
    }
}