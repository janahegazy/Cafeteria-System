import java.util.*;

public class LoyaltyProgram {

    class Student {
        protected String id;
        protected String name;
        protected int points;
        protected List<String> rewards;
        protected  int loginStreak;
        protected String lastLoginDate;
        protected List<Redemption> redemptionHistory;

        Student(String id, String name) {
            this.id = id;
            this.name = name;
            this.points = 0;
            this.rewards = new ArrayList<>();
            this.loginStreak = 0;
            this.lastLoginDate = "";
            this.redemptionHistory = new ArrayList<>();
        }
    }


    class Reward {
        String name;
        String description;
        int cost;

        Reward(String name, String description, int cost) {
            this.name = name;
            this.description = description;
            this.cost = cost;
        }
    }


    class Redemption {
        String rewardName;
        int pointsSpent;
        String date;

        Redemption(String rewardName, int pointsSpent) {
            this.rewardName = rewardName;
            this.pointsSpent = pointsSpent;
            this.date = java.time.LocalDate.now().toString();
        }
    }

    private HashMap<String, Student> students;
    private ArrayList<Reward> rewards;
    private Scanner scanner;


    public LoyaltyProgram() {
        students = new HashMap<>();
        rewards = new ArrayList<>();
        scanner = new Scanner(System.in);


        setupRewards();


        setupDemoStudents();
    }


    private void setupRewards() {
        rewards.add(new Reward("Free Coffee", "Get a free coffee drink", 50));
        rewards.add(new Reward("10% Discount", "10% off your next order", 100));
        rewards.add(new Reward("Free Dessert", "Get a free dessert", 150));
        rewards.add(new Reward("Free Meal", "Get a free meal", 300));
    }


    private void setupDemoStudents() {
        addStudent("S1001", "Ahmed Mohamed");
        addStudent("S1002", "Fatima Mahmoud");
        addStudent("S1003", "Omar Hassan");


        Student demoStudent = students.get("S1001");
        demoStudent.points = 200;
        demoStudent.redemptionHistory.add(new Redemption("Free Coffee", 50));
        demoStudent.rewards.add("Free Coffee");
    }


    public void addStudent(String id, String name) {
        Student newStudent = new Student(id, name);
        students.put(id, newStudent);
        System.out.println("Added student: " + name + " (ID: " + id + ")");
    }


    public void registerStudent() {
        System.out.println("\n--- Register New Student ---");
        System.out.print("Enter student ID: ");
        String id = scanner.nextLine();

        if (students.containsKey(id)) {
            System.out.println("This ID already exists!");
            return;
        }

        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        addStudent(id, name);
    }

    public void studentLogin() {
        System.out.println("\n--- Student Login ---");
        System.out.print("Enter student ID: ");
        String id = scanner.nextLine();

        if (!students.containsKey(id)) {
            System.out.println("Student not found!");
            return;
        }

        Student student = students.get(id);
        String today = java.time.LocalDate.now().toString();


        if (!today.equals(student.lastLoginDate)) {
            if (student.lastLoginDate.isEmpty() ||
                    isConsecutiveDay(student.lastLoginDate, today)) {
                student.loginStreak++;
            } else {
                student.loginStreak = 1;
            }
            student.lastLoginDate = today;
        }

        System.out.println("Welcome, " + student.name + "! Login streak: " + student.loginStreak + " days");


        checkStreakRewards(student);
    }


    private boolean isConsecutiveDay(String prevDate, String currentDate) {
        try {
            java.time.LocalDate prev = java.time.LocalDate.parse(prevDate);
            java.time.LocalDate curr = java.time.LocalDate.parse(currentDate);
            return prev.plusDays(1).equals(curr);
        } catch (Exception e) {
            return false;
        }
    }

    private void checkStreakRewards(Student student) {
        if (student.loginStreak == 7) {
            student.points += 25;
            System.out.println("🎉 7-day login streak! +25 bonus points");
        } else if (student.loginStreak == 30) {
            student.points += 100;
            System.out.println("🎉 30-day login streak! +100 bonus points");
        }
    }


    public void addOrder() {
        System.out.println("\n--- Add Order Points ---");
        System.out.print("Enter student ID: ");
        String id = scanner.nextLine();

        if (!students.containsKey(id)) {
            System.out.println("Student not found!");
            return;
        }

        Student student = students.get(id);

        System.out.print("Enter order total: EGP ");
        try {
            double total = Double.parseDouble(scanner.nextLine());


            int pointsEarned = (int)(total / 10);
            student.points += pointsEarned;

            System.out.println("Added " + pointsEarned + " points to " + student.name);
            System.out.println("Total points: " + student.points);


            checkOrderAchievements(student, total);

        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number!");
        }
    }


    private void checkOrderAchievements(Student student, double orderTotal) {

        if (student.points < 100 && orderTotal > 0) {
            System.out.println("🌟 First order bonus! Keep ordering to earn more points!");
        }


        if (orderTotal > 200) {
            student.points += 20;
            System.out.println("🎉 Big order bonus! +20 points");
        }
    }


