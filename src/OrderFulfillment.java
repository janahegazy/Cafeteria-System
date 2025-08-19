import java.util.PriorityQueue;

public abstract  class OrderFulfillment extends Order {
    //the class shall be Interface because it contains functions that is extended from Order class
    //So you have to change it to interface
    //
    Order order;
    PriorityQueue waiting_list=new PriorityQueue<>();
    
}
