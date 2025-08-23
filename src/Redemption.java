import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Redemption implements IRedemption{
    Scanner scanner=new Scanner(System.in);
    String rewardName;
    int pointsSpent;
    String date;
    StudentManager studentManager;
    Redemption(String rewardName, int pointsSpent) {
        this.rewardName = rewardName;
        this.pointsSpent = pointsSpent;
        this.date = java.time.LocalDate.now().toString();
    }
    public void showRedemptionStats() {
        System.out.println("\n--- Redemption Statistics ---");

        int totalRedemptions = 0;
        int totalPointsSpent = 0;
        Map<String, Integer> rewardPopularity = new HashMap<>();

        for (Student student : studentManager.getStudents().values()) {
            totalRedemptions += student.redemptionHistory.size();

            for (Redemption redemption : student.redemptionHistory) {
                totalPointsSpent += redemption.pointsSpent;


                rewardPopularity.put(redemption.rewardName,
                        rewardPopularity.getOrDefault(redemption.rewardName, 0) + 1);
            }
        }

        System.out.println("Total redemptions across all students: " + totalRedemptions);
        System.out.println("Total points spent: " + totalPointsSpent);

        if (!rewardPopularity.isEmpty()) {
            System.out.println("\nMost popular rewards:");
            rewardPopularity.entrySet().stream()
                    .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                    .forEach(entry ->
                            System.out.println(" - " + entry.getKey() + ": " + entry.getValue() + " redemptions"));
        }
    }
    public void viewRedemptionHistory() {
        System.out.println("\n--- View Redemption History ---");
        System.out.print("Enter student ID: ");
        String id = scanner.nextLine();

        if (!studentManager.getStudents().containsKey(id)) {
            System.out.println("Student not found!");
            return;
        }
Student student = studentManager.getStudents().get(id);

        if (student.redemptionHistory.isEmpty()) {
            System.out.println("No redemptions found for " + student.getName());
            return;
        }

        System.out.println("\n=== " + student.getName() + "'s Redemption History ===");
        System.out.println("Reward Name\tPoints Spent\tDate");
        System.out.println("---------------------------------------------");

        int totalPointsSpent = 0;
        for (Redemption redemption : student.redemptionHistory) {
            System.out.println(redemption.rewardName + "\t" + redemption.pointsSpent + "\t\t" + redemption.date);
            totalPointsSpent += redemption.pointsSpent;
        }

        System.out.println("---------------------------------------------");
        System.out.println("Total points spent: " + totalPointsSpent);
    }





}
