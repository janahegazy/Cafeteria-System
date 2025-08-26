public interface IPayment {
    public void makePayment(Student student,int order_id) throws PaymentException;
}
