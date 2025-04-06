package CourierManagement.service.impl;
import java.util.List;
import CourierManagement.entity.Courier;
import CourierManagement.exception.TrackingNumberNotFoundException;
import CourierManagement.service.ICourierUserService;

import java.util.*;

public class CourierUserServiceImpl implements ICourierUserService {

    private static Map<String, Courier> courierDB = new HashMap<>();

    // Sample data for testing
    static {
        Courier sampleCourier = new Courier();
        sampleCourier.trackingNumber = "ABC123XYZ";
        sampleCourier.status = "In Transit";
        courierDB.put(sampleCourier.trackingNumber, sampleCourier);
    }

    @Override
    public String getOrderStatus(String trackingNumber) throws TrackingNumberNotFoundException {
        Courier courier = courierDB.get(trackingNumber);
        if (courier == null) {
            throw new TrackingNumberNotFoundException("Tracking number not found: " + trackingNumber);
        }
        return courier.status;
    }

    @Override
    public boolean cancelOrder(String trackingNumber) throws TrackingNumberNotFoundException {
        Courier courier = courierDB.get(trackingNumber);
        if (courier == null) {
            throw new TrackingNumberNotFoundException("Cannot cancel. Tracking number not found: " + trackingNumber);
        }
        courier.status = "Cancelled";
        return true;
    }

    @Override
    public String placeOrder(Courier courierObj) {
        // Placeholder logic – you can enhance it later
        String trackingNumber = "TRK" + new Random().nextInt(10000);
        courierObj.trackingNumber = trackingNumber;
        courierObj.status = "YetToTransit";
        courierDB.put(trackingNumber, courierObj);
        return trackingNumber;
    }

    @Override
    public List<Courier> getAssignedOrder(long courierStaffId) {
        List<Courier> assignedOrders = new ArrayList<>();
        for (Courier courier : courierDB.values()) {
            if (courier.userId == courierStaffId) {
                assignedOrders.add(courier);
            }
        }
        return assignedOrders;
    }

    @Override
    public List<Courier> getAllOrders() {
        return new ArrayList<>(courierDB.values());  // assuming courierDB is your in-memory map
    }
}