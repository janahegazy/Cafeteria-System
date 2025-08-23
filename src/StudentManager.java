import java.util.HashMap;

public class StudentManager implements IStudentManager{
    public HashMap<String, Student> getStudents() {
        return students;
    }

    private HashMap<String, Student> students;
    Student student;

    public void addStudent(String name, int id) {
        Student student=new Student(name,id);
       students.put(name,student);
        System.out.println("Added student: " + name + " (ID: " + id + ")");
    }
    public void showAllStudents() {
        System.out.println("\n--- All Students ---");
        if (students.isEmpty()) {
            System.out.println("No students registered yet.");
            return;
        }
        for (Student student : students.values()) {
            System.out.println("ID: " + student.getID() + " | Name: " + student.getName() +
                    " | Points: " + student.getPoints() + " | Streak: " + student.getLoginStreak() + " days" +
                    " | Redemptions: " + student.redemptionHistory.size());
        }

    }


    public void viewStudent() {
        System.out.println("\n--- View Student Info ---");
        System.out.print("Enter student ID: ");
        int id=student.getID();
        if (!students.containsKey(id)) {
            System.out.println("Student not found!");
            return;
        }

        System.out.println("\n=== " + student.getName() + "'s Profile ===");
        System.out.println("Student ID: " + student.getID());
        System.out.println("Points: " + student.getPoints());
        System.out.println("Login Streak: " + student.getLoginStreak() + " days");
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
    public void checkStreakRewards(Student student) {
        int point=student.getPoints();
        if (student.getLoginStreak() == 7) {

            point += 25;
            System.out.println("🎉 7-day login streak! +25 bonus points");
        } else if (student.getLoginStreak() == 30) {
            point += 100;
            System.out.println("🎉 30-day login streak! +100 bonus points");
        }
    }

}
