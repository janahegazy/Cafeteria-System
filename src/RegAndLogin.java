import java.util.Scanner;

public class RegAndLogin implements IRegAndLogin {
    Scanner M;
    Student student;
    StudentManager studentManager;
    RegAndLogin(){
        this.M = new Scanner(System.in);
    }
    public boolean register(String name,String idInput) {
        while(true) {
            if (idInput.matches("\\d{6}")) {
                System.out.println("Succesfully registered your account");
                student.setName(name);
                student.setId(Integer.parseInt(idInput));
                return true;
            }

            System.out.println("Invalid ID. It must be exactly 6 digits.");
        }
    }

    public void studentLogin() {
        System.out.println("\n--- Student Login ---");
        System.out.print("Enter student ID: ");
        String id = M.nextLine();

        if (!studentManager.getStudents().containsKey(id)) {
            System.out.println("Student not found!");
            return;
        }

      student = studentManager.getStudents().get(id);
        String today = java.time.LocalDate.now().toString();
        int i = student.getLoginStreak();

        if (!today.equals(student.lastLoginDate)) {
            if (student.lastLoginDate.isEmpty() ||
                    isConsecutiveDay(student.lastLoginDate, today)) {

                i++;
            } else {
                i = 1;
            }
            student.lastLoginDate = today;
        }

        System.out.println("Welcome, " + student.getName() + "! Login streak: " + i + " days");


        studentManager.checkStreakRewards(student);
    }
    public boolean isConsecutiveDay(String prevDate, String currentDate) {
        try {
            java.time.LocalDate prev = java.time.LocalDate.parse(prevDate);
            java.time.LocalDate curr = java.time.LocalDate.parse(currentDate);
            return prev.plusDays(1).equals(curr);
        } catch (Exception e) {
            return false;
        }
    }
}
