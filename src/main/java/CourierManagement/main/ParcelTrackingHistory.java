package CourierManagement.main;

public class ParcelTrackingHistory {
    public static void main(String[] args) {
        String[] trackingHistory = {
            "Warehouse - Mumbai",
            "Dispatched - Mumbai",
            "In Transit - Pune",
            "Out for Delivery - Pune",
            "Delivered - Pune"
        };

        System.out.println("Parcel Tracking History:");
        for (String location : trackingHistory) {
            System.out.println(location);
        }
    }
}