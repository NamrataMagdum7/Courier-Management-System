package CourierManagement.main;

import CourierManagement.dao.CourierServiceDb;
import CourierManagement.entity.Courier;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class MainModule {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CourierServiceDb serviceDb = new CourierServiceDb();

        while (true) {
            System.out.println("\n=== Courier Management System ===");
            System.out.println("1. Place New Order");
            System.out.println("2. Track Order Status");
            System.out.println("3. View Delivery History");
            System.out.println("4. Shipment Status Report");
            System.out.println("5. Revenue Report");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    Courier c = new Courier();
                    System.out.print("Enter Courier ID: ");
                    c.setCourierID(sc.nextLong());
                    sc.nextLine();
                    System.out.print("Sender Name: ");
                    c.setSenderName(sc.nextLine());
                    System.out.print("Sender Address: ");
                    c.setSenderAddress(sc.nextLine());
                    System.out.print("Receiver Name: ");
                    c.setReceiverName(sc.nextLine());
                    System.out.print("Receiver Address: ");
                    c.setReceiverAddress(sc.nextLine());
                    System.out.print("Weight: ");
                    c.setWeight(sc.nextDouble());
                    sc.nextLine();
                    System.out.print("Status: ");
                    c.setStatus(sc.nextLine());
                    System.out.print("Tracking Number: ");
                    c.setTrackingNumber(sc.nextLine());
                    c.setDeliveryDate(new Date());
                    System.out.print("User ID: ");
                    c.setUserId(sc.nextLong());

                    serviceDb.insertOrder(c);
                    break;

                case 2:
                    System.out.print("Enter Tracking Number: ");
                    String tn = sc.nextLine();
                    String status = serviceDb.getOrderStatus(tn);
                    System.out.println("Order Status: " + (status != null ? status : "Not Found"));
                    break;

                case 3:
                    System.out.print("Enter Tracking Number for history: ");
                    String histTrack = sc.nextLine();
                    List<Courier> history = serviceDb.getDeliveryHistory(histTrack);
                    if (history.isEmpty()) {
                        System.out.println("No history found.");
                    } else {
                        history.forEach(System.out::println);
                    }
                    break;

                case 4:
                    serviceDb.generateShipmentReport();
                    break;

                case 5:
                    serviceDb.generateRevenueReport();
                    break;

                case 6:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
