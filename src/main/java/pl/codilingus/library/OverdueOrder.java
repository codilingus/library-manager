package pl.codilingus.library;

import java.util.Comparator;

public class OverdueOrder {
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getOverdueDays() {
        return overdueDays;
    }

    public void setOverdueDays(int overdueDays) {
        this.overdueDays = overdueDays;
    }

    private int userId;
    private String firstName;
    private String lastName;

    private int orderId;
    private int overdueDays;

    public OverdueOrder(int userId, String firstName, String lastName, int orderId, int overdueDays) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.orderId = orderId;
        this.overdueDays = overdueDays;
    }

}
