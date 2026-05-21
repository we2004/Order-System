
package ordersystem;

public class OrderNode {
    int orderId;
    String customerName;
    String orderDetails;
    int quantity;
    String status;
    double total;
    int productId;
    
    OrderNode next;
    
    public OrderNode(int orderId, String customerName, String orderDetails, int quantity, String status, double total, int productId) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.orderDetails = orderDetails;
        this.quantity = quantity;
        this.status = status;
        this.total = total;
        this.productId = productId;
        
        next = null;
    }
}
