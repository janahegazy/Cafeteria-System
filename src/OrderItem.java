import java.util.ArrayList;

public class OrderItem implements IOrderItem{
    MenuItem item;
    ArrayList<MenuItem> items=new ArrayList<>();
    LoyaltyProgram loyaltyProgram;
    public double getTotalCostOfOneOrder(int order_id) {
        return totalCostOfOneOrder;
    }

    private double totalCostOfOneOrder;

    public String addItemtoOrder(String name,int order_id,int student_id,MenuItem item){
        Student student=new Student(name,student_id);
        int numofitemleft=item.getNumOfItemleft();
        items.add(item);
        if (soldOutItem(item)){
            return "Sorry, this item is sold out!";

        }
        totalCostOfOneOrder+=item.getPrice();
        numofitemleft--;
        item.setNumOfItemleft(numofitemleft);
        int pointsEarned = (int) (totalCostOfOneOrder / 10);
        int new_points=student.getPoints();
        new_points+= pointsEarned;

        System.out.println("Added " + pointsEarned + " points to " + student.getName());
        System.out.println("Total points: " + new_points);
        loyaltyProgram.checkOrderAchievements(student, totalCostOfOneOrder);

        return "The item is added to your order successfully!";
    }
    public String removeItemFromOrder(int order_id,int student_id,MenuItem item){
        items.remove(item);
        totalCostOfOneOrder-=item.getPrice();

        return "The item is removed from your order successfully!";
    }public boolean soldOutItem(MenuItem item){
        if (item.getNumOfItemleft()==0){
            return true;
        }else {
            return false;
        }
    }
}
