import java.util.PriorityQueue;

public class OrderFulfillment {
    public PriorityQueue<Order> getWaitingList() {
        return waitingList;
    }

    public void setWaitingList(PriorityQueue<Order> waitingList) {
        this.waitingList = waitingList;
    }

    private PriorityQueue<Order> waitingList = new PriorityQueue<>(
            (o1, o2) -> o1.getDate().compareTo(o2.getDate()) // sorting the orders according to their creation date
    );

    public String addToWaitingList(int order_id) {
        Order order=new Order(order_id);
        order.setOrder_id(order_id);
        if ("pending".equalsIgnoreCase(order.getOrderStatus())) {
            waitingList.add(order);
            return "The order " + order.getOrder_id() + " is pending, please wait for preparation.";
        }
        return "Order " + order.getOrder_id() + " is not pending!";
    }

    public String fulfillOrder() {
        if (waitingList.isEmpty()) {
            return "No pending orders to fulfill!";
        }
        Order order = waitingList.poll();
        order.setOrderStatus("completed");
        return "Order " + order.getOrder_id() + " has been fulfilled!";
    }

    public void showPendingOrders() {
        if (waitingList.isEmpty()) {
            System.out.println("No pending orders.");
        } else {
            System.out.println("Pending Orders:");
            for (Order order : waitingList) {
                System.out.println(" - Order ID: " + order.getOrder_id() + " (Status: " + order.getOrderStatus() + ")");
            }
        }
    }
}
