import Dao.DAO;
import Service.*;
import Tester.*;

public class ConsoleApp {
    public static void main(String[] args) {
        DAO dao = new DAO();
        CustomerTester customerTester = new CustomerTester(new CustomerService(dao));
        OrderTester orderTester = new OrderTester(new OrderService(dao));
        DistributionTester distributionTester = new DistributionTester(new DistributionService(dao));
        DeliveryTester deliveryTester = new DeliveryTester(new DeliveryService(dao));
        InvoiceTester invoiceTester = new InvoiceTester(new InvoiceService(dao));

        while (true) {
            System.out.println("=======================================");
            System.out.println("        Sterling Courier Company       ");
            System.out.println("=======================================");
            System.out.println("1. Customer Registration");
            System.out.println("2. Courier Order Booking");
            System.out.println("3. Courier Dispatch Responsibility Generation");
            System.out.println("4. Courier Delivery");
            System.out.println("5. Invoice Generation");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(ReadData.acceptString(""));
            switch (choice) {
                case 1 -> customerTester.readCustomerInfo();
                case 2 -> orderTester.readOrderInfo();
                case 3 -> distributionTester.readDistributionListInfo();
                case 4 -> deliveryTester.readDeliveryInfo();
                case 5 -> invoiceTester.readInvoiceInfo();
                case 6 -> {
                    System.out.println("Exiting... Thank you!");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}
