package ordersystem;

public class InventoryLinkedList {

    private ProductNode head;

    public InventoryLinkedList() {
        head = null;
    }

    // Add new product to inventory
    public void addProduct(int itemId, String itemName, int quantity, double price) {
        ProductNode newNode = new ProductNode(itemId, itemName, quantity, price);

        if (head == null) {
            head = newNode;
        } else {  //inserting the node at the end 
            ProductNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Remove a product from inventory
    public void removeProduct(int itemId) {

        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }

        // If product is first node
        if (head.itemId == itemId) {
            head = head.next;
            System.out.println("Product removed successfully.");
            return;
        }

        ProductNode current = head;

        while (current.next != null) {

            if (current.next.itemId == itemId) {
                current.next = current.next.next;

                System.out.println("Product removed successfully.");
                return;
            }

            current = current.next;
        }

        System.out.println("Product not found.");
    }

    // Search product by ID
    public ProductNode getProductById(int itemId) {
        ProductNode current = head;

        while (current != null) {
            if (current.itemId == itemId) {
                return current;
            }

            current = current.next;
        }

        return null;
    }

    // Check if product exists and quantity is enough
    public boolean inventoryCheck(int itemId, int requestedQuantity) {
        ProductNode current = head;

        while (current != null) {
            if (current.itemId == itemId) {
                return current.quantity >= requestedQuantity; //return true if the quantity is enough
            }
            current = current.next; 
        }

        return false; //return false if the product dosen't exists and if the quantity isn't enough
    }

    // Decrease stock after fulfilling an order
    public boolean updateStock(int itemId, int requestedQuantity) {
        ProductNode current = head;

        while (current != null) {
            if (current.itemId == itemId) {
                if (current.quantity >= requestedQuantity) { //if the quantity is enough
                    current.quantity -= requestedQuantity; //updating the order quantity
                    System.out.println("Stock updated successfully.");
                    return true;
                } else {
                    System.out.println("Not enough stock.");
                }
                return false;
            }
            current = current.next;
        }

        System.out.println("Product not found.");
        return false;
    }

    // Display all products in inventory
    public void displayStock() {
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }

        ProductNode current = head;

        while (current != null) {
            System.out.println("Item ID: " + current.itemId);
            System.out.println("Item Name: " + current.itemName);
            System.out.println("Quantity: " + current.quantity);
            System.out.println("--------------------");

            current = current.next;
        }
    }
}
