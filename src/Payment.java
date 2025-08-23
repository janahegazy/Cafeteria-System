import java.util.Scanner;

public class Payment implements IPayment{
    Scanner scanner=new Scanner(System.in);
OrderProcessing orderProcessing;
    public String getCardNumber() {
        return cardNumber;
    }

    private String cardNumber;
    private String cardPassword;
    @Override
    public void makePayment() throws PaymentException {
        System.out.println("choose the payment method 1. cash on cashier 2.make payment with credit card");
        int chosenNum=scanner.nextInt();
        if (chosenNum == 1) {
            System.out.println("your order is placed! the total cost is "+orderProcessing.getTotalCostOfAllOrders());
        }
        System.out.println("Enter the card number and card password:");
        cardNumber=scanner.next();
        cardPassword=scanner.next();
        failedPayment(cardNumber,cardPassword);
        //if the length of the card number and password are correct we have to check if they match the student data
    }
    public void failedPayment(String cardNumber,String  cardPassword) throws PaymentException{
        if (cardNumber.length()<16 ||cardNumber.length()>16){
            throw new PaymentException("The length must be 16 digits!");
        } else if (cardPassword.length()<4 ||cardPassword.length()>4) {
            throw new PaymentException("The length must be 4 digits!");

        }
    }
}
