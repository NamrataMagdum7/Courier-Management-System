package CourierManagement.main;

public class CheckOrderStatus {
    public static void main(String[] args) {
        String status = "Delivered";

        if (status.equalsIgnoreCase("Delivered")) {
            System.out.println("Order has been delivered.");
        } else if (status.equalsIgnoreCase("Processing")) {
            System.out.println("Order is still processing.");
        } else if (status.equalsIgnoreCase("Cancelled")) {
            System.out.println("Order has been cancelled.");
        } else {
            System.out.println("Invalid status.");
        }
    }
}