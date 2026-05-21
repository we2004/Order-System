package ordersystem;

import java.util.Scanner;

public class OrderSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        InventoryLinkedList stockInventory = new InventoryLinkedList();
        OrderLinkedList activeOrders = new OrderLinkedList();
        OrderLinkedList fulfilledOrders = new OrderLinkedList();
        CancelledOrderLinkedList cancelledOrders = new CancelledOrderLinkedList();

        stockInventory.addProduct(101, "Lenovo Yoga Laptop", 10, 3500.00);
        stockInventory.addProduct(102, "Wireless Mouse", 25, 150.00);
        stockInventory.addProduct(103, "Mechanical Keyboard", 15, 300.00);
        stockInventory.addProduct(104, "4K Monitor", 8, 850.00);

        System.out.println("\n--- AVAILABLE INVENTORY ---");
        stockInventory.displayStock();

        boolean systemRunning = true;

        // 3. Main interactive employee menu
        while (systemRunning) {
            System.out.println("\n=========================================");
            System.out.println("             MENU             ");
            System.out.println("1. Place a New Order");
            System.out.println("2. Fulfill Next Order");
            System.out.println("3. Cancel an Active Order");
            System.out.println("4. Display System Lists");
            System.out.println("5. Exit System");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("\n--- AVAILABLE INVENTORY ---");
                    stockInventory.displayStock(); 

                    System.out.print("Enter Customer Name: ");
                    String customerName = scanner.nextLine();

                    System.out.print("Enter Product ID to order: ");
                    int productId = scanner.nextInt();

                    System.out.print("Enter Quantity: ");
                    int quantity = scanner.nextInt();

                    activeOrders.addOrder(customerName, productId, quantity, stockInventory);
                    break;

                case 2:
                    System.out.println("\n--- FULFILLING NEXT ORDER ---");
                    activeOrders.fulfillOrder(fulfilledOrders, stockInventory);
                    break;

                case 3:
                    System.out.println("\n--- CURRENT ACTIVE ORDERS ---");
                    if (activeOrders.head == null) {
                        System.out.println("There are currently no active orders to cancel.");
                    } else {
                        activeOrders.displayList();
                        System.out.print("\nEnter the Order ID you wish to cancel: ");
                        int cancelId = scanner.nextInt();
                        cancelledOrders.cancelOrder(cancelId, activeOrders);
                    }
                    break;

                case 4:
                    System.out.println("\n--- DISPLAY MENUS ---");
                    System.out.println("1. View Inventory Stock");
                    System.out.println("2. View Active Orders");
                    System.out.println("3. View Fulfilled Orders (History)");
                    System.out.println("4. View Cancelled Orders (History)");
                    System.out.print("Select a list to view: ");

                    int listChoice = scanner.nextInt();
                    System.out.println("");

                    if (listChoice == 1) {
                        stockInventory.displayStock();
                    } else if (listChoice == 2) {
                        System.out.println("ACTIVE ORDERS");
                        System.out.println("=========================");
                        activeOrders.displayList();
                    } else if (listChoice == 3) {
                        System.out.println("FULFILLED ORDERS");
                        System.out.println("=========================");
                        fulfilledOrders.displayList();
                    } else if (listChoice == 4) {
                        System.out.println("CANCELLED ORDERS");
                        System.out.println("=========================");
                        cancelledOrders.displayList();
                    } else {
                        System.out.println("Invalid selection.");
                    }
                    break;

                case 5:
                    System.out.println("\nShutting down system... Goodbye!");
                    systemRunning = false;
                    break;

                default:
                    System.out.println("\nInvalid choice. Please enter a number between 1 and 5.");
                    break;
            }
        }

        scanner.close();
    }
}
