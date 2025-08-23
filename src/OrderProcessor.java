import java.util.ArrayList;

public class OrderProcessor {
Order order;

    MenuItem item=new MenuItem();
    LoyaltyProgram loyaltyProgram; //for the points ..
    OrderProcessing orderProcessing;
    OrderItem orderItem;

    public OrderItem getOrderItem() {
        return orderItem;
    }

    public OrderProcessing getOrderProcessing() {
        return orderProcessing;
    }
}
