package CourierManagement.util;

import java.util.HashMap;
import java.util.regex.*;
import java.time.LocalDate;

public class Task4Utils {

    // Task 9: Parcel Tracking using 2D array
    static String[][] parcelStatus = {
        {"TRK123", "Delivered"},
        {"TRK124", "In Transit"},
        {"TRK125", "Delivered"},
        {"TRK126", "Pending"},
        {"TRK127", "Delivered"},
        {"TRK128", "Delivered"},
        {"TRK129", "In Transit"},
        {"TRK130", "Pending"},
        {"TRK131", "Delivered"},
        {"TRK132", "In Transit"}
    };

    public static String trackParcel(String trackingNumber) {
        for (String[] parcel : parcelStatus) {
            if (parcel[0].equalsIgnoreCase(trackingNumber)) {
                switch (parcel[1]) {
                    case "In Transit":
                        return "Parcel in transit.";
                    case "Pending":
                        return "Parcel out for delivery.";
                    case "Delivered":
                        return "Parcel delivered.";
                    default:
                        return "Unknown status.";
                }
            }
        }
        return "Tracking number not found.";
    }

    // Task 10: Customer Data Validation
    public static boolean validate(String data, String detail) {
        switch (detail.toLowerCase()) {
            case "name":
                return data.matches("^[A-Z][a-z]+( [A-Z][a-z]+)*$");
            case "address":
                return data.matches("^[\\w\\s,.-]+$"); // basic address with alphanumerics, comma, dot, dash
            case "phone":
                return data.matches("^\\d{3}-\\d{3}-\\d{4}$"); // format: ###-###-####
            default:
                return false;
        }
    }

    // Task 11: Address Formatting
    public static String formatAddress(String street, String city, String state, String zip) {
        String formatted = capitalizeWords(street) + ", " +
                           capitalizeWords(city) + ", " +
                           capitalizeWords(state) + " - " +
                           zip;
        return formatted;
    }

    private static String capitalizeWords(String input) {
        String[] words = input.toLowerCase().split(" ");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            if (!word.isEmpty())
                sb.append(Character.toUpperCase(word.charAt(0))).append(word.substring(1)).append(" ");
        }
        return sb.toString().trim();
    }

    // Task 12: Order Confirmation Email
    public static String generateConfirmationEmail(String customerName, String orderNumber, String address, LocalDate deliveryDate) {
        return "Dear " + customerName + ",\n\n" +
               "Thank you for your order.\n" +
               "Order Number: " + orderNumber + "\n" +
               "Delivery Address: " + address + "\n" +
               "Expected Delivery Date: " + deliveryDate.toString() + "\n\n" +
               "Regards,\nCourier Management Team";
    }

    // Task 13: Shipping Cost Calculation
    public static double calculateShippingCost(String source, String destination, double weight) {
        // Sample logic: ₹10 per km + ₹5 per kg
        int distance = estimateDistance(source, destination); // sample function
        return (distance * 10) + (weight * 5);
    }

    private static int estimateDistance(String src, String dest) {
        // Dummy logic: just return different values for demo
        return Math.abs(src.hashCode() - dest.hashCode()) % 100 + 1;
    }

    // Task 14: Password Generator
    public static String generatePassword() {
        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lower = "abcdefghijklmnopqrstuvwxyz";
        String nums = "0123456789";
        String symbols = "@#$%&*!";
        String all = upper + lower + nums + symbols;

        StringBuilder sb = new StringBuilder();
        sb.append(upper.charAt((int)(Math.random() * upper.length())));
        sb.append(lower.charAt((int)(Math.random() * lower.length())));
        sb.append(nums.charAt((int)(Math.random() * nums.length())));
        sb.append(symbols.charAt((int)(Math.random() * symbols.length())));

        for (int i = 0; i < 4; i++)
            sb.append(all.charAt((int)(Math.random() * all.length())));

        return sb.toString();
    }

    // Task 15: Find Similar Addresses
    public static void findSimilarAddresses(String[] addresses) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String addr : addresses) {
            String key = addr.toLowerCase().replaceAll("[^a-z0-9]", "");
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        System.out.println("Similar Addresses:");
        for (String key : map.keySet()) {
            if (map.get(key) > 1) {
                System.out.println("-> Found duplicate pattern for: " + key);
            }
        }
    }
}
