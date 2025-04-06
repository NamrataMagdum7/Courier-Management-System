package CourierManagement.dao;

import CourierManagement.entity.Courier;
import CourierManagement.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourierServiceDb {
    public static Connection connection;

    public CourierServiceDb() {
        connection = DBConnection.getConnection();
    }

    public void insertOrder(Courier courier) {
        String sql = "INSERT INTO Courier (courierID, senderName, senderAddress, receiverName, receiverAddress, weight, status, trackingNumber, deliveryDate, userId) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, courier.getCourierID());
            ps.setString(2, courier.getSenderName());
            ps.setString(3, courier.getSenderAddress());
            ps.setString(4, courier.getReceiverName());
            ps.setString(5, courier.getReceiverAddress());
            ps.setDouble(6, courier.getWeight());
            ps.setString(7, courier.getStatus());
            ps.setString(8, courier.getTrackingNumber());
            ps.setDate(9, new java.sql.Date(courier.getDeliveryDate().getTime()));
            ps.setLong(10, courier.getUserId());
            ps.executeUpdate();
            System.out.println("Courier order inserted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getOrderStatus(String trackingNumber) {
        String status = null;
        String sql = "SELECT status FROM Courier WHERE trackingNumber = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, trackingNumber);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                status = rs.getString("status");
            } else {
                System.out.println("Tracking number not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    public List<Courier> getDeliveryHistory(String trackingNumber) {
        List<Courier> history = new ArrayList<>();
        String sql = "SELECT * FROM Courier WHERE trackingNumber = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, trackingNumber);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Courier c = new Courier(
                    rs.getLong("courierID"),
                    rs.getString("senderName"),
                    rs.getString("senderAddress"),
                    rs.getString("receiverName"),
                    rs.getString("receiverAddress"),
                    rs.getDouble("weight"),
                    rs.getString("status"),
                    rs.getString("trackingNumber"),
                    rs.getDate("deliveryDate"),
                    rs.getLong("userId")
                );
                history.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return history;
    }

    public void generateShipmentReport() {
        String sql = "SELECT status, COUNT(*) as count FROM Courier GROUP BY status";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("Shipment Status Report:");
            while (rs.next()) {
                System.out.println(rs.getString("status") + " - " + rs.getInt("count"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void generateRevenueReport() {
        String sql = "SELECT SUM(weight * 10) as revenue FROM Courier"; // Assuming 10 currency units per kg
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                System.out.println("Total Revenue: " + rs.getDouble("revenue"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
