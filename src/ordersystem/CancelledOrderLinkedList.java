package ordersystem;

public class CancelledOrderLinkedList {

    private CancelOrderNode head;

    public CancelledOrderLinkedList() {
        this.head = null;
    }

    public void cancelOrder(int orderId, OrderLinkedList activeOrders) {
        OrderNode activeOrder = activeOrders.getOrderById(orderId);

        if (activeOrder == null) {
            return;
        }

        CancelOrderNode newNode = new CancelOrderNode(
                activeOrder.orderId,
                activeOrder.customerName,
                activeOrder.orderDetails,
                activeOrder.quantity,
                "Cancelled"
        );

        if (head == null) {
            head = newNode;
        } else {
            CancelOrderNode currentArchive = head;
            while (currentArchive.next != null) {
                currentArchive = currentArchive.next;
            }
            currentArchive.next = newNode;
        }
        System.out.println("Order ID (" + orderId + ") has been successfully archived in CancelledOrderLinkedList.");

        if (activeOrders.head != null && activeOrders.head.orderId == orderId) {
            activeOrders.head = activeOrders.head.next;
            System.out.println("Order removed from active orders.");
            return;
        }

        OrderNode current = activeOrders.head;
        while (current != null && current.next != null) {
            if (current.next.orderId == orderId) {
                current.next = current.next.next;
                System.out.println("Order removed from active orders.");
                return;
            }
            current = current.next;
        }
    }

    public void displayList() {
        if (head == null) {
            System.out.println("The Cancelled Orders list is currently empty.");
            return;
        }

        System.out.println("CANCELLED ORDERS");
        System.out.println("=========================");

        CancelOrderNode current = head;
        while (current != null) {
            System.out.println("Order ID: " + current.orderId
                    + " | Customer: " + current.customerName
                    + " | Details: " + current.orderDetails
                    + " | Quantity: " + current.quantity
                    + " | Status: " + current.status);
            current = current.next;
        }
    }
}
