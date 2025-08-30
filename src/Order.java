import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;

//I need to add/subtract the total cost by the added/canceled order cost
public  class Order {
    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    //I need datastructure to store the items and its price  ---> we can use stack to store several items in one stack for one order
    //maybe I'll need time stamp
    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    protected String orderStatus;
    private LocalDate date;
    int numberOfOrders; //related to the number of objects
    private int order_id;

    //we can create OrderHistory class or we can only inform the user with the date of confirming his order

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    private double totalCost=0.0;

    public int getOrder_id() {
        return order_id;
    }
    LocalDate localDate;
    public LocalDate getDate() {
        return date;
    }
    Order(){

    }
    Order(int id){
        id=this.order_id;
    }
}
