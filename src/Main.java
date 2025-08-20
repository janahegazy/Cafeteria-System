import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MenuManager menuManager = new MenuManager();
        Scanner scanner = new Scanner(System.in);

        try {
            menuManager.addItem(new MenuItem("Coffee", "Black Coffee", 20.0, "Drink"));
            menuManager.addItem(new MenuItem("Sandwich", "Chicken Sandwich", 50.0, "Main Course"));
            menuManager.addItem(new MenuItem("Coke", "Chilled Coca-Cola", 15.0, "Drink"));
            System.out.println("Items added successfully!");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nFull Menu:");
        List<MenuItem> menu = menuManager.getMenu();
        menu.forEach(System.out::println);

        System.out.println("\nDrinks Menu:");
        List<MenuItem> drinks = menuManager.getMenuByCategory("Drink");
        drinks.forEach(System.out::println);

        try {
            menuManager.editItem("Coffee", "Espresso Coffee", 25.0, "Drink");
            System.out.println("\nCoffee updated!");
            System.out.println("Updated Menu:");
            menuManager.getMenu().forEach(System.out::println);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            menuManager.removeItem("Coke");
            System.out.println("\nCoke removed!");
            System.out.println("Updated Menu:");
            menuManager.getMenu().forEach(System.out::println);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nAvailable Categories:");
        List<String> categories = menuManager.getCategories();
        categories.forEach(System.out::println);

        scanner.close();
    }
}