import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MenuManager implements IMenuProvider {
    private List<MenuItem> menuItems;


    public MenuManager() {
        this.menuItems = new ArrayList<>();
    }

    public void addItem(MenuItem item) {
        if (item == null) {
            throw new IllegalArgumentException("Menu item cannot be null");
        }
        if (findItemByName(item.getName()).isPresent()) {
            throw new IllegalArgumentException("Menu item with name " + item.getName() + " already exists");
        }
        menuItems.add(item);
    }

    public void editItem(String name, String newDescription, double newPrice, String newCategory) {
        MenuItem item = findItemByName(name).orElseThrow(() ->
                new IllegalArgumentException("Menu item with name " + name + " not found"));
        item.setDescription(newDescription);
        item.setPrice(newPrice);
        item.setCategory(newCategory);
    }

    public void removeItem(String name) {
        boolean removed = menuItems.removeIf(item -> item.getName().equalsIgnoreCase(name));
        if (!removed) {
            throw new IllegalArgumentException("Menu item with name " + name + " not found");
        }
    }

    @Override
    public List<MenuItem> getMenu() {
        return new ArrayList<>(menuItems);
    }

    @Override
    public List<MenuItem> getMenuByCategory(String category) {
        if (category == null || category.trim().isEmpty()) {
            throw new IllegalArgumentException("Category cannot be null or empty");
        }
        return menuItems.stream()
                .filter(item -> item.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());
    }

    private Optional<MenuItem> findItemByName(String name) {
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
}