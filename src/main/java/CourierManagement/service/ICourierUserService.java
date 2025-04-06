package CourierManagement.service;

import CourierManagement.entity.Courier;
import CourierManagement.exception.TrackingNumberNotFoundException;

import java.util.List;

public interface ICourierUserService {
    String placeOrder(Courier courierObj);

    String getOrderStatus(String trackingNumber) throws TrackingNumberNotFoundException;

    boolean cancelOrder(String trackingNumber) throws TrackingNumberNotFoundException;

    List<Courier> getAssignedOrder(long courierStaffId);
    List<Courier> getAllOrders();
}