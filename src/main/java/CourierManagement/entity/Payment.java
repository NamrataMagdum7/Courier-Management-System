package CourierManagement.entity;

import java.util.Date;
 public class Payment {
    private long paymentID;
    private long courierID;
    private double amount;
    private Date paymentDate;

    public Payment() {}

    public Payment(long paymentID, long courierID, double amount, Date paymentDate) {
        this.paymentID = paymentID;
        this.courierID = courierID;
        this.amount = amount;
        this.paymentDate = paymentDate;
    }

    // Getters, Setters, and toString()
}