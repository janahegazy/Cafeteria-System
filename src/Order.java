//I need to add/subtract the total cost by the added/canceled order cost
public  class Order {
    private int order_id;

    int numberOfOrders;
    private double totalcost;
    public  void cancelOrder(int order_id,Student student_id){
       numberOfOrders--;
        System.out.println("Your Order is canceled successfully!");
        //totalcost-=menuItem.cost;

    }  public  void confirmOrder(int order_id,Student student_id){
       numberOfOrders++;
        System.out.println("Your Order is confirmed successfully!");
        //totalcost+=menuItem.cost;

    }

    public int getOrder_id() {
        return order_id;
    }
}
