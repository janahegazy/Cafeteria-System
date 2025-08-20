import java.util.PriorityQueue;

public abstract  class OrderFulfillment extends CafeteriaStaff {
    PriorityQueue waiting_list=new PriorityQueue<>();
    public String AddtoWaitingList(Order order){
        if (order.orderStatus.equals("pending")){
            waiting_list.add(order);
        }
        return "the order"+order.getOrder_id()+" is pending, please wait for preparation";
    }
}
