public class OrderProcessor {
    Order order;
    LoyaltyProgram loyaltyProgram; //for the points
    public  void cancelOrder(int order_id,Student student_id){

        order.numberOfOrders--;
        System.out.println("Your Order is canceled successfully!");
//        order.getTotalCost()-=menuItem.cost;

    }  public  void confirmOrder(int order_id,Student student_id){
        order.numberOfOrders++;
        System.out.println("Your Order is confirmed successfully!");
//        order.getTotalCost()-=menuItem.cost;

    }

}
