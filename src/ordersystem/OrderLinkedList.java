package ordersystem;

public class OrderLinkedList {

    OrderNode head;
    int size;

    public OrderLinkedList() {
        head = null;
        size = 0;
    }

    public void addOrder(String customerName, int productId, int quantity, InventoryLinkedList stockInventory) {
        if (stockInventory.inventoryCheck(productId, quantity)) {
            size++;
            ProductNode product = stockInventory.getProductById(productId);

            String productName = product.itemName;
            int orderId = size;
            String status = "Active";
            double total = quantity * product.price;

            OrderNode order = new OrderNode(orderId, customerName, productName, quantity, status, total);
            addNode(order);

        } else {
            ProductNode product = stockInventory.getProductById(productId);
            System.out.println("Item is not available");
            
            if(product != null)
                System.out.println("available quantity: " + product.quantity);
        }
    }

    public void fulfillOrder(OrderLinkedList fulfilledOrders, InventoryLinkedList stockInventory) {

        if (head == null) {
            System.out.println("No Active Orders");
        } else {

            OrderNode order = head;
            head = order.next;
            
            order.next = null;
            order.status = "Completed";
            stockInventory.updateStock(order.orderDetails, order.quantity);
            fulfilledOrders.addNode(order);
            System.out.println("Order Fullfilled Sucessfully");
        }

    }

    public OrderNode getOrderById(int orderId) {

        OrderNode temp = head;
        while (temp != null) {
            if (temp.orderId == orderId) {
                return temp;
            }
            temp = temp.next;
        }

        System.out.println("Order Not Found");
        return null;
    }

    public void addNode(OrderNode node) {

        if (head == null) {
            head = node;
        } else {

            OrderNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }

        System.out.println("Order added successfully");
    }
    
    public void displayList() {
        if(head == null) {
            System.out.println("List Is Empty");
        } else {
            OrderNode order = head;
            
            while(order != null) {
                System.out.println("Order ID: "+order.orderId+" | Customer: "+order.customerName+" | Details: "+order.orderDetails+" | Quantity: "+order.quantity+" | Total: "+order.total+"SAR | Status: "+order.status);
                order = order.next;
            }
        }
        
    }
}


