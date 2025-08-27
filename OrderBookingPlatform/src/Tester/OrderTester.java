package Tester;

import Model.Order;
import Service.OrderService;

public class OrderTester {
    private final OrderService orderService;

    public OrderTester(OrderService orderService) {
        this.orderService = orderService;
    }
    public void readOrderInfo() {
        Order order = new Order();
        order.setCustomerId(Integer.parseInt(ReadData.acceptString("Customer Id: ")));
        order.setOrderDate(ReadData.acceptString("Date Of Order (DD-MMM-YYYY): "));
        order.setRecipientName(ReadData.acceptString("Recipient Name: "));
        order.setRecipientAddress(ReadData.acceptString("Recipient Address: "));
        order.setRecipientCity(ReadData.acceptString("Recipient City (D, P, B, C): "));
        order.setCourierWeight(Double.parseDouble(ReadData.acceptString("Courier Weight: ")));
        order.setDescription(ReadData.acceptString("Description: "));
        orderService.placeOrder(order);
    }
}
