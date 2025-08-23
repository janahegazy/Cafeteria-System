import java.util.*;

public class LoyaltyProgram {

//    private void setupDemoStudents() {
//        addStudent("S1001", "Ahmed Mohamed");
//        addStudent("S1002", "Fatima Mahmoud");
//        addStudent("S1003", "Omar Hassan");
//
//
//        Student demoStudent = students.get("S1001");
//        demoStudent.points = 200;
//        demoStudent.redemptionHistory.add(new Redemption("Free Coffee", 50));
//        demoStudent.rewards.add("Free Coffee");
//    }


//
//    public void registerStudent() {
//        System.out.println("\n--- Register New Student ---");
//        System.out.print("Enter student ID: ");
//        String id = scanner.nextLine();
//
//        if (students.containsKey(id)) {
//            System.out.println("This ID already exists!");
//            return;
//        }
//
//        System.out.print("Enter student name: ");
//        String name = scanner.nextLine();
//
//        addStudent(id, name);
//    }
//
//    public void studentLogin() {
//        System.out.println("\n--- Student Login ---");
//        System.out.print("Enter student ID: ");
//        String id = scanner.nextLine();
//
//        if (!students.containsKey(id)) {
//            System.out.println("Student not found!");
//            return;
//        }
//
//        Student student = students.get(id);
//        String today = java.time.LocalDate.now().toString();
//
//
//        if (!today.equals(student.lastLoginDate)) {
//            if (student.lastLoginDate.isEmpty() ||
//                    isConsecutiveDay(student.lastLoginDate, today)) {
//                student.loginStreak++;
//            } else {
//                student.loginStreak = 1;
//            }
//            student.lastLoginDate = today;
//        }
//
//        System.out.println("Welcome, " + student.name + "! Login streak: " + student.loginStreak + " days");
//
//
//        checkStreakRewards(student);
//    }




    public void checkOrderAchievements(Student student, double orderTotal) {

        if (student.getPoints() < 100 && orderTotal > 0) {
            System.out.println("🌟 First order bonus! Keep ordering to earn more points!");
        }
        if (orderTotal > 200) {
            int points= student.getPoints();
            points += 20;
            student.setPoints(points);
            System.out.println("🎉 Big order bonus! +20 points");
        }
    }

//    public void showMenu() {
//        while (true) {
//            System.out.println("\n===== CAFETERIA LOYALTY PROGRAM =====");
//            System.out.println("1. Student Login");
//            System.out.println("2. Register New Student");
//            System.out.println("3. Add Order Points");
//            System.out.println("4. View Rewards");
//            System.out.println("5. Redeem Reward");
//            System.out.println("6. View My Info");
//            System.out.println("7. View Redemption History");
//            System.out.println("8. Admin: Add New Reward");
//            System.out.println("9. Admin: View All Students");
//            System.out.println("10. Admin: View Redemption Statistics");
//            System.out.println("11. Exit");
//            System.out.print("Choose an option: ");
//
//            String choice = scanner.nextLine();
//
//            switch (choice) {
//                case "1":
//                    studentLogin();
//                    break;
//                case "2":
//                    registerStudent();
//                    break;
//                case "3":
//                    addOrder();
//                    break;
//                case "4":
//                    showRewards();
//                    break;
//                case "5":
//                    redeemReward();
//                    break;
//                case "6":
//                    viewStudent();
//                    break;
//                case "7":
//                    viewRedemptionHistory();
//                    break;
//                case "8":
//                    addReward();
//                    break;
//                case "9":
//                    showAllStudents();
//                    break;
//                case "10":
//                    showRedemptionStats();
//                    break;
//                case "11":
//                    System.out.println("Thank you for using the Cafeteria Loyalty Program!");
//                    return;
//                default:
//                    System.out.println("Invalid option! Please try again.");
//            }
//        }
//    }
//
//
//    public static void main(String[] args) {
//        LoyaltyProgram program = new LoyaltyProgram();
//        program.showMenu();
//    }
}