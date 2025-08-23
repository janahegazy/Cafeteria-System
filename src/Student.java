import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student implements User {
    Scanner M = new Scanner(System.in);

    private String name;
    protected String lastLoginDate;

    private String type;
    private int id;
    RegAndLogin regAndLogin;
    private int loginStreak;
    ArrayList<Redemption> redemptionHistory=new ArrayList<>();
    ArrayList<String> rewards=new ArrayList<>();

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    private int points;
    public Student(String name, int id,String lastLoginDate,String type,int points,int loginStreak,ArrayList<Redemption> redemptionHistory,ArrayList<String> rewards) {
        this.name=name;
        this.id=id;
        this.lastLoginDate=lastLoginDate;
        this.type=type;
        this.points=points;
        this.loginStreak=loginStreak;
        this.redemptionHistory=redemptionHistory;
        this.rewards=rewards;


    }
    Student(String name,int id){
        this.name=name;
        this.id=id;
    }
    public int getLoginStreak() {
        return loginStreak;
    }



    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getID() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getType(){
        return type;
    }
    Student(){

    }

//    public boolean register() {
//        System.out.println("To register, please enter yor name and ID.");
//        String name = M.nextLine();
//        while (true) {
//            System.out.println("Please enter your 6-digit ID:");
//            String idInput = M.nextLine();
//            if (idInput.matches("\\d{6}")) {
//                id = Integer.parseInt(idInput);
//                break;
//            } else {
//                System.out.println("Invalid ID. It must be exactly 6 digits.");
//            }
//        }
//
//        // if (id exists in datatabase ) {
//        //     System.out.println("ID already exists logging in.");
//        //       log student in
//        //       break;                                           //will change after database implementation
//        // }
//
//        System.out.println("Succesfully registered your account");                                     //else
//        setName(name);
//        setId(id);
//
//        return true;
//    }
//    public boolean login(){
//        boolean login = false;
//        System.out.println("To login, please enter your name and ID.");
//
//        while (true) {
//            System.out.println("Please enter your name:");
//            String name = M.nextLine();
//            System.out.println("Please enter your 6-digit ID:");
//            int idInput = M.nextInt();
//            // if (idInput != an id in the database ){
//            //     System.out.println("ID is invalid would you like try again or exit(y/n)");  //will change after database implementation
//            //     if (M.nextLine().equalsIgnoreCase("n")) {
//            //         break;
//            //     }if else(idinput == an id in the database){
//            //     System.out.println("Succesfully logged in")
//            // login  = true;
//            // break;
//            // }
//            break;

//        if ( ==true) {
////            LoyaltyProgram loyalty =  new LoyaltyProgram();
////            System.out.println("Welcome " + getName()+" Your loyalty points are: " + loyalty.getLoyaltypoints());
//            return true;
//        }else{
//            return false;
//        }

}