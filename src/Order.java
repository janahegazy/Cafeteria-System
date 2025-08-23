import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;

//I need to add/subtract the total cost by the added/canceled order cost
public  class Order {
    //I need datastructure to store the items and its price  ---> we can use stack to store several items in one stack for one order
    //maybe I'll need time stamp
    private int order_id;
    protected String orderStatus;
    int numberOfOrders; //related to the number of objects
    //we can create OrderHistory class or we can only inform the user with the date of confirming his order

    public double getTotalCost() {
        return totalCost;
    }

    private double totalCost=0.0;

    public int getOrder_id() {
        return order_id;
    }
    LocalDate localDate;
    public String getDate(DayOfWeek day, Month month , Year year){
       return "The order"+order_id+"is created on "+day+"/"+month+"/"+year;
    }
    Order(){

    }
    Order(int id){
        id=this.order_id;
    }
}
