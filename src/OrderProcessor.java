import java.util.ArrayList;

public class OrderProcessor implements IMenuProvider{
    Order order;
    MenuItem item=new MenuItem();
    LoyaltyProgram loyaltyProgram; //for the points ..
    ArrayList<Order>orders=new ArrayList<>();
private double totalCostOfAllOrders;
private double totalCostOfOneOrder;

    public  void cancelOrder(int order_id, int student_id){
        Order order1=new Order(order_id);
        orders.remove(order1);
        order.numberOfOrders--;
        System.out.println("Your Order is canceled successfully!");
//        order.getTotalCost()-=menuItem.cost;

    }  public  void confirmOrder(int order_id,int student_id){
        Order order1=new Order(order_id);
        orders.add(order1);
        order.numberOfOrders++;
        System.out.println("Your Order is confirmed successfully!");
//        order.getTotalCost()-=menuItem.cost;

    }
    ArrayList<MenuItem>items=new ArrayList<>();
    public String addItemtoOrder(int order_id,int student_id,MenuItem item){

        items.add(item);
        totalCostOfOneOrder+=item.getPrice();
        return "The item is added to your order successfully!";
    }
 public String removeItemFromOrder(int order_id,int student_id,MenuItem item){
        items.remove(item);
     totalCostOfOneOrder-=item.getPrice();

     return "The item is removed from your order successfully!";
    }

}
