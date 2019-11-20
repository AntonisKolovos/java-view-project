package ippo.assignment2;

import java.util.ArrayList;
import java.util.HashMap;
import javafx.scene.image.Image;
public class Player {
    private String currentLocation;
    private int currentDirection;
    private ArrayList<Item> itemList= new ArrayList<Item>();


    public Player(String location,int direction){
        this.currentDirection=direction;
        this.currentLocation=location;
        Image icon = new Image("Pen.png");

        Item item = new Item(icon,"Pen");
        itemList.add(item);
        icon = new Image("Cup.png");
        item = new Item(icon,"Cup");
        itemList.add(item);

        icon = new Image("cat.png");
        item= new Item(icon,"Cat");
        itemList.add(item);



    }
    public int getCurrentDirection() {
        return currentDirection;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentDirection(int currentDirection) {
        this.currentDirection = currentDirection;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }

    public void addItem(Item item){
        itemList.add(item);
    }
    public void dropItem(Item item){
        itemList.remove(item);

    }

    public ArrayList<Item> getItems(){
        return itemList;


    }

}
