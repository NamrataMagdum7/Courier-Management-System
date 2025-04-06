package CourierManagement.main;

public class DisplayOrdersForCustomer {
    public static void main(String[] args) {
        String customerName = "Alice";
        String[] orders = {"#ORD123", "#ORD124", "#ORD125"};

        System.out.println("Orders for " + customerName + ":");
        for (int i = 0; i < orders.length; i++) {
            System.out.println((i + 1) + ". Order ID: " + orders[i]);
        }
    }
}