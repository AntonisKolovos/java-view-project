package ippo.assignment2;

import javafx.scene.image.Image;
import java.util.ArrayList;
import java.util.HashMap;

public class Location {
    private String name ;
    private ArrayList<Direction> views= new ArrayList<Direction>(4);
    private int noDirections;
    private ArrayList<Item> itemList = new ArrayList<Item>();

    public Location(String name,int noDirections){
        this.name=name;
        this.noDirections=noDirections;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNoDirections(int noDirections) {
        this.noDirections = noDirections;
    }

    public void addDirection(Direction newDirection){
        views.add(newDirection.getDirection(), newDirection);

    }

    public Image getDirectionImage(int direction){
        return views.get(direction).getView();
    }

    public int turn(int currDirection,int offset){
        int newDir = (currDirection+offset)%noDirections;
        //Modulus in java returns a negative number for negative inputs, so we adjust
        if (newDir<0){
            newDir+=noDirections;
        }
        return views.get(newDir).getDirection();
    }

    public String getNextLocation(int direction){
        return views.get(direction).getNextLocation();
    }

    public ArrayList<Item> getItemList(){
        return itemList;
    }

    public void addItem(Item item){
        itemList.add(item);

    }

    public void removeItem(Item item) {
        itemList.remove(item);
    }


}
