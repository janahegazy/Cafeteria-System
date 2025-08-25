import java.util.List;
import java.util.Scanner;
import java.sql.*;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/Cafeteria_System";
        String user = "root"; // your MySQL username
        String password = "janahegazy2372005"; // your MySQL password

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            if (conn != null) {
                System.out.println("✅ Connected to the database!");
            }
        } catch (SQLException e) {
            System.out.println("❌ Connection failed!");
            e.printStackTrace();
        }

             //all the comments are code with no problem
//                // إنشاء المنيو والمدير
                Menu menu = new Menu();
                MenuManager manager = new MenuManager(menu);

                System.out.println("=== عرض المنيو الكامل ===");
                menu.displayFullMenu();

                // نجرب إضافة صنف جديد للمنيو
                MenuItem newItem = new MenuItem("Pizza", "Cheese Pizza", 90.0, "Main Courses", 3);
                manager.addItem(newItem);
                System.out.println("\nبعد إضافة بيتزا:");
                menu.displayFullMenu();

                // نجرب أوردر لطالب
                Student student = new Student("Jana", 1,"1/5/2025","student",3,4);
                OrderItem orderItem = new OrderItem();
                OrderProcessing orderProcessing = new OrderProcessing(orderItem);

                // إضافة عنصر للأوردر
                System.out.println("\n=== نجرب نضيف عنصر للأوردر ===");
                System.out.println("the points of the student ="+student.getPoints());

                MenuItem coffee = menu.findItemByName("Coffee").get();
                System.out.println(orderItem.addItemtoOrder(student.getName(), 1001, student.getID(), student.getPoints(), coffee));
                MenuItem tiramisu = menu.findItemByName("Tiramisu").get();
                System.out.println(orderItem.addItemtoOrder(student.getName(), 1001, student.getID(), student.getPoints(), tiramisu));
                 System.out.println(tiramisu.getNumOfItemleft());
                // تأكيد الأوردر
//                orderProcessing.confirmOrder(1001, student.getID());
        System.out.println("the total price of the order=");
        System.out.println(orderItem.getTotalCostOfOneOrder(1001));

//                // إلغاء أوردر (هيشيل من اللست)
//                orderProcessing.cancelOrder(1001, student.getID());

                // نجرب مكافآت الولاء (reward)
                LoyaltyProgram loyaltyProgram = new LoyaltyProgram();
                loyaltyProgram.checkOrderAchievements(student, orderItem.getTotalCostOfOneOrder(1001));

                OrderItem orderItem1=new OrderItem();
        MenuItem tea = menu.findItemByName("tea").get();
        System.out.println(orderItem.addItemtoOrder(student.getName(), 1002, student.getID(), student.getPoints(), tea));
        MenuItem burger = menu.findItemByName("Burger").get();
        System.out.println(orderItem.addItemtoOrder(student.getName(), 1002, student.getID(), student.getPoints(), burger));
        System.out.println(burger.getNumOfItemleft());



        orderProcessing.confirmOrder(1001, student.getID());
        orderProcessing.confirmOrder(1002, student.getID());

        System.out.println("Total cost of all orders = " + orderProcessing.getTotalCostOfAllOrders());

        System.out.println(orderProcessing.getTotalCostOfAllOrders());
                // عرض العناصر اللي خلصت
                System.out.println("\n=== عناصر خلصت ===");
                for (MenuItem item : menu.getMenuItems()) {
                    if (item.getNumOfItemleft() == 0) {
                        System.out.println(item.getName() + " is SOLD OUT!");
                    }
                }

                System.out.println("\n=== السيستم شغال! ===");
        MenuItem sahlab = menu.findItemByName("Sahlab").get();
        System.out.println(orderItem.addItemtoOrder(student.getName(), 1003, student.getID(), student.getPoints(), sahlab));
        MenuItem chickensandwich = menu.findItemByName("Chicken sandwich").get();
        System.out.println(orderItem.addItemtoOrder(student.getName(), 1003, student.getID(), student.getPoints(), chickensandwich));

        System.out.println(chickensandwich.getNumOfItemleft());

        orderProcessing.confirmOrder(1003, student.getID());

        System.out.println("Total cost of all orders = " + orderProcessing.getTotalCostOfAllOrders());

        System.out.println(orderProcessing.getTotalCostOfAllOrders());
        System.out.println(orderItem.addItemtoOrder(student.getName(), 1003, student.getID(), student.getPoints(), chickensandwich));
        orderProcessing.confirmOrder(1003, student.getID());

        System.out.println("Total cost of all orders = " + orderProcessing.getTotalCostOfAllOrders());

        System.out.println(orderProcessing.getTotalCostOfAllOrders());







    }
        }











//        try {
//            menuManager.addItem(new MenuItem("Coffee", "Black Coffee", 20.0, "Drink"));
//            menuManager.addItem(new MenuItem("Sandwich", "Chicken Sandwich", 50.0, "Main Course"));
//            menuManager.addItem(new MenuItem("Coke", "Chilled Coca-Cola", 15.0, "Drink"));
//            System.out.println("Items added successfully!");
//        } catch (IllegalArgumentException e) {
//            System.out.println("Error: " + e.getMessage());
//        }
//
//        System.out.println("\nFull Menu:");
//        List<MenuItem> menu = menuManager.getMenu();
//        menu.forEach(System.out::println);
//
//        System.out.println("\nDrinks Menu:");
//        List<MenuItem> drinks = menuManager.getMenuByCategory("Drink");
//        drinks.forEach(System.out::println);
//
//        try {
//            menuManager.editItem("Coffee", "Espresso Coffee", 25.0, "Drink");
//            System.out.println("\nCoffee updated!");
//            System.out.println("Updated Menu:");
//            menuManager.getMenu().forEach(System.out::println);
//        } catch (IllegalArgumentException e) {
//            System.out.println("Error: " + e.getMessage());
//        }
//
//        try {
//            menuManager.removeItem("Coke");
//            System.out.println("\nCoke removed!");
//            System.out.println("Updated Menu:");
//            menuManager.getMenu().forEach(System.out::println);
//        } catch (IllegalArgumentException e) {
//            System.out.println("Error: " + e.getMessage());
//        }
//
//        System.out.println("\nAvailable Categories:");
//        List<String> categories = menuManager.getCategories();
//        categories.forEach(System.out::println);
//
//        scanner.close();
//    }
//}