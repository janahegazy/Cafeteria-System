import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderItem implements IOrderItem{
    MenuItem item;


    public Map<Integer, List<MenuItem>> getItems() {
        return items;
    }

    public void setItems(Map<Integer, List<MenuItem>> items) {
        this.items = items;
    }

    private Map<Integer, List<MenuItem>> items = new HashMap<>(); // ✅ كل order_id معاه ليست من الـ items
    LoyaltyProgram loyaltyProgram=new LoyaltyProgram();



    public String addItemtoOrder(String name,int order_id,int student_id,int points,MenuItem item){
        Student student=new Student(name,student_id,points);
        if (soldOutItem(item)){
            return "Sorry, this item is sold out!";
        }
        items.putIfAbsent(order_id, new ArrayList<>());

        items.get(order_id).add(item);

        int numOfItemLeft = item.getNumOfItemleft() - 1;
        item.setNumOfItemleft(numOfItemLeft);
        double totalCostOfOneOrder = getTotalCostOfOneOrder(order_id);

        int pointsEarned = (int) (totalCostOfOneOrder / 10);
        int new_points=points+pointsEarned;


        System.out.println("Added " + pointsEarned + " points to " + student.getName());
        System.out.println("Total points: " + new_points);
        loyaltyProgram.checkOrderAchievements(student, totalCostOfOneOrder);
        System.out.println(totalCostOfOneOrder);
        return "The item is added to your order successfully!";
    }
    public double getTotalCostOfOneOrder(int order_id) {
        double total = 0.0;
        List<MenuItem> orderItems = items.get(order_id);
        if (orderItems != null) {
            for (MenuItem item : orderItems) {
                total += item.getPrice();
            }
        }
        return total;
    }

    public String removeItemFromOrder(int order_id,int student_id,MenuItem item){
        List<MenuItem> orderItems = items.get(order_id);
        if (orderItems != null && orderItems.remove(item)) {
            return "The item is removed from your order successfully!";
        }
        return "Item not found in this order!";
    }public boolean soldOutItem(MenuItem item){
        if (item.getNumOfItemleft()==0){
            return true;
        }else {
            return false;
        }
    }
}
