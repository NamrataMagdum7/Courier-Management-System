package CourierManagement.entity;

import java.util.Date;

public class Courier {
   public long courierID;
    public String senderName;
    public String senderAddress;
    public String receiverName;
    public String receiverAddress;
    public double weight;
    public String status;
    public String trackingNumber;
    public Date deliveryDate;
    public long userId;

    public Courier() {}

    public Courier(long courierID, String senderName, String senderAddress, String receiverName, String receiverAddress,
                   double weight, String status, String trackingNumber, Date deliveryDate, long userId) {
        this.courierID = courierID;
        this.senderName = senderName;
        this.senderAddress = senderAddress;
        this.receiverName = receiverName;
        this.receiverAddress = receiverAddress;
        this.weight = weight;
        this.status = status;
        this.trackingNumber = trackingNumber;
        this.deliveryDate = deliveryDate;
        this.userId = userId;
    }

    // Getters and Setters
    public long getCourierID() {
        return courierID;
    }

    public void setCourierID(long courierID) {
        this.courierID = courierID;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getSenderAddress() {
        return senderAddress;
    }

    public void setSenderAddress(String senderAddress) {
        this.senderAddress = senderAddress;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Courier{" +
                "courierID=" + courierID +
                ", senderName='" + senderName + '\'' +
                ", senderAddress='" + senderAddress + '\'' +
                ", receiverName='" + receiverName + '\'' +
                ", receiverAddress='" + receiverAddress + '\'' +
                ", weight=" + weight +
                ", status='" + status + '\'' +
                ", trackingNumber='" + trackingNumber + '\'' +
                ", deliveryDate=" + deliveryDate +
                ", userId=" + userId +
                '}';
    }
}
