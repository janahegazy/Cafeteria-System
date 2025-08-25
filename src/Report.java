import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;

public class Report {
    private OrderProcessor orderProcessor;
    private LoyaltyProgram loyaltyProgram;
    Order order;
    OrderProcessing orderProcessing;
    public Report(OrderProcessor orderProcessor, LoyaltyProgram loyaltyProgram) {
        this.orderProcessor = orderProcessor;
        this.loyaltyProgram = loyaltyProgram;
    }
    // ✅ Daily sales
    public double getDailySales(LocalDate date) {
        Order order=new Order();
        double total = 0;
        for (Double order1 : orderProcessing.getOrders().values()) {
            if (order.getDate().equals(date)) {
                total += order.getTotalCost();
            }
        }
        return total;
    }
    // ✅ Weekly sales
    OrderItem orderItem;

    public double getWeeklySales(LocalDate startOfWeek, LocalDate endOfWeek) {
        double total = 0;
        for(Double order1 : orderProcessing.getOrders().values()){
            LocalDate d = order.getDate();
            if ((d.isAfter(startOfWeek.minusDays(1))) && (d.isBefore(endOfWeek.plusDays(1)))) {
                total += order.getTotalCost();
            }
        }
        return total;
    }

    // ✅ Loyalty points redeemed (total in range)
    // ✅ Loyalty points redeemed
    public int getLoyaltyRedemptions(LocalDate start, LocalDate end) {
        int totalPoints = 0;
        StudentManager studentManager = new StudentManager();

        for (Student student : studentManager.getStudents().values()) {
            for (Redemption redemption : student.redemptionHistory) {
                LocalDate redemptionDate = LocalDate.parse(redemption.date);
                if ((redemptionDate.isAfter(start.minusDays(1))) &&
                        (redemptionDate.isBefore(end.plusDays(1)))) {
                    totalPoints += redemption.pointsSpent;
                }
            }
        }
        return totalPoints;
    }
}