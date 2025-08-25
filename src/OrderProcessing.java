import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderProcessing implements IOrderProcessing {
    Order order = new Order();
    OrderItem orderItem = new OrderItem();


    public Map<Integer, Double> getOrders() {
        return orders;
    }

    public void setOrders(Map<Integer, Double> orders) {
        this.orders = orders;
    }

    private Map<Integer, Double> orders = new HashMap<>(); // order_id -> totalCost

    public OrderProcessing(OrderItem orderItem) {
        this.orderItem = orderItem;
    }

    public OrderProcessing() {

    }

    public void setTotalCostOfAllOrders(int totalCostOfAllOrders) {
        this.totalCostOfAllOrders = totalCostOfAllOrders;
    }

    private int totalCostOfAllOrders = 0;

    public void cancelOrder(int order_id, int student_id) {
        if (orders.containsKey(order_id)) {
            orders.remove(order_id);
            System.out.println("Your Order " + order_id + " is canceled successfully!");
        } else {
            System.out.println("Order not found!");
        }
    }

    public void confirmOrder(int order_id, int student_id) {
        double totalCost = orderItem.getTotalCostOfOneOrder(order_id);
        orders.put(order_id, totalCost);//        totalCostOfAllOrders+=orderItem.getTotalCostOfOneOrder(order_id);
        order.numberOfOrders++;

        System.out.println("Your Order is confirmed successfully!");
//
    }

    public double getTotalCostOfAllOrders() {
        double total = 0.0;
        for (double cost : orders.values()) {
            total += cost;
        }
        return total;
    }
}

