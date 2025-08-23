import java.util.List;

public class DisplaySoldOutItem implements IDisplaySoldOutItem{
    Menu menuItem;

    @Override
    public void showSoldOutItem() {
        for (MenuItem item:menuItem.getMenuItems()){
            if (item.getNumOfItemleft()==0){
                System.out.println("The item "+item.getName()+"is out of stock!");
            }
        }
    }
}
