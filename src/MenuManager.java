import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MenuManager implements User {
    //there is a problem which is i have to make new Menu class to display the available items and at the same time allows the manager to edit the menu
    // i cannot make the menuManager edit the MenuItem class because the relation should be composition and i need to make OrderProcessor
    // able to use the MenuItem class and if the relation was composition it will be unable to happen bec. i have to make student deal with MenuManager Class and
    //it is not logic so instead, we will create Menu class to be composed with the MenuManager

    private int id;
    private String name;
    private String type;
    private Menu menu; // Composition relationship with Menu

    public MenuManager() {
        this.menu = new Menu();
    }

    public MenuManager(Menu menu) {
        this.menu = menu;
    }

    public void addItem(MenuItem item) {
        if (item == null) {
            throw new IllegalArgumentException("Menu item cannot be null");
        }
        if (menu.findItemByName(item.getName()).isPresent()) {
            throw new IllegalArgumentException("Menu item with name " + item.getName() + " already exists");
        }
        menu.getMenuItems().add(item);
    }

    public void editItem(String name, String newDescription, double newPrice, String newCategory) {
        MenuItem item = menu.findItemByName(name).orElseThrow(() ->
                new IllegalArgumentException("Menu item with name " + name + " not found"));
        item.setDescription(newDescription);
        item.setPrice(newPrice);
        item.setCategory(newCategory);
    }

    public void removeItem(String name) {
        boolean removed = menu.getMenuItems().removeIf(item -> item.getName().equalsIgnoreCase(name));
        if (!removed) {
            throw new IllegalArgumentException("Menu item with name " + name + " not found");
        }
    }

    public Menu getMenu() {
        return menu;
    }

    public int getID() {
        return id;
    }

    public String getName(){
        return name;
    }

    public String getType(){
        return type;
    }
}