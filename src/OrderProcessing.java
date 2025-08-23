import java.util.ArrayList;

public class OrderProcessing implements IOrderProcessing{
    Order order;
    OrderItem orderItem;

    public ArrayList<Order> getOrders() {
        return orders;
    }

    ArrayList<Order> orders=new ArrayList<>();

    public int getTotalCostOfAllOrders() {
        return totalCostOfAllOrders;
    }

    public void setTotalCostOfAllOrders(int totalCostOfAllOrders) {
        this.totalCostOfAllOrders = totalCostOfAllOrders;
    }

    private int totalCostOfAllOrders=0;
    public  void cancelOrder(int order_id, int student_id){
        Order order1=new Order(order_id);
        orders.remove(order1);
        order.numberOfOrders--;
        System.out.println("Your Order is canceled successfully!");
//        order.getTotalCost()-=menuItem.cost;

    }

    public  void confirmOrder(int order_id,int student_id){
        Order order1=new Order(order_id);
        orders.add(order1);
        totalCostOfAllOrders+=orderItem.getTotalCostOfOneOrder(order_id);
        order.numberOfOrders++;
        System.out.println("Your Order is confirmed successfully!");
    setTotalCostOfAllOrders(totalCostOfAllOrders);
    }
}
