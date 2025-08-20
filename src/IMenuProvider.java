import java.util.List;

public interface IMenuProvider {
    public String addItemtoOrder(int order_id,int student_id,MenuItem item);
    public String removeItemFromOrder(int order_id,int student_id,MenuItem item);
    public  void confirmOrder(int order_id,int student_id);
    public  void cancelOrder(int order_id, int student_id);

}