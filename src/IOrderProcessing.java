public interface IOrderProcessing {
    public  void cancelOrder(int order_id, int student_id);
    public  void confirmOrder(int order_id,int student_id);
    public double getTotalCostOfAllOrders();
}