    public void showRewards() {
        System.out.println("\n--- Available Rewards ---");
        for (int i = 0; i < rewards.size(); i++) {
            Reward reward = rewards.get(i);
            System.out.println((i+1) + ". " + reward.name + " - " + reward.description + " (" + reward.cost + " points)");
        }
    }


    public void redeemReward() {
        System.out.println("\n--- Redeem Reward ---");
        System.out.print("Enter student ID: ");
        String id = scanner.nextLine();

        if (!students.containsKey(id)) {
            System.out.println("Student not found!");
            return;
        }

        Student student = students.get(id);

        System.out.println("Your points: " + student.points);
        showRewards();

        System.out.print("Select reward (1-" + rewards.size() + "): ");
        try {
            int choice = Integer.parseInt(scanner.nextLine());

            if (choice < 1 || choice > rewards.size()) {
                System.out.println("Invalid choice!");
                return;
            }

            Reward selectedReward = rewards.get(choice - 1);

            if (student.points >= selectedReward.cost) {
                student.points -= selectedReward.cost;
                student.rewards.add(selectedReward.name);

                // Add to redemption history
                student.redemptionHistory.add(new Redemption(selectedReward.name, selectedReward.cost));

                System.out.println("🎁 Success! You redeemed: " + selectedReward.name);
                System.out.println("Remaining points: " + student.points);
            } else {
                System.out.println("Not enough points! You need " + selectedReward.cost + " but only have " + student.points);
            }

        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number!");
        }
    }


    public void viewRedemptionHistory() {
        System.out.println("\n--- View Redemption History ---");
        System.out.print("Enter student ID: ");
        String id = scanner.nextLine();

        if (!students.containsKey(id)) {
            System.out.println("Student not found!");
            return;
        }

        Student student = students.get(id);

        if (student.redemptionHistory.isEmpty()) {
            System.out.println("No redemptions found for " + student.name);
            return;
        }

        System.out.println("\n=== " + student.name + "'s Redemption History ===");
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


    public void viewStudent() {
        System.out.println("\n--- View Student Info ---");
        System.out.print("Enter student ID: ");
        String id = scanner.nextLine();


        if (!students.containsKey(id)) {
            System.out.println("Student not found!");
            return;
        }

        Student student = students.get(id);

        System.out.println("\n=== " + student.name + "'s Profile ===");
        System.out.println("Student ID: " + student.id);
        System.out.println("Points: " + student.points);
        System.out.println("Login Streak: " + student.loginStreak + " days");
        System.out.println("Rewards Earned: " + student.rewards);


        if (!student.redemptionHistory.isEmpty()) {
            int totalRedemptions = student.redemptionHistory.size();
            int totalPointsSpent = 0;
            for (Redemption r : student.redemptionHistory) {
                totalPointsSpent += r.pointsSpent;
            }
            System.out.println("Total Redemptions: " + totalRedemptions);
            System.out.println("Total Points Spent: " + totalPointsSpent);

        }
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


    public void showAllStudents() {
        System.out.println("\n--- All Students ---");
        if (students.isEmpty()) {
            System.out.println("No students registered yet.");
            return;
        }


        for (Student student : students.values()) {
            System.out.println("ID: " + student.id + " | Name: " + student.name +
                    " | Points: " + student.points + " | Streak: " + student.loginStreak + " days" +
                    " | Redemptions: " + student.redemptionHistory.size());
        }

    }
    public List<Student> getAllStudents() {
        return new ArrayList<>(students.values());
    }

    public void showRedemptionStats() {
        System.out.println("\n--- Redemption Statistics ---");

        int totalRedemptions = 0;
        int totalPointsSpent = 0;
        Map<String, Integer> rewardPopularity = new HashMap<>();

        for (Student student : students.values()) {
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


    public void showMenu() {
        while (true) {
            System.out.println("\n===== CAFETERIA LOYALTY PROGRAM =====");
            System.out.println("1. Student Login");
            System.out.println("2. Register New Student");
            System.out.println("3. Add Order Points");
            System.out.println("4. View Rewards");
            System.out.println("5. Redeem Reward");
            System.out.println("6. View My Info");
            System.out.println("7. View Redemption History");
            System.out.println("8. Admin: Add New Reward");
            System.out.println("9. Admin: View All Students");
            System.out.println("10. Admin: View Redemption Statistics");
            System.out.println("11. Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    studentLogin();
                    break;
                case "2":
                    registerStudent();
                    break;
                case "3":
                    addOrder();
                    break;
                case "4":
                    showRewards();
                    break;
                case "5":
                    redeemReward();
                    break;
                case "6":
                    viewStudent();
                    break;
                case "7":
                    viewRedemptionHistory();
                    break;
                case "8":
                    addReward();
                    break;
                case "9":
                    showAllStudents();
                    break;
                case "10":
                    showRedemptionStats();
                    break;
                case "11":
                    System.out.println("Thank you for using the Cafeteria Loyalty Program!");
                    return;
                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }
    }


    public static void main(String[] args) {
        LoyaltyProgram program = new LoyaltyProgram();
        program.showMenu();
    }
}
