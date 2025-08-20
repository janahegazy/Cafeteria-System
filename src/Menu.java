import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Menu {
    private List<MenuItem> menuItems;

    public Menu() {
        this.menuItems = new ArrayList<>();
        initializeMenuItems();
    }

    private void initializeMenuItems() {
        // Drinks with realistic Egyptian prices (in EGP)
        menuItems.add(new MenuItem("Coffee", "Traditional Egyptian coffee", 15.00, "Drinks"));
        menuItems.add(new MenuItem("Lemon Juice", "Fresh squeezed lemon juice", 20.00, "Drinks"));
        menuItems.add(new MenuItem("Tea", "Egyptian black tea", 10.00, "Drinks"));
        menuItems.add(new MenuItem("Cappuccino", "Italian style cappuccino", 25.00, "Drinks"));
        menuItems.add(new MenuItem("Regular Coffee", "Filter coffee", 12.00, "Drinks"));
        menuItems.add(new MenuItem("Iced Coffee", "Chilled coffee with ice", 22.00, "Drinks"));
        menuItems.add(new MenuItem("Espresso", "Strong espresso shot", 18.00, "Drinks"));
        menuItems.add(new MenuItem("Water", "Bottled mineral water", 5.00, "Drinks"));
        menuItems.add(new MenuItem("Karkadeh", "Traditional hibiscus tea", 15.00, "Drinks"));
        menuItems.add(new MenuItem("Sahlab", "Warm winter drink", 18.00, "Drinks"));

        // Desserts with realistic Egyptian prices
        menuItems.add(new MenuItem("Chocolate Cake", "Rich chocolate cake", 35.00, "Desserts"));
        menuItems.add(new MenuItem("Vanilla Cake", "Classic vanilla cake", 30.00, "Desserts"));
        menuItems.add(new MenuItem("Lotus Donut", "Donut with lotus spread", 25.00, "Desserts"));
        menuItems.add(new MenuItem("Tiramisu", "Italian coffee-flavored dessert", 40.00, "Desserts"));
        menuItems.add(new MenuItem("Cookies", "Assorted cookies", 20.00, "Desserts"));
        menuItems.add(new MenuItem("Basbousa", "Semolina sweet cake", 18.00, "Desserts"));
        menuItems.add(new MenuItem("Konafa", "Traditional cheese pastry", 45.00, "Desserts"));

        // Sandwiches with realistic Egyptian prices
        menuItems.add(new MenuItem("Burger", "Beef burger with fries", 55.00, "Sandwiches"));
        menuItems.add(new MenuItem("Cheese Sandwich", "Grilled cheese sandwich", 25.00, "Sandwiches"));
        menuItems.add(new MenuItem("Chicken Sandwich", "Grilled chicken sandwich", 35.00, "Sandwiches"));
        menuItems.add(new MenuItem("Falafel", "Traditional Egyptian falafel", 15.00, "Sandwiches"));
        menuItems.add(new MenuItem("Shawarma", "Chicken or beef shawarma", 40.00, "Sandwiches"));
        menuItems.add(new MenuItem("Kofta Sandwich", "Grilled kofta sandwich", 45.00, "Sandwiches"));

        // Traditional Egyptian dishes
        menuItems.add(new MenuItem("Ful Medames", "Cooked fava beans", 15.00, "Main Courses"));
        menuItems.add(new MenuItem("Molokhia", "Green soup with rice", 30.00, "Main Courses"));
        menuItems.add(new MenuItem("Mahshi", "Stuffed vegetables", 35.00, "Main Courses"));
    }

    public List<MenuItem> getMenuItems() {
        return new ArrayList<>(menuItems);
    }

    public List<MenuItem> getAvailableItems() {
        return new ArrayList<>(menuItems);
    }

    public List<MenuItem> getMenuByCategory(String category) {
        if (category == null || category.trim().isEmpty()) {
            throw new IllegalArgumentException("Category cannot be null or empty");
        }
        return menuItems.stream()
                .filter(item -> item.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());
    }

    public Optional<MenuItem> findItemByName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        return menuItems.stream()
                .filter(item -> item.getName().equalsIgnoreCase(name))
                .findFirst();
    }

    public List<String> getCategories() {
        return menuItems.stream()
                .map(MenuItem::getCategory)
                .distinct()
                .collect(Collectors.toList());
    }

    public void displayFullMenu() {
        System.out.println("\n=== EGYPT CAFETERIA - FULL MENU ===");

        for (String category : getCategories()) {
            displayMenuByCategory(category);
            System.out.println();
        }
    }

    public void displayMenuByCategory(String category) {
        List<MenuItem> categoryItems = getMenuByCategory(category);
        if (categoryItems.isEmpty()) {
            System.out.println("No items found in category: " + category);
            return;
        }

        System.out.println("=== " + category.toUpperCase() + " ===");
        System.out.println("----------------------------------------");

        for (MenuItem item : categoryItems) {
            System.out.printf("%-25s %-40s %5.2f EGP%n",
                    item.getName(),
                    item.getDescription(),
                    item.getPrice());
        }
    }

    public void displayDrinksMenu() {
        displayMenuByCategory("Drinks");
    }

    public void displayDessertsMenu() {
        displayMenuByCategory("Desserts");
    }

    public void displaySandwichesMenu() {
        displayMenuByCategory("Sandwiches");
    }

    public void displayMainCoursesMenu() {
        displayMenuByCategory("Main Courses");
    }
}