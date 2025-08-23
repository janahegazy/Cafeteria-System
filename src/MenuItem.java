import java.util.List;

public class MenuItem {
    private String name;
    private String description;
    private double price;
    private String category;

    public int getNumOfItemleft() {
        return numOfItemleft;
    }

    public void setNumOfItemleft(int numOfItemleft) {
        this.numOfItemleft = numOfItemleft;
    }

    private int numOfItemleft;

    public MenuItem(String name, String description, double price, String category,int numOfItemleft) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Menu item name cannot be null or empty");
        }
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        if (category == null || category.trim().isEmpty()) {
            throw new IllegalArgumentException("Category cannot be null or empty");
        }
        this.name = name;
        this.description = description != null ? description : "";
        this.price = price;
        this.category = category;
        this.numOfItemleft=numOfItemleft;
    }

    public MenuItem() {

    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public void setDescription(String description) {
        this.description = description != null ? description : "";
    }

    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        this.price = price;
    }

    public void setCategory(String category) {
        if (category == null || category.trim().isEmpty()) {
            throw new IllegalArgumentException("Category cannot be null or empty");
        }
        this.category = category;
    }

    @Override
    public String toString() {
        return String.format("MenuItem{name='%s', description='%s', price=%.2f, category='%s,number of item left='%s'}",
                name, description, price, category,numOfItemleft);
    }


}