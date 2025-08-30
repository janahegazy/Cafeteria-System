public class CafeteriaStaff implements User{
    private int id;
    private String name;
    private String type;

    public int getLoyaltypoints() {
        return loyaltypoints;
    }

    public void setLoyaltypoints(int loyaltypoints) {
        this.loyaltypoints = loyaltypoints;
    }

    private int loyaltypoints=0;


    public int getID() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getType() {
        return type;
    }
}
