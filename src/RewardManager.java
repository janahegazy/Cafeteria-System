import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RewardManager implements IRewardManager{
    private ArrayList<Reward> rewards;
Scanner scanner=new Scanner(System.in);
    public void setupRewards() {
        rewards.add(new Reward("Free Coffee", "Get a free coffee drink", 50));
        rewards.add(new Reward("10% Discount", "10% off your next order", 100));
        rewards.add(new Reward("Free Dessert", "Get a free dessert", 150));
        rewards.add(new Reward("Free Meal", "Get a free meal", 300));
    }
    public void addReward() {
        System.out.println("\n--- Add New Reward ---");
        System.out.print("Enter reward name: ");
        String name = scanner.nextLine();

        System.out.print("Enter reward description: ");
        String description = scanner.nextLine();

        System.out.print("Enter point cost: ");
        try {
            int cost = Integer.parseInt(scanner.nextLine());
            rewards.add(new Reward(name, description, cost));
            System.out.println("Reward added successfully!");
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number!");
        }
    }
    StudentManager studentManager;
    public void redeemReward() {
        System.out.println("\n--- Redeem Reward ---");
        System.out.print("Enter student ID: ");
        String id = scanner.nextLine();

        if (!studentManager.getStudents().containsKey(id)) {
            System.out.println("Student not found!");
            return;
        }

        Student student = studentManager.getStudents().get(id);

        System.out.println("Your points: " + student.getPoints());
        ShowRewards();

        System.out.print("Select reward (1-" + rewards.size() + "): ");
        try {
            int choice = Integer.parseInt(scanner.nextLine());

            if (choice < 1 || choice > rewards.size()) {
                System.out.println("Invalid choice!");
                return;
            }

            Reward selectedReward = rewards.get(choice - 1);
            int remainigPoints= student.getPoints();
            if (student.getPoints() >= selectedReward.cost) {
                remainigPoints -= selectedReward.cost;
                student.rewards.add(selectedReward.name);

                // Add to redemption history
                student.redemptionHistory.add(new Redemption(selectedReward.name, selectedReward.cost));

                System.out.println("🎁 Success! You redeemed: " + selectedReward.name);
                System.out.println("Remaining points: " + remainigPoints);
            } else {
                System.out.println("Not enough points! You need " + selectedReward.cost + " but only have " + student.getPoints());
            }

        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number!");
        }
    }
    public void ShowRewards(){
        System.out.println("\n--- Available Rewards ---");
        for (int i = 0; i < rewards.size(); i++) {
            Reward reward = rewards.get(i);
            System.out.println((i+1) + ". " + reward.name + " - " + reward.description + " (" + reward.cost + " points)");
        }
    }
}
