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
        double total = 0;
        for (Order order : orderProcessing.orders) {
            if (order.getDate(DayOfWeek.FRIDAY, Month.AUGUST, Year.now()).equals(date)) {
                total += order.getTotalCost();
            }
        }
        return total;
    }
    // ✅ Weekly sales
    OrderItem orderItem;

//    public double getWeeklySales(LocalDate startOfWeek, LocalDate endOfWeek) {
//        double total = orderItem.getTotalCostOfOneOrder(order.getOrder_id());
//        for (Order order : orderProcessing.orders) {
//            if ((order.getDate().isAfter(startOfWeek.minusDays(1))) &&
//                    (order.getDate().isBefore(endOfWeek.plusDays(1)))) {
////                total += order.getTotalCost();
//            }
//        }
//        return total;
//    }

    // ✅ Loyalty points redeemed (total in range)
    public int getLoyaltyRedemptions(LocalDate start, LocalDate end) {
        int totalPoints = 0;
        StudentManager studentManager =new StudentManager();
        // نعدي على كل الطلاب
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