public interface IOrderItem {
    public String addItemtoOrder(String name,int order_id,int student_id,int points,MenuItem item);
    public String removeItemFromOrder(int order_id,int student_id,MenuItem item);
    public boolean soldOutItem(MenuItem item);
    public double getTotalCostOfOneOrder(int order_id);
}
