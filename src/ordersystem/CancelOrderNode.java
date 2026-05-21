package ordersystem;

public class CancelOrderNode {

    int orderId;
    String customerName;
    String orderDetails;
    int quantity;
    String status;
    CancelOrderNode next;

    public CancelOrderNode(int orderId, String customerName, String orderDetails, int quantity, String status) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.orderDetails = orderDetails;
        this.quantity = quantity;
        this.status = status;
        this.next = null;
    }
}
