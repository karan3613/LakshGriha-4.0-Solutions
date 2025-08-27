package Dao;

import Model.Customer;
import Model.Delivery;
import Model.Invoice;
import Model.Order;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DAO {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/sterling_courier";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "karan3613"; // <- Replace with your MySQL password

    // Utility to get connection
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    // 1. Save Customer
    public void saveCustomer(Customer customer) {
        String sql = "INSERT INTO customers (name, address, city, email, phone , pin , dor) VALUES (?, ?, ?, ?, ?, ? , ?)";
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, customer.getName());
            ps.setString(2, customer.getAddress());
            ps.setString(3, customer.getCity());
            ps.setString(4, customer.getEmail());
            ps.setString(5, customer.getPhone());
            ps.setString(6 , customer.getPin());
            ps.setString(7 , customer.getDateOfRegistration());
            ps.executeUpdate();
            System.out.println("✅ Customer registered successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 2. Save Order
    public void saveOrder(Order order) {
        String sql = "INSERT INTO orders (customer_id, order_date, recipient_name, recipient_address, recipient_city, courier_weight, description) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, order.getCustomerId());
            ps.setString(2, order.getOrderDate());
            ps.setString(3, order.getRecipientName());
            ps.setString(4, order.getRecipientAddress());
            ps.setString(5, order.getRecipientCity());
            ps.setDouble(6, order.getCourierWeight());
            ps.setString(7, order.getDescription());
            ps.executeUpdate();
            System.out.println("✅ Order placed successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 3. Generate Dispatch Responsibility (Simulate for city wise assignment)
    public void saveDistribution(String date) {
        String sql = """
        INSERT INTO dispatch_responsibility (employee_id, order_id, dispatch_date)
        SELECT
            e.id AS employee_id,
            o.id,
            ?
        FROM orders o
        JOIN employee e ON
            (e.region = o.recipient_city)  -- Match employee region with order recipient city
        WHERE NOT EXISTS (
            SELECT 1 FROM dispatch_responsibility dr WHERE dr.order_id = o.id
        )
    """;
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, date);  // Set the dispatch date
            int rows = ps.executeUpdate();
            System.out.println("✅ Dispatch generated for " + rows + " orders.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 4. Save Delivery
    public void saveDelivery(Delivery delivery) {
        String sql = "INSERT INTO deliveries (employee_id, order_id, delivery_date, status, remarks) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, delivery.getEmployeeId());
            ps.setInt(2, delivery.getOrderId());
            ps.setString(3, delivery.getDeliveryDate());
            ps.setString(4, delivery.getStatus());
            ps.setString(5, delivery.getRemarks());
            ps.executeUpdate();
            System.out.println("✅ Delivery recorded successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 5. Save Invoice
    public void saveInvoice(Invoice invoice) {
        String sql = "INSERT INTO invoices (customer_id, month, year, description) VALUES (?, ?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, invoice.getCustomerId());
            ps.setInt(2, invoice.getInvoiceMonth());
            ps.setInt(3, invoice.getInvoiceYear());
            ps.setString(4, invoice.getDescription());
            ps.executeUpdate();
            System.out.println("✅ Invoice generated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

