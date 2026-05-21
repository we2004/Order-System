
package ordersystem;


public class ProductNode {
    
    int itemId;
    String itemName;
    int quantity;
    double price;
    
    ProductNode next;
    
    public ProductNode(int itemId, String itemName ,int quantity,double price){
        this.itemId=itemId;
        this.itemName=itemName;
        this.quantity=quantity;
        this.price=price;
        next=null;
    }
    
}
