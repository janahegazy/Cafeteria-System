import java.util.List;

public interface IMenuProvider {
    List<MenuItem> getMenu();
    List<MenuItem> getMenuByCategory(String category);
}