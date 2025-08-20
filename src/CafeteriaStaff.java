public class CafeteriaStaff implements User{
    private int id;
    private String name;
    private String type;

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
